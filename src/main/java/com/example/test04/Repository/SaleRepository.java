package com.example.test04.Repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import com.example.test04.Entity.SaleId;
import com.example.test04.Entity.Sales;
import com.example.test04.Entity.Seller;

public interface SaleRepository extends JpaRepository<Sales,SaleId> {

       @Query("SELECT c.nameSeller, SUM(s.doanh_so) FROM Sales s JOIN s.seller c ON s.sale.saleDate BETWEEN :startDate AND :endDate WHERE c.team.nameTeam =:name GROUP BY c.nameSeller" )
       List<Object[]> findByDateBetweenAndUserId(@Param("startDate") LocalDate startDate,
                                                 @Param("endDate") LocalDate endDate,
                                                 @Param("name") Long teamId);  
                                            
}

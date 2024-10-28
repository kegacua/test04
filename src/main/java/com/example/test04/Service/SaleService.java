package com.example.test04.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.test04.Repository.SaleRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    @Cacheable(value = "saleCache", key = "#startDate + '_' + #endDate + '_' + #teamId", unless = "#result == null")
    public Map<String, Object> getSalesData(LocalDate startDate, LocalDate endDate, Long teamId) {
        List<Object[]> results = saleRepository.findByDateBetweenAndUserId(startDate, endDate, teamId);
        BigDecimal totalSales = BigDecimal.ZERO;
        
        List<Map<String, Object>> salesDetails = new ArrayList<>();

        for (Object[] result : results) {
            totalSales = totalSales.add((BigDecimal) result[1]);
            Map<String, Object> detail = new HashMap<>();
            detail.put("employeeName", result[0]);
            detail.put("salesAmount", result[1]);
            salesDetails.add(detail);
        }
       

        Map<String, Object> response = new HashMap<>();
        response.put("totalSales", totalSales);
        response.put("salesDetails", salesDetails);
        response.put("totalRecords", results.size());

        return response;
    }
}

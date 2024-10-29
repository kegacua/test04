package com.example.test04.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//@IdClass(SaleId.class)
public class Sales {

    @EmbeddedId
    private SaleId sale;
    // @Id
    // private Long sellerId;
    // @Id
    // private LocalDate saleDate;
    private Long doanh_so;

    @ManyToOne
    @MapsId("sellerId")
    @JoinColumn(name = "seller_id")
    //@JoinColumn(name = "seller_id", insertable = false, updatable = false)
    private Seller seller;



}

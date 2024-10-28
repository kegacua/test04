package com.example.test04.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable

public class SaleId implements Serializable{
    private Long sellerId;
    private LocalDate saleDate;

    @Override
    public boolean equals(Object o) {
       if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleId saleId = (SaleId) o;
        return Objects.equals(sellerId, saleId.sellerId) &&
               Objects.equals(saleDate, saleId.saleDate);
    }
    @Override
    public int hashCode() {
        return Objects.hash(sellerId, saleDate);
    }



}

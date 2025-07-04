package org.example.model;
import java.time.LocalDate;
public class ExpiredProduct extends Product {
    LocalDate expiredDate;
    public ExpiredProduct(String name, Double price, LocalDate expiredDate) {
        super(name, price);
        this.expiredDate = expiredDate;
    }
    @Override
    public Boolean isExpired() {
        return expiredDate.isBefore(LocalDate.now());
    }

}

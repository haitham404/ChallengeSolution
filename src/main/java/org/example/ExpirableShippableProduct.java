package org.example;

import java.time.LocalDate;

public class ExpirableShippableProduct extends ExpiredProduct implements Shippale{
   private Double weight;
    public ExpirableShippableProduct(String name, Double price,LocalDate expiredDate, Double weight) {
        super(name, price,expiredDate);
        this.weight = weight;
    }
    @Override
    public Double getWeight() {
        return weight;
    }
    public Double totalPrice() {
        return this.weight * pricePerGram;
    }
    @Override
    public Boolean isShippable() {
        return true;
    }
    @Override
    public Boolean isExpired() {
        return expiredDate.isBefore(LocalDate.now());
    }
}

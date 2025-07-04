package org.example.model;

public class ShippableProduct extends Product implements Shippale {

  private  Double weight;

    public ShippableProduct(String name, Double price, Double weight) {
        super(name, price);
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



}

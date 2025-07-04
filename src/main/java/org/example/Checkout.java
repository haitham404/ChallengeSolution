package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Checkout {
    public Checkout(Customer customer, Cart cart) throws Exception {
      Double subtotal= ShipmentNotice();
      Double weightShipping= checkouReceipt()*Shippale.pricePerGram;

      Double totalPrice=(subtotal+weightShipping);
        System.out.println("subtotal"+"               "+subtotal);
        System.out.println("shipping"+"               "+weightShipping);
        System.out.println("total price"+"               "+totalPrice);


        if(customer.getBalance()<totalPrice) throw new Exception();


    }


    private Double checkouReceipt() {
        System.out.println("** Checkout receipt **");
        Double subTotalPrice = 0.0;
        List<Pair> checkouReceipt = Cart.getListProduct_Price();
        for (Pair pair : checkouReceipt) {
            Double price = pricePerUnit(pair.getName(), getThemap());
            int quantity = pair.getQuantity();
            System.out.println(quantity + "x " + pair.getName() + " " +(quantity * price));
            subTotalPrice = subTotalPrice + (quantity * price);
        }
        return subTotalPrice;
    }
    private Double ShipmentNotice() {
        System.out.println("** Shipment notice **");
        List<Pair> ShipmentNotice = ShippingService.getListMyShippingProduct();
        Double weightSum = 0.0;
        for (Pair pair : ShipmentNotice) {
            Double weightIngrams = weightIngrams(pair.getName(), this.getThemap());
            int quantity = pair.getQuantity();
            System.out.println(quantity + "x " + pair.getName() +" " + (quantity * weightIngrams) + "g");
            weightSum += (quantity * weightIngrams);
        }
        System.out.println("Total Weight: " + weightSum);
        return  weightSum;
    }

    private Map<Product, Integer> getThemap() {
        return Cart.getProductsInCart();
    }

    private Double weightIngrams(String name, Map<Product, Integer> map) {
        for (Product product : map.keySet()) {
            if (product.getName().equals(name) && product instanceof Shippale) {
                return ((Shippale) product).getWeight();
            }
        }
        return null;
    }

    private Double pricePerUnit(String name, Map<Product, Integer> map) {
        for (Product product : map.keySet()) {
            if (product.getName().equals(name)) {
                return product.getPrice();
            }
        }

        return null;
    }

}


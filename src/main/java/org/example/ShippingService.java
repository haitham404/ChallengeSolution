package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShippingService {

    private static List<Pair>listMyShippingProduct=new ArrayList<>();
    public ShippingService(List<Shippale> shippale_list, Map<Product, Integer> productsInCart ) {
            for(Shippale shippale: shippale_list) {
                if(productsInCart.containsKey(shippale)) {
                    listMyShippingProduct.add(new Pair(shippale.getName(),productsInCart.get(shippale)));
                }
            }
    }
    public static List<Pair> getListMyShippingProduct() {
        return listMyShippingProduct;
    }
}

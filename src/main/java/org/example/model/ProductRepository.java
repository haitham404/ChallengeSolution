package org.example.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
     private static Map<Product,Integer> map = new HashMap<>();
    public ProductRepository(){
//        LocalDate expireCheese = LocalDate.of(2025,12,1);
//        Product cheese =new ExpirableShippableProduct("cheese",30.0,expireCheese,20.0);
//        map.put(cheese,10);
        LocalDate expireCheese = LocalDate.of(2023,12,1);
        Product cheese =new ExpirableShippableProduct("cheese",30.0,expireCheese,20.0);
        map.put(cheese,10);



        LocalDate expireBiscuits = LocalDate.of(2025,12,1);
        Product biscuits =new ExpiredProduct("Biscuits",10.0,expireBiscuits);
        map.put(biscuits,20);


        Product tv = new ShippableProduct("tv",30.0,100.0);
        map.put(tv,30);

        Product mobile =new Product("mobile",30.0);
        map.put(mobile,30);

        Product mobileScratchCards =new Product("mobileScratchCards",40.0);
        map.put(mobileScratchCards,40);
    }
    public static Map<Product,Integer> getMap() {
        return map;
    }
    public static List<String> listProducts(){
        List<String> list = new ArrayList<>();
        Map<Product,Integer> map = ProductRepository.getMap();
        for(Product product:map.keySet()){
            list.add(product.getName());
        }
        return list;
    }
}

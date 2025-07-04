package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private static List<Pair> listMyProduct_Price = new ArrayList<>();
    private static List<Shippale> shippale_list = new ArrayList<>();
    private static Map<Product,Integer> productsInCart = new HashMap<>();



  public void add(String name, int quantity) throws Exception {
      Map<Product,Integer> allProductsInTheStore = Backend.getMap();


      boolean flag = false;

      for(Product product:allProductsInTheStore.keySet()){
          if(product.getName().equals(name)){
              flag=true;

              if(product instanceof ExpiredProduct){
                  if(product.isExpired()) throw new Exception("Product is Expired");
              }
              if(allProductsInTheStore.get(product)<quantity) throw new Exception("Product Quantity Exceeded");

              int newQuantityInAllMap = allProductsInTheStore.get(product)-quantity;

              int currentQuantity = productsInCart.get(product) != null ? productsInCart.get(product) : 0;
              int newQuantityInCartMap = currentQuantity + quantity;

              productsInCart.put(product,newQuantityInCartMap);
              allProductsInTheStore.put(product,newQuantityInAllMap);

              listMyProduct_Price.add(new Pair(product.getName(),quantity));
              if(product instanceof Shippale){
                  shippale_list.add((Shippale) product);
              }
          }
          
      }
      if(!flag) throw new Exception("Product Not Exist");




}


    public static List<Pair> getListProduct_Price() {
        return listMyProduct_Price;
    }
    public static List<Shippale> getShippale_list() {
      return shippale_list;
    }
    public static Map<Product, Integer> getProductsInCart() {
        return productsInCart;
    }

}

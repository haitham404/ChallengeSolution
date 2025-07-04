package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.example.exception.NotFoundException;
import org.example.model.Cart;
import org.example.model.Customer;
import org.example.service.Checkout;
import org.example.service.ShippingService;
import org.example.model.ProductRepository;
import org.example.exception.ExpiredProductException;
import org.example.exception.OutOfStockException;
import org.example.exception.InsufficientFundsException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        System.out.println("Enter customer balance:");
        Scanner input2 = new Scanner(System.in);
        Double balance = input2.nextDouble();
        Customer customer = new Customer(balance);

        new ProductRepository(); 
        List<String> OurProducts = ProductRepository.listProducts();
        System.out.println("Our products:");
        for(String product : OurProducts){
            System.out.print(product+"  ");
        }
        System.out.println();

        Scanner sc = new Scanner(System.in);

        Cart cart=new Cart();
        while(true){
            System.out.println("enter name of product");
            String nameOfProduct = sc.nextLine();
            if(nameOfProduct.equals("end")){break;}
            System.out.println("enter quantity of product");
            int quantity = sc.nextInt();
            sc.nextLine(); 
            try {
               cart.add(nameOfProduct,quantity);
            } catch (ExpiredProductException | OutOfStockException |NotFoundException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        try {
            new ShippingService(Cart.getShippale_list(), Cart.getProductsInCart());
            new Checkout(customer,cart);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    }

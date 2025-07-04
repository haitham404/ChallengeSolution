# Fawry Rise Journey - E-commerce System

## Overview
This project is a Java-based e-commerce system designed as part of the Fawry Rise Journey Full Stack Development Internship Challenge. It demonstrates core backend concepts such as product management, cart operations, checkout, shipping, and robust error handling using custom exceptions.

## Features
- **Product Management**: Define products with name, price, and quantity.
- **Product Types**:
  - Expirable products (e.g., Cheese, Biscuits)
  - Non-expirable products (e.g., TV, Mobile)
  - Shippable products (e.g., Cheese, TV) with weight
  - Non-shippable products (e.g., Mobile scratch cards)
- **Cart Operations**:
  - Add products to cart with a specific quantity (not exceeding available stock)
  - Prevent adding expired or out-of-stock products
- **Checkout**:
  - Print checkout details: order subtotal, shipping fees, total amount, and customer balance after payment
  - Error handling for empty cart, insufficient balance, expired/out-of-stock products
- **Shipping Service**:
  - Collects all shippable items and calculates total shipping weight and fees
- **Custom Exceptions**:
  - `ExpiredProductException`, `OutOfStockException`, `InsufficientFundsException`

## Project Structure
```
src/main/java/org/example/
├── model/
│   ├── Product.java
│   ├── ExpiredProduct.java
│   ├── ExpirableShippableProduct.java
│   ├── ShippableProduct.java
│   ├── Shippale.java
│   ├── Cart.java
│   ├── Customer.java
│   ├── Backend.java
│   └── Pair.java
├── service/
│   ├── Checkout.java
│   └── ShippingService.java
├── exception/
│   ├── ExpiredProductException.java
│   ├── OutOfStockException.java
│   └── InsufficientFundsException.java
└── Main.java
```


## Usage Example
```
Enter customer balance:
300
Our products:
tv  mobileScratchCards  cheese  Biscuits  mobile  
enter name of product
cheese
enter quantity of product
2
enter name of product
tv
enter quantity of product
3
enter name of product
mobileScratchCards
enter quantity of product
1
enter name of product
end
** Shipment notice **
2x cheese 40.0g
3x tv 300.0g
Total Weight: 340.0
** Checkout receipt **
2x cheese 60.0
3x tv 90.0
1x mobileScratchCards 40.0
subtotal               190.0
shipping               10.2
total price               200.2
```

## Error Handling
- **Expired Product**: Adding an expired product throws `ExpiredProductException`.
- **Out of Stock**: Adding more than available quantity throws `OutOfStockException`.
- **Insufficient Funds**: Checkout with insufficient balance throws `InsufficientFundsException`.
- **Product Not Exist**: Adding a non-existent product throws a generic exception.

## Assumptions
- Product names are unique.
- Shipping fee is calculated as `totalWeight * 0.03`.
- All products and quantities are initialized in `Backend.java`.

## Extending the System
- Add new product types by extending `Product` or implementing `Shippale`.
- Add new business logic in the `service` package.
- Add new exceptions in the `exception` package.

## Video Demo
[![Watch the video](https://img.youtube.com/vi/G_gtaHwssLY/0.jpg)](https://www.youtube.com/watch?v=G_gtaHwssLY)
---
**Author:** Fawry Rise Journey Internship Candidate

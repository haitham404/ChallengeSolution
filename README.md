# Challenge- E-commerce System



## Features
- **Product Management**: Define products with name, price, and quantity.
- **Product Types**:
  - Expirable products (e.g., Cheese, Biscuits)
  - Non-expirable products (e.g., TV, Mobile)
  - Shippable products (e.g., Cheese, TV) with weight
  - Non-shippable products (e.g., Mobile scratch cards)
- **Cart Operations**:
  - Add products to cart with a specific quantity (not exceeding available stock)
  - Prevent adding expired, out-of-stock, or non-existent products
- **Checkout**:
  - Print checkout details: order subtotal, shipping fees, total amount, and customer balance after payment
  - Error handling for empty cart, insufficient balance, expired/out-of-stock/non-existent products
- **Shipping Service**:
  - Collects all shippable items and calculates total shipping weight and fees
- **Custom Exceptions**:
  - `ExpiredProductException`, `OutOfStockException`, `InsufficientFundsException`, `NotFoundException`

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
│   ├── ProductRepository.java
│   └── Pair.java
├── service/
│   ├── Checkout.java
│   └── ShippingService.java
├── exception/
│   ├── ExpiredProductException.java
│   ├── OutOfStockException.java
│   ├── InsufficientFundsException.java
│   └── NotFoundException.java
└── Main.java
```
## UML
<img width="1898" height="1359" alt="Image" src="https://github.com/user-attachments/assets/f2809af4-8da4-4a72-a506-df8c285fa68d" />

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
Product is Expired
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
3x tv 300.0g
Total Weight: 300.0
** Checkout receipt **
3x tv 90.0
1x mobileScratchCards 40.0
subtotal               130.0
shipping               9.0
total price               139.0
```

## Error Handling
- **Expired Product**: Adding an expired product throws `ExpiredProductException`.
- **Out of Stock**: Adding more than available quantity throws `OutOfStockException`.
- **Insufficient Funds**: Checkout with insufficient balance throws `InsufficientFundsException`.
- **Product Not Exist**: Adding a non-existent product throws `NotFoundException`.

## Assumptions
- Product names are unique.
- Shipping fee is calculated as `totalWeight * 0.03`.
- All products and quantities are initialized in `ProductRepository.java`.
- Cheese is now expired by default for demo purposes (expiration date set in the past).

## Extending the System
- Add new product types by extending `Product` or implementing `Shippale`.
- Add new business logic in the `service` package.
- Add new exceptions in the `exception` package.

## Video Demo
https://github.com/user-attachments/assets/131593ed-2fd4-4c2b-910a-d0b00ab578d2



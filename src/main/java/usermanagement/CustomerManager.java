package usermanagement;

import java.util.ArrayList;
import java.util.Scanner;

import productmanagement.Product;
import productmanagement.ProductsManager;
import userinterface.PrintUtils;

public class CustomerManager {

    private ArrayList<Order> orderHistory = new ArrayList<>();
    private ProductsManager productsManager;

    public CustomerManager(ProductsManager productsManager) {
        this.productsManager = productsManager;
    }

    public void browseProducts(Scanner scanner, String productName, int numProducts, int quantity) {
        PrintUtils.println("---- Browse Products ----");
        productsManager.listProducts();

        for (int i = 0; i < numProducts; i++) {
            PrintUtils.println("Enter the product name to add to your cart: ");
            productName = scanner.nextLine();
            Product selectedProduct = findProductByName(productName);

            if (selectedProduct != null) {
                PrintUtils.println("Enter the quantity for " + selectedProduct.getName() + ": ");
                quantity = Integer.parseInt(scanner.nextLine());

                orderHistory.add(new Order(selectedProduct, quantity));
                PrintUtils.println("Added to your cart: " + selectedProduct.getName() + " (Quantity: " + quantity + ")");
            } else {
                PrintUtils.println("Product not found. Please enter a valid product name.");
            }
        }
        PrintUtils.println("Your order has been placed successfully!");
    }

    private Product findProductByName(String productName) {
        for (Product product : productsManager.getProductList()) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null; // Product not found
    }

    
    
    //filtering search 
    public void searchProducts(Scanner scanner, String searchKeyword, int numProducts, int quantity) {
        PrintUtils.println("---- Search Products ----");

        ArrayList<Product> matchingProducts = new ArrayList<>();
        for (Product product : productsManager.getProductList()) {
            if (product.getName().toLowerCase().startsWith(searchKeyword)) {
                matchingProducts.add(product);
            }
        }

        if (matchingProducts.isEmpty()) {
            PrintUtils.println("No matching products found.");
            return;
        }

        PrintUtils.println("Matching Products:");
        for (int i = 0; i < matchingProducts.size(); i++) {
            PrintUtils.println((i + 1) + ". " + matchingProducts.get(i).getName());
        }

        for (int i = 0; i < numProducts; i++) {
            PrintUtils.println("Enter the product number to add to your cart: ");
            int productNumber = Integer.parseInt(scanner.nextLine());
            Product selectedProduct = matchingProducts.get(productNumber - 1);

            PrintUtils.println("Enter the quantity for " + selectedProduct.getName() + ": ");
            quantity = Integer.parseInt(scanner.nextLine());

            orderHistory.add(new Order(selectedProduct, quantity));
            PrintUtils.println("Added to your cart: " + selectedProduct.getName() + " (Quantity: " + quantity + ")");
        }
        PrintUtils.println("Your order has been placed successfully!");
    }

    
    
    
    
    public void viewOrderHistory() {
        PrintUtils.println("---- Order History ----");
        if (orderHistory.isEmpty()) {
            PrintUtils.println("No order history available.");
            return;
        }

        for (Order order : orderHistory) {
            PrintUtils.println("Product: " + order.getProduct().getName() +
                    " | Quantity: " + order.getQuantity() +
                    " | Total Cost: $" + order.getTotalCost());
        }
    }

    private class Order {
        private Product product;
        private int quantity;

        public Order(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public Product getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getTotalCost() {
            return product.getCost() * quantity;
        }
    }
}
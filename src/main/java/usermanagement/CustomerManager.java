package usermanagement;

import java.util.ArrayList;
import java.util.Scanner;

import productmanagement.Product;
import productmanagement.ProductsManager;
import userinterface.PrintUtils;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class CustomerManager {

    private ArrayList<Order> orderHistory = new ArrayList<>();
    private ProductsManager productsManager;

    public CustomerManager(ProductsManager productsManager) {
        this.productsManager = productsManager;
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
    
    
    


    
    
    public void browseProducts(Scanner scanner, String productName, int quantity, String customerEmail) {
        PrintUtils.println("---- Browse Products ----");
        productsManager.listProducts();

        PrintUtils.println("Enter the product name to add to your cart: ");
        productName = scanner.nextLine();
        Product selectedProduct = findProductByName(productName);

        if (selectedProduct != null) {
            PrintUtils.println("Enter the quantity for " + selectedProduct.getName() + ": ");
            quantity = Integer.parseInt(scanner.nextLine());

            if (quantity > selectedProduct.getQuantity()) {
                PrintUtils.println("Not enough stock available for the selected quantity.");
            } else {
                // Subtract the purchased quantity from the original quantity
                selectedProduct.setQuantity(selectedProduct.getQuantity() - quantity);

                orderHistory.add(new Order(selectedProduct, quantity));
                PrintUtils.println("Added to your cart: " + selectedProduct.getName() + " (Quantity: " + quantity + ")");
                PrintUtils.println("Your order has been placed successfully!");
                sendOrderConfirmationEmail(customerEmail);
            }
        } else {
            PrintUtils.println("Product not found. Please enter a valid product name.");
        }
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

   

    
    public void viewInstallationRequestsHistory(InstallerManagement installerManagement, Scanner scanner) {
        installerManagement.viewAppointments();

        // Ask the user if they want to book an appointment
        PrintUtils.println("Do you want to request installation services? (yes/no): ");
        String answer = scanner.nextLine().toLowerCase();

        if ("yes".equals(answer)) {
            // ask the user for details and book the appointment
            PrintUtils.println("Enter the appointment number to book: ");
            int appointmentNumber = Integer.parseInt(scanner.nextLine());
            // Ask the user for details
            PrintUtils.println("Enter your name: ");
            String customerName = scanner.nextLine();
            PrintUtils.println("Enter your phone number: ");
            String phoneNumber = scanner.nextLine();
            PrintUtils.println("Enter the reason for the request: ");
            String reason = scanner.nextLine();

            // Display available installers
            PrintUtils.println("Choose an installer:");
            PrintUtils.println("1. Jood Hamdallah (jood.hamdallah12@gmail.com)");
            PrintUtils.println("2. Sawalha Saleh (sawalha.saleh3@gmail.com)");

            // Get user's choice
            int installerChoice = Integer.parseInt(scanner.nextLine());
            String installerEmail;

            // Determine installer email based on users choice
            if (installerChoice == 1) {
                installerEmail = "jood.hamdallah12@gmail.com";
            } else if (installerChoice == 2) {
                installerEmail = "sawalha.saleh3@gmail.com";
            } else {
                PrintUtils.println("Invalid installer choice. Request canceled.");
                return;
            }

            // Book the installation request
            installerManagement.requestInstallation(customerName, phoneNumber, reason, installerEmail);

            // Send email notification
            sendInstallationRequestEmail(customerName, phoneNumber, reason, installerEmail);

            PrintUtils.println("Installation request sent successfully!");
        }
    }

    public void sendInstallationRequestEmail(String customerName, String phoneNumber, String reason, String installerEmail) {
        // Replace the following placeholders with your actual email sending logic
        String subject = "Installation Request";
        String body = "Name: " + customerName + "\nPhone Number: " + phoneNumber +
                      "\nReason: " + reason + "\nInstaller Email: " + installerEmail;

        // You can use the EmailSender class or any other method to send the email
        EmailSender.sendEmail(installerEmail, subject, body);
    }
            
            
              
            
            public void sendOrderConfirmationEmail(String customerEmail) {
                // Replace the following placeholders with your actual email sending logic
                String subject = "Order Confirmation";
                String body = "Thank you for your order! Your order has been placed successfully.";

                // You can use the EmailSender class or any other method to send the email
                EmailSender.sendEmail(customerEmail, subject, body);
            }

            
            
            
            
public class EmailSender {

    public static void sendEmail(String to, String subject, String body) {
        final String username = "gameboxjsd2023@gmail.com"; // replace with your email
        final String password = "pidj svlq nxel nohb"; // replace with your email password

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); // replace with your SMTP server
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}


}


        
    

    
  
    



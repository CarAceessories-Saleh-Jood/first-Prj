package userinterface;

import java.util.Scanner;

import productmanagement.ProductsManager;
import usermanagement.CustomerManager;
public class Main {

    public static void main(String[] args) {
        ProductsManager productsManager = new ProductsManager();
        CustomerManager customerManager = new CustomerManager(productsManager);

        Scanner scanner = new Scanner(System.in);
        int choice;

        String productName = "";
        int numProducts = 0;
        int quantity = 0;
        String searchKeyword = "";

        do {
            PrintUtils.println("1. Browse Products");
            PrintUtils.println("2. Search Products");
            PrintUtils.println("3. View Order History");
            PrintUtils.println("4. Exit");
            PrintUtils.println("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        PrintUtils.println("Enter the number of products you want to buy: ");
                        numProducts = Integer.parseInt(scanner.nextLine());
                        customerManager.browseProducts(scanner, productName, numProducts, quantity);
                        break;
                    case 2:
                        PrintUtils.println("Enter the name of the product: ");
                        searchKeyword = scanner.nextLine().toLowerCase();
                        PrintUtils.println("Enter the number of products you want to buy: ");
                        numProducts = Integer.parseInt(scanner.nextLine());
                        PrintUtils.println("Enter the quantity for the product: ");
                        quantity = Integer.parseInt(scanner.nextLine());
                        customerManager.searchProducts(scanner, searchKeyword, numProducts, quantity);
                        break;
                    case 3:
                        customerManager.viewOrderHistory();
                        break;
                    case 4:
                        PrintUtils.println("Exiting the application. Goodbye!");
                        break;
                    default:
                        PrintUtils.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                PrintUtils.println("Invalid input. Please enter a number.");
                choice = 0; 
            }

        } while (choice != 4);

        scanner.close();
    }
}

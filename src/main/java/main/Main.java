package main;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import productmanagement.CategoriesManager;
import productmanagement.ProductsManager;
import requestsmanagement.Appointment;
import productmanagement.Category;
import productmanagement.Product;
import userinterface.*;
import usermanagement.*;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Customer customer=new Customer();
	private static String currentUserEmail;
	private static final String ENTER_EMAIL = "Enter your email: ";
	private static final String ENTER_PASS = "Enter your password: ";
	private static final String THANK_MSG = "Thank you for using our system. Goodbye!";
	private static final String NOT_AVAILABLE = "The choice is not valid";
	private static final String ENTER_COST = "Enter the product cost: ";
	private static final String QUESTION="Do you want to buy anything? (enter yes/no)";
	private static List<User> userList = new ArrayList<>();
	
	public static void setUserList(List<User> userList) {
	Main.userList=userList;	
	}
	public static void  printLoginInfo() {
    	Scanner scan = new Scanner(System.in);	
		LoginLogout log = new LoginLogout();
		 while (true) {
		 PrintUtils.println(ENTER_EMAIL);
		 String email = scan.nextLine();
		 PrintUtils.println(ENTER_PASS);
		 String password = scan.nextLine();
		 if (log.login(email, password, userList)) {
		 PrintUtils.println("Login succeeded");
		 currentUserEmail=email;
		 break; 
		 }
		 else 
		 {
		 log.printInvalid();
		 }
		 
		 }
	
     }
	
   public static void printSignUpInfo() {
    	Scanner scan = new Scanner(System.in);
        SignUp sign = new SignUp(userList);
        
        PrintUtils.println(ENTER_EMAIL);
        String email = scan.nextLine();
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }
        while (!sign.emailFormat(email) || !sign.isEmailUnique(email)) {
        if (!sign.emailFormat(email)) {
        PrintUtils.println("Invalid email format");
        }
        if (!sign.isEmailUnique(email)) {
        PrintUtils.println("Email already exists!");
        }
        PrintUtils.println("Enter your email again: ");
        email = scan.nextLine();
        }
        currentUserEmail=email;
         PrintUtils.println(ENTER_PASS);
         String password = scan.nextLine();
         PrintUtils.println("Enter your name: ");
         String name = scan.nextLine();
         PrintUtils.println("Enter your phonenumber: ");
         String phonenumber = scan.nextLine();
         PrintUtils.println("Enter your address: ");
         String address = scan.nextLine();
         
         if(!sign.signUp(email,name, password,phonenumber,address)) {
        	 PrintUtils.println("Registered successfully");
         }
   }
    
   public static void adminTasks() {
	   Admin admin=new Admin();
 	    Scanner scan = new Scanner(System.in);
	    while(true) {
	    Printlists.adminTasks();	
	   	int choice = scan.nextInt();
	    if(choice==5) {
	    LoginLogout log=new LoginLogout();	
	    log.logout();	
	    PrintUtils.println("done Logged out successfully");	
	    break;	
	    }
		switch(choice) {
	    case 1:
		manageCategories();
		break;
		case 2:
	    manageProducts();
		break;
		case 3:
	    manageAccounts();	
		break;
		case 4:
		admin.printAppointments();	
		break;
		default:
		PrintUtils.println(NOT_AVAILABLE);	
		break;
		
		  }//switch ends here
	 	
	   } //while
	}
   
   
   public static void manageAccounts() {
   Scanner scanner = new Scanner(System.in); // Initialize Scanner
   Customer customer=new Customer();
   Installer installer=new Installer();
   Admin admin=new Admin();
   while(true) {
   Printlists.manageAccounts();	
   int choice=scanner.nextInt();	
   scanner.nextLine();	
   if(choice==6) {
      	break;
   }
   switch(choice) {
   case 1:
   admin.viewCustomerInfo();
   break;
   case 2:
   PrintUtils.println("Enter the email of customer you want to delete");	
   String email=scanner.nextLine();
   customer.deleteAccount(email);
   break;
   case 3:
   admin.viewInstallerInfo();
   break;
   case 4:
   addInstaller(scanner);	
   break;
   case 5:
   PrintUtils.println("Enter the email of installer you want to delete");	
   String email2=scanner.nextLine();
   installer.deleteAccount(email2);	
   break;
   default:
   PrintUtils.println(NOT_AVAILABLE);	
   break;	
   
       }//switch
   
   
     }//while loop
   
   }
   public static void addInstaller(Scanner scanner) {
	     Installer ins=new Installer();	
	     PrintUtils.println("Enter installer email: ");
	     String email = scanner.nextLine();	
	     PrintUtils.println("Enter installer password: ");
	     String password = scanner.nextLine();	
	     PrintUtils.println("Enter installer name: ");
	     String name = scanner.nextLine();
	     PrintUtils.println("Enter installer phone number: ");
	     String phone = scanner.nextLine();
	     PrintUtils.println("Enter installer address: ");
	     String address = scanner.nextLine();
	     ins.addInstaller(email, name, password, phone, address);
	 }
   
	public static void manageCategories() {
	    CategoriesManager category = new CategoriesManager();
	    Scanner scanner = new Scanner(System.in);	
	    
	    while(true) {
	    Printlists.categoryListings();
	    int choice = scanner.nextInt();
	    scanner.nextLine();
	    if(choice==5) {
	       	break;
	     }
	    switch (choice) {
	    case 1:
	        PrintUtils.println("Enter the category name: ");
	        String name = scanner.nextLine();
	        PrintUtils.println("Enter the category description: ");
	        String description = scanner.nextLine();
	        category.addCategory(name, description);
	        break;
	    case 2:
	    	category.listCategories();
	        PrintUtils.println("Enter the category name to edit: ");
	        String categoryName = scanner.nextLine();
	        PrintUtils.println("Enter the new category name: ");
	        String newCategoryName = scanner.nextLine();
	        PrintUtils.println("Enter the new category description: ");
	        String newCategoryDescription = scanner.nextLine();
	        category.editCategory(categoryName, newCategoryName, newCategoryDescription);
	        break;
	    case 3:
	        PrintUtils.println("Enter the category name to delete: ");
	        String categoryToDelete = scanner.nextLine();
	        category.deleteCategory(categoryToDelete);
	        break;
	    case 4:
	    	category.listCategories();
	        break;
	    default:
	        PrintUtils.println("(Invalid choice) . Please select a valid option");
	        break;
	    }
	  }
	 }
   
	public static void manageProducts() {
        ProductsManager prod = new ProductsManager();
        CategoriesManager category = new CategoriesManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Printlists.productListings();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice == 5) {
                break;
            }

            switch (choice) {
                case 1:
                    addProduct(prod, category, scanner);
                    break;
                case 2:
                    editProduct(prod, scanner, category);
                    break;
                case 3:
                    deleteProduct(prod, scanner);
                    break;
                case 4:
                    prod.listProducts();
                    break;
                default:
                    PrintUtils.println("(Invalid choice). Please select a valid option.");
                    break;
            }
        }
    }

    private static void addProduct(ProductsManager prod, CategoriesManager category, Scanner scanner) {
        PrintUtils.println("Enter product name: ");
        String name = scanner.nextLine();

        while (!prod.checkexsist(name)) {
            PrintUtils.println("This product is already in the list");
            PrintUtils.println("Enter the product name: ");
            name = scanner.nextLine();
        }

        String description = enterProductDescription(scanner);
        double cost = enterProductCost(scanner, prod);
        int quantity = enterProductQuantity(scanner);

		List<Category> categoriesList = category.getCategoriesList();
        displayCategories(categoriesList);

        int categoryChoice = chooseCategory(scanner, categoriesList);
        String selectedCategory = categoriesList.get(categoryChoice - 1).getName();

        prod.addProduct(name, description, cost, quantity, selectedCategory);
        PrintUtils.println("Product added to the list.");
    }

    private static String enterProductDescription(Scanner scanner) {
        PrintUtils.println("Enter the product description: ");
        return scanner.nextLine();
    }

    private static double enterProductCost(Scanner scanner, ProductsManager prod) {
        double cost;
        do {
            PrintUtils.println(ENTER_COST);
            cost = scanner.nextDouble();
        } while (!prod.checkCost(cost));

        return cost;
    }

    private static int enterProductQuantity(Scanner scanner) {
        PrintUtils.println("Enter the product quantity: ");
        return scanner.nextInt();
    }

    private static void displayCategories(List<Category> categoriesList) {
        PrintUtils.println("Available Categories:");
        for (int i = 0; i < categoriesList.size(); i++) {
            PrintUtils.println((i + 1) + ". " + categoriesList.get(i).getName());
        }
    }

    private static int chooseCategory(Scanner scanner, List<Category> categoriesList) {
        int categoryChoice;
        do {
            PrintUtils.println("Choose a category (enter the number): ");
            categoryChoice = scanner.nextInt();
        } while (categoryChoice < 1 || categoryChoice > categoriesList.size());

        return categoryChoice;
    }

    private static void editProduct(ProductsManager prod, Scanner scanner, CategoriesManager category) {
        prod.listProducts();
        PrintUtils.println("Enter the product name that you want to make edits on: ");
        scanner.nextLine(); // Consume the newline character
        String productName = scanner.nextLine();

        while (prod.checkexsist(productName)) {
            PrintUtils.println("This product doesn't exist in the company's products, enter the name again ");
            productName = scanner.nextLine();
        }

        Printlists.editProduct();
        int choice1 = scanner.nextInt();
        scanner.nextLine();

        switch (choice1) {
            case 1:
                updateProductName(prod, productName, scanner);
                break;
            case 2:
                updateProductDescription(prod, productName, scanner);
                break;
            case 3:
                updateProductCost(prod, productName, scanner);
                break;
            case 4:
                updateProductQuantity(prod, productName, scanner);
                break;
            case 5:
                moveProductToCategory(prod, category, productName, scanner);
                break;
            default:
        }
    }

    private static void updateProductName(ProductsManager prod, String productName, Scanner scanner) {
        PrintUtils.println("Enter the new product name: ");
        String newProductName = scanner.nextLine();
        prod.updateProductName(productName, newProductName);
    }

    private static void updateProductDescription(ProductsManager prod, String productName, Scanner scanner) {
        PrintUtils.println("Enter the new product description: ");
        String newDescription = scanner.nextLine();
        prod.updateProductDescription(productName, newDescription);
    }

    private static void updateProductCost(ProductsManager prod, String productName, Scanner scanner) {
        PrintUtils.println("Enter the new product cost: ");
        double newCost = scanner.nextDouble();
        while (!prod.checkCost(newCost)) {
            PrintUtils.println("Cost cannot be zero or negative!");
            PrintUtils.println(ENTER_COST);
            newCost = scanner.nextDouble();
        }

        prod.updateProductCost(productName, newCost);
    }

    private static void updateProductQuantity(ProductsManager prod, String productName, Scanner scanner) {
        PrintUtils.println("Enter the new product quantity: ");
        int newQuantity = scanner.nextInt();
        prod.updateProductQuantity(productName, newQuantity);
    }

    private static void moveProductToCategory(ProductsManager prod, CategoriesManager category, String productName, Scanner scanner) {
        category.listCategories();
        PrintUtils.println("Enter the (number) of category that you want to move the product to: ");
        int cat = scanner.nextInt();
        List<Category> categoriesList1 = category.getCategoriesList();
        String newCategory = categoriesList1.get(cat - 1).getName();
        prod.updateProductCategory(productName, newCategory);
    }

    private static void deleteProduct(ProductsManager prod, Scanner scanner) {
        PrintUtils.println("Enter the product name you want to delete: ");
        scanner.nextLine(); // Consume the newline character
        String productToDelete = scanner.nextLine();
        prod.deleteProduct(productToDelete);
    }
   
    public static void installerTasks() {
    	Installer installer=new Installer();
        Scanner scanner = new Scanner(System.in);
  		 while(true) { 
  	     Printlists.installerTasks();	
  		 
  	     int choice = scanner.nextInt();
  		 if(choice==5) { 
  		 LoginLogout log=new LoginLogout();	
  	     log.logout();	
  	     PrintUtils.println("Logged out successfully");	
  	     break;		 
  		 } 
  		 switch(choice) {
  	     case 1:
  	     newAppointment(currentUserEmail); 
  	     break;
  		 case 2:
  		 PrintUtils.println("All available Appointments:");
  		 installer.viewAppointments(currentUserEmail);
  		 break;
  		 case 3:
  		 installer.viewAppointmentBookings(currentUserEmail);	
  		 break;
  		 case 4:
  	     if(installer.viewAppointments(currentUserEmail)) {
  	     deleteAppointment();	 
  	     }
  	     break;
  		 default:
  		 PrintUtils.println(NOT_AVAILABLE);	
  		 break;
  			
  	     }
  		 
  	   }//while
  	} 
   
    public static void newAppointment(String currentEmail2) {
    	Installer installer=new Installer();
        Scanner scanner = new Scanner(System.in);
		PrintUtils.println("Enter your name ");
        String name = scanner.nextLine();
        PrintUtils.println("Enter date (e.g., 01-12-2023): ");
        String date = scanner.nextLine();
        PrintUtils.println("Enter day (e.g., Monday): ");
        String day = scanner.nextLine();
        PrintUtils.println("Enter hour (e.g., 09:00 AM): ");
        String hour = scanner.nextLine();
        
        installer.addAppointemnt(date,day,hour,currentEmail2, name);
		
	}
    
	  public static void deleteAppointment() {
	  Installer installer=new Installer();
      Scanner scanner = new Scanner(System.in);
      PrintUtils.println("Enter the appointment number you want to delete:"); 
      int appointmentNumber=scanner.nextInt();
      installer.deleteAppointmentByNumber(appointmentNumber);
      
	 }
	  
	  public static void customerServices() {
	        ProductsManager productsManager = new ProductsManager();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            Printlists.customerTasks();

	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline

	            if (choice == 7) {
	                logoutAndExit();
	                break;
	            }

	          
	            switch (choice) {
	                case 1:
	                    editAccountInfo();
	                    break;
	                case 2:
	                    handleProductListing(productsManager, scanner);
	                    break;
	                case 3:
	                    handleProductSearch(scanner);
	                    break;
	                case 4:
	                    handleInstallationRequest();
	                    break;
	                case 5:
	                    customer.viewInstallationRequests(currentUserEmail);
	                    break;
	                case 6:
	                    customer.viewOrderHistory(currentUserEmail);
	                    break;
	                default:
	                    PrintUtils.println( "NOT_AVAILABLE" );
	                    break;
	            }
	        }
	    }
	  
	  private static void logoutAndExit() {
	        LoginLogout log = new LoginLogout();
	        log.logout();
	        PrintUtils.println("Logged out successfully");
	        customer.emptyCart();
	    }
	  
	  public static void editAccountInfo() {
		    Scanner scanner = new Scanner(System.in);

		    while (true) {
		        Printlists.editProfile();
		        int choice = scanner.nextInt();
		        scanner.nextLine(); // Consume the newline

		        if (choice == 5) {
		            break;
		        }

		        switch (choice) {
		            case 1:
		                updatePassword();
		                break;
		            case 2:
		            	updateName();
		               break;
		            case 3:
		            	updatePhoneNumber();
		                break;
		            case 4:
		            	updateAddress();
		                break;
		            default:
		                PrintUtils.println("Invalid choice. Please select a valid option.");
		                break;
		        }
		    }
		}

		private static void updatePassword() {
		    PrintUtils.println("Enter your old password");
		    String oldPass = scanner.nextLine();
		    PrintUtils.println("Enter your new password");
		    String newPass = scanner.nextLine();
		    customer.updatePass(currentUserEmail, oldPass, newPass);
		}

		private static void updatePhoneNumber() {
		    PrintUtils.println("Enter your new phone number");
		    String newPhoneNumber = scanner.nextLine();
		    customer.updatePhonenumber(currentUserEmail, newPhoneNumber);
		}

		private static void updateName() {
		    PrintUtils.println("Enter your the new name");
		    String newName = scanner.nextLine();
		    customer.updateName(currentUserEmail, newName);
		}

		
		private static void updateAddress() {
		    PrintUtils.println("Enter your new address");
		    String newAddress = scanner.nextLine();
		    customer.updateAddress(currentUserEmail, newAddress);
		}
	  
		public static void handleProductListing(ProductsManager productsManager, Scanner scanner) {
		    productsManager.listProducts();
		    PrintUtils.println(QUESTION);
            String response = scanner.nextLine();
		    if (response.equalsIgnoreCase("yes")) {
		       takeProductInfo(currentUserEmail);
		    }
		}
		
		public static void takeProductInfo(String email) {
		    while (true) {
		        ProductsManager productsManager = new ProductsManager();
		        Scanner scanner = new Scanner(System.in);
		        PrintUtils.println("Enter the product name: ");
		        String productName = scanner.nextLine();

		        if (!productsManager.checkexsist(productName)) {
		            Product prod = productsManager.getProduct(productName);
		            PrintUtils.println("Enter the quantity : ");
		            int quantity = scanner.nextInt();
		            if (quantity > prod.getQuantity() || quantity <= 0) {
		                PrintUtils.println("Not enough stock available for the selected quantity.");
		            } else {
		                customer.addToCart(productName, prod.getCost(), quantity);
		                PrintUtils.println("\nIf you're done shopping enter (exit) to confirm or delete the order, if you want to continue just press the (enter) button.");
		                scanner.nextLine();  // Consume the newline
		                String exit = scanner.nextLine();
		                if (exit.equals("exit")) {
		                    confirmOrDelete(email);
		                   break;  // Return instead of break to exit the loop
		                }
		            }
		        } else {
		            PrintUtils.println("Product not found.");
		        }
		    }
		}

		public static void confirmOrDelete(String email) {
			  Scanner scanner = new Scanner(System.in);
		    PrintUtils.println("Enter your choice: ");
		    Printlists.confirmOrDelete();
		    int choice = scanner.nextInt();
		    switch (choice) {
		        case 1:
		            customer.confirmOrder(email);
		            customer.sendOrderConfirmationEmail(email);
		            break;
		        case 2:
		            customer.emptyCart();
		            PrintUtils.println("All products in the cart have been deleted.");
		            break;
		        default:
		            PrintUtils.println("Invalid choice.");
		    }
		}

		public static void handleProductSearch(Scanner scanner) {
		    Printlists.searchProduct();
		    int num = scanner.nextInt();

		    if (num == 1) {
		        PrintUtils.println("Enter the beginning of the product name and we'll find it: ");
		        scanner.nextLine();
		        String searchKeyword = scanner.nextLine().toLowerCase();
		        if (customer.searchProducts(searchKeyword)) {
		            PrintUtils.println(QUESTION);
		            String option = scanner.nextLine();
		            if (option.equalsIgnoreCase("yes")) {
		                takeProductInfo(currentUserEmail); // Add this line
		            } else if (option.equalsIgnoreCase("no")) {
		                // Handle accordingly
		            }
		        }
		    } else if (num == 2) {
		        PrintUtils.println("Enter the minimum price: ");
		        double minPrice = scanner.nextDouble();

		        PrintUtils.println("Enter the maximum price: ");
		        double maxPrice = scanner.nextDouble();
		        if (customer.searchProductsByPriceRange(minPrice, maxPrice)) {
		            scanner.nextLine();
		            PrintUtils.println(QUESTION);
		            String option = scanner.nextLine();
		            if (option.equalsIgnoreCase("yes")) {
		                takeProductInfo(currentUserEmail); // Add this line
		            } else if (option.equalsIgnoreCase("no")) {
		                // Handle accordingly
		            }
		        }
		    } else {
		        PrintUtils.println("Invalid number ");
		    }
		}
		public static void handleInstallationRequest() {
		    if (installationForm(currentUserEmail)) {
		        customer.sendInstallationRequestEmail(currentUserEmail);
		    }
		}

		public static boolean installationForm(String email) {
		    Scanner scanner = new Scanner(System.in);
		    PrintUtils.println("Enter your full name: ");
		    String customerName = scanner.nextLine();
		    PrintUtils.println("Enter your phone number: ");
		    String phoneNumber = scanner.nextLine();
		    PrintUtils.println("Enter your car brand: ");
		    String carBrand = scanner.nextLine();
		    PrintUtils.println("Enter your car model: ");
		    String carModel = scanner.nextLine();
		    PrintUtils.println("Enter the reason for the request: ");
		    String reason = scanner.nextLine();
	        customer.printAvailableAppointemnts();

		    Appointment selectedAppointment = null;
		    PrintUtils.println("Enter the appointment number to book: ");
		    int appointmentNumber = Integer.parseInt(scanner.nextLine());
		    for (Appointment appointment : Installer.getAppointmentList()) {
		        if (appointment.getAppointmentNumber() == appointmentNumber) {

		            if (appointment.getAvailability().equals("Booked")) {
		                PrintUtils.println("Sorry, the appointment is already booked. Choose another appointment or wait until we add new dates.");
		                return false;
		            } else {
		                selectedAppointment = customer.getAppointment(appointmentNumber);
		             
		                break;
		            }
		        }
		    }
		    customer.requestInstallation(selectedAppointment, email, customerName, phoneNumber, reason, carBrand, carModel);
		    return true;
		}

		
		
		
		
   public static void handleUserChoice(int userType) {
       switch (userType) {
           case 1:
               handleAdmin();
               break;
           case 2:
               handleInstaller();
               break;
           case 3:
               handleCustomer();
               break;
           case 4:
               PrintUtils.println(THANK_MSG);
               System.exit(0);
               break;
           default:
               PrintUtils.println(NOT_AVAILABLE);
       }
   }
    
   public static void handleAdmin() {
       Printlists.printLogin();
       int loginChoice = new Scanner(System.in).nextInt();
       if (loginChoice == 1) {
           userList = Admin.getAdminList();
           setUserList(userList);
           printLoginInfo();
           adminTasks();
       } else if (loginChoice == 2) {
           PrintUtils.println(THANK_MSG);
           System.exit(0);
       } else {
           PrintUtils.println(NOT_AVAILABLE);
       }
   }

   public static void handleInstaller() {
       Printlists.printLogin();
       int loginChoice = new Scanner(System.in).nextInt();
       if (loginChoice == 1) {
           userList = Installer.getInstallerList();
           setUserList(userList);
           printLoginInfo();
          installerTasks();
       } else if (loginChoice == 2) {
           PrintUtils.println(THANK_MSG);
           System.exit(0);
       } else {
           PrintUtils.println(NOT_AVAILABLE);
       }
   }

   public static void handleCustomer() {
       userList = Customer.getCustomerList();
       setUserList(userList);

       Printlists.printLoginorsignup();
       int loginChoice = new Scanner(System.in).nextInt();
       if (loginChoice == 1) {
           printSignUpInfo();
           customerServices();
       } else if (loginChoice == 2) {
           printLoginInfo();
           customerServices();
       } else if (loginChoice == 3) {
           PrintUtils.println(THANK_MSG);
           System.exit(0);
       } else {
           PrintUtils.println(NOT_AVAILABLE);
       }
   }
   
   public static void main(String[] args) {
       boolean exit = false;
       Scanner scanner = new Scanner(System.in);

       while (!exit) {
           try {
               Printlists.userRolelist();
               int userType = scanner.nextInt();
               handleUserChoice(userType);
               if (userType == 4) {
                   exit = true;
               }  
               
           } catch (InputMismatchException e) {
               PrintUtils.println("Invalid input. Please enter a valid integer.");
               scanner.nextLine(); 
           }
       }
   }
  
}

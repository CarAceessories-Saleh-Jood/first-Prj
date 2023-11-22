
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import productmanagement.Category;
import productmanagement.CategoriesManager;
import productmanagement.Product;
import productmanagement.ProductsManager;
import userinterface.PrintUtils;
import userinterface.Printlists;
import usermanagement.LoginSignUp;
import usermanagement.Users;

public class Main {
	
   private static final String ENTER_EMAIL = "Enter your email: ";
   private static final String ENTER_PASS = "Enter your password: ";
   private static String Email = null;
   private static String Type = null; 
    
    public static void printSignUpInfo(String id) {
    	
        Scanner scan = new Scanner(System.in);
        LoginSignUp log = new LoginSignUp();
        String type = id;
     
        PrintUtils.println(ENTER_EMAIL);
         String email = scan.nextLine();
         while (!log.emailFormat(email) || !log.emailCheck(email)) {
             if (!log.emailFormat(email)) {
                 PrintUtils.println("Invalid email format");
             }
             if (!log.emailCheck(email)) {
                 PrintUtils.println("Email already exists!");
             }
             PrintUtils.println("Enter your email again: ");
             email = scan.nextLine();
         }
         Email=email;
         PrintUtils.println(ENTER_PASS);
         String password = scan.nextLine();
         PrintUtils.println("Enter your phonenumber: ");
         String phonenumber = scan.nextLine();
         PrintUtils.println("Enter your address: ");
         String address = scan.nextLine();
         
         if(!log.signUp(email, password,phonenumber,address,type)) {
        	 PrintUtils.println("Registered successfully");
         }
      }
  
    public static void  printLoginInfo() {

    	  
      Scanner scan = new Scanner(System.in);	  
      LoginSignUp log = new LoginSignUp();
      while (true) {
          PrintUtils.println(ENTER_EMAIL);
          String email = scan.nextLine();

          PrintUtils.println(ENTER_PASS);
          String password = scan.nextLine();

          if (log.login(email, password, Type)) {
              PrintUtils.println("Login succeeded");
              break; 
          } else {
              log.printInvalid();
          }
      }
   }

    public static void manageCategories() {
    	CategoriesManager category = new CategoriesManager();
        Scanner scanner = new Scanner(System.in);

           while(true) {
            PrintUtils.println("\nManage Categories");
            PrintUtils.println("1. Add Category");
            PrintUtils.println("2. Edit Category");
            PrintUtils.println("3. Delete Category");
            PrintUtils.println("4. List Categories");
            PrintUtils.println("5. Return to admin tasks");
            PrintUtils.println("Enter your choice: ");

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
                    PrintUtils.println("Invalid choice. Please select a valid option.");
                    break;
            
           }
         
       }
          
     }
    
    public static void manageProducts() {
    	 ProductsManager prod=new ProductsManager();
         CategoriesManager category = new CategoriesManager();
         Scanner scanner = new Scanner(System.in);
         while(true) {
        	 PrintUtils.println("Manage Products");
             PrintUtils.println("1. Add Product");
             PrintUtils.println("2. Edit Product");
             PrintUtils.println("3. Delete Product");
             PrintUtils.println("4. List Products");
             PrintUtils.println("5. Return to admin tasks");
             PrintUtils.println("Enter your choice: ");
             
             
           int choice = scanner.nextInt();
           scanner.nextLine();  
           if(choice==5) {
            	break;
            }
           
           switch (choice) {
           case 1:
        	   System.out.print("Enter the product name: ");
               String name = scanner.nextLine();
               while(!prod.checkexsist(name)) {
         	    System.out.println("This product is already in the list");
                System.out.println("Enter the product name: ");
                name = scanner.nextLine();
              }
               System.out.print("Enter the product description: ");
               String description = scanner.nextLine();
               System.out.print("Enter the product cost: ");
               double cost = scanner.nextDouble();
               while(!prod.checkCost(cost)) {
                   System.out.print("Cost cannot be zero or negative!");
                   System.out.print("Enter the product cost: ");
                   cost = scanner.nextDouble();
               }
               System.out.print("Enter the product quantity: ");
               int quantity = scanner.nextInt();
               
               ArrayList<Category> categoriesList = category.getCategoriesList();
               System.out.println("Available Categories:");
               for (int i = 0; i < categoriesList.size(); i++) {
                   System.out.println((i + 1) + ". " + categoriesList.get(i).getName());
               }

               int categoryChoice;
               do {
                   System.out.print("Choose a category (enter the number): ");
                   categoryChoice = scanner.nextInt();
               } while (categoryChoice < 1 || categoryChoice > categoriesList.size());

               // Get the selected category name
               String selectedCategory = categoriesList.get(categoryChoice - 1).getName();
               
               prod.addProduct(name,description,cost,quantity,selectedCategory);{
               System.out.println("Product added to the list.");}
              break;
              case 2:
               PrintUtils.println("Enter the product name that you want to make edits on: ");
               String productName = scanner.nextLine();
                PrintUtils.println("Choose what do you want to edit");
                PrintUtils.println("1. Product name");
                PrintUtils.println("2. Product description");
                PrintUtils.println("3. Product cost");
                PrintUtils.println("4. Product quantity");
                PrintUtils.println("5. Product category");
                PrintUtils.println("Enter your choice: ");
                int choice1 = scanner.nextInt();
                scanner.nextLine(); 
                
                switch(choice1) {
                case 1:
                PrintUtils.println("Enter the new product name: ");
                String newProductName = scanner.nextLine();	
                prod.updateProductName(productName, newProductName);
                break;
                case 2:
                PrintUtils.println("Enter the new product description: ");
                String newDescription = scanner.nextLine();	
                prod.updateProductDescription(productName, newDescription);
                break; 	
                case 3:
                PrintUtils.println("Enter the new product cost: ");
                double newCost = scanner.nextDouble();	
                prod.updateProductCost(productName, newCost);
                break; 
                case 4:
                PrintUtils.println("Enter the new product quantity: ");
                int newQuantity = scanner.nextInt();
                prod.updateProductQuantity(productName, newQuantity);
                break; 
                case 5:
                category.listCategories();	
                
                PrintUtils.println("Enter the (number) of category that you want to move the product to it: ");
                int cat=scanner.nextInt();
                ArrayList<Category> categoriesList1 = category.getCategoriesList();
                String newCategory = categoriesList1.get(cat - 1).getName();
                prod.updateProductCategory(productName, newCategory);
                break; 
                }
                
               break;
           case 3:
               PrintUtils.println("Enter the product name you want to delete: ");
               String productToDelete = scanner.nextLine();
               prod.deleteProduct(productToDelete);
               break;
           case 4:
           prod.listProducts();
               break;
           default:
               PrintUtils.println("Invalid choice. Please select a valid option.");
               break;
       
      }
    }
  }

      

  public static void main(String[] args) {
    	
    LoginSignUp log=new LoginSignUp();
    
    
   PrintUtils.println("------* Welcome to our Car Accessories system *------");
   boolean exit = false;
   Scanner scan = new Scanner(System.in);
   
   while (!exit) {
	   PrintUtils.println("-> Choose how you want to get into the system:");
	   PrintUtils.println("1- Admin");
	   PrintUtils.println("2- Installer");
	   PrintUtils.println("3- Customer");
	   PrintUtils.println("Enter 'exit' to end the system.");  
       Type = scan.nextLine();  // 1 -> admin, 2 -> installer, 3 -> customer
       
     if(Type.equals("exit")){
           exit=true;
           PrintUtils.println("Thank you for using our system. Goodbye!");
           System.exit(1);
       }
       if (!Type.equals("1") && !Type.equals("2") && !Type.equals("3")) {
    	   PrintUtils.println("The choice is not valid");
           continue;
       }
       else { //##################################### first list for all users
    	   Printlists.printLoginorsignup();
    	   String num = scan.nextLine();
           if(num.equals("1")) { //sign up
        	   printSignUpInfo(Type);
        	  
        	}
           else if(num.equals("2")) { //log in 
        	   printLoginInfo(); 
       
           }
           else if(num.equals("3")) { // exit
        	   exit=true;
        	   PrintUtils.println("Thank you for using our system. Goodbye!");
               System.exit(1); 
           }
           else { // not available number
           PrintUtils.println("The choice is not valid"); 
           continue;
           } 
            
          
          while(Type.equals("1")){ ////////admin
        	  
        	Printlists.adminTasks();
          	String task=scan.nextLine();
            while(!task.equals("5")) { ///exit
            
            switch(task) { // admin choice
            case "1":   // manage categories
            manageCategories();
            Printlists.adminTasks();
            task=scan.nextLine();
            break;
    	    case "2": 
            manageProducts();
            Printlists.adminTasks();
            task=scan.nextLine();
            break;
    	    
    	    
    	   case "3":
    	   break;	
           
    	   case "4":
           break;	
            
    	 
         
           // }
            //Display.adminTasks();
            //task=scan.nextLine();	
             
           }
           
        
     }
         
     PrintUtils.println("Logged out successfully");	
     log.logout();
     break;       
   }      
           
           
           while(Type.equals("2")) { ///installer tasks 
        	   
        	   
           }
           while(Type.equals("3")) { ///customer tasks
        	Printlists.customerTasks();
        	String ch=scan.nextLine();
        	if(ch.equals("1")) {
        	Printlists.editProfile();
        	ch=scan.nextLine();
        	switch(ch){
        	case "1":
        	PrintUtils.println("Enter your old password");
        	String pass=scan.nextLine();
        	PrintUtils.println("Enter your new password");
        	String newpass=scan.nextLine();	
        	//boolean verify=
        	log.updatePass(Email,pass,newpass);
        	//printLoginInfo();
        	break;
        	case "2":
        	PrintUtils.println("Enter your new phone number");
        	String newPhone=scan.nextLine();
        	log.updatePhonenumber(Email,newPhone);
        	break;
        	case "3":
            PrintUtils.println("Enter your new address");
            String newAddress=scan.nextLine();
            log.updateAddress(Email,newAddress);
            break;
        	
           }
        	}
        
           }
       
   }    
}
}
}
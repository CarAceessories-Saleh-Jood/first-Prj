package usermanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import productmanagement.CategoriesManager;
import productmanagement.Category;
import productmanagement.ProductsManager;
import requestsmanagement.AppointmentBooking;
import userinterface.PrintUtils;
import userinterface.Printlists;

public class Admin{
	static Scanner scanner = new Scanner(System.in);	
	private static List<Users> adminList = new ArrayList<>();
	static {
    adminList.add(new Users("jood.hamdallah12@gmail.com","Jood Hamdallah","1234","0565584756","Tulkarm"));
	adminList.add(new Users("sawalha.saleh3@gmail.com","Saleh Sawalha", "1234","0565785656","Nablus"));
	}
		
    private Admin() {}
    
    public static void adminTasks() {
    	
        while(true) {
    Printlists.adminTasks();	
   	int choice = scanner.nextInt();
    if(choice==5) {
    LoginLogout log=new LoginLogout();	
    log.logout();	
    PrintUtils.println("Logged out successfully");	
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
	printAppointments();	
	break;
	default:
	PrintUtils.println("The choice is not valid");	
	break;
	
	  }//switch ends here
 	
   } //while
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
       	  Printlists.productListings();
          int choice = scanner.nextInt();
          scanner.nextLine();  
          if(choice==5) {
           	break;
           }
          
          switch (choice) {
          case 1:
        	  PrintUtils.println("Enter the product name: ");
              String name = scanner.nextLine();
              while(!prod.checkexsist(name)) {
            	  PrintUtils.println("This product is already in the list");
            	  PrintUtils.println("Enter the product name: ");
               name = scanner.nextLine();
             }
              PrintUtils.println("Enter the product description: ");
              String description = scanner.nextLine();
              PrintUtils.println("Enter the product cost: ");
              double cost = scanner.nextDouble();
              while(!prod.checkCost(cost)) {
            	  PrintUtils.println("Cost cannot be zero or negative!");
            	  PrintUtils.println("Enter the product cost: ");
                  cost = scanner.nextDouble();
              }
              PrintUtils.println("Enter the product quantity: ");
              int quantity = scanner.nextInt();
              
              List<Category> categoriesList = category.getCategoriesList();
              PrintUtils.println("Available Categories:");
              for (int i = 0; i < categoriesList.size(); i++) {
            	  PrintUtils.println((i + 1) + ". " + categoriesList.get(i).getName());
              }

              int categoryChoice;
              do {
            	  PrintUtils.println("Choose a category (enter the number): ");
                  categoryChoice = scanner.nextInt();
              } while (categoryChoice < 1 || categoryChoice > categoriesList.size());

              // Get the selected category name
              String selectedCategory = categoriesList.get(categoryChoice - 1).getName();
              
              prod.addProduct(name,description,cost,quantity,selectedCategory);
              PrintUtils.println("Product added to the list.");
             break;
             case 2:
              prod.listProducts(); 
              PrintUtils.println("Enter the product name that you want to make edits on: ");
              String productName = scanner.nextLine();
              while(prod.checkexsist(productName)) {
              PrintUtils.println("This product doesn't exsist in the the company's products, enter the name again ");
              productName = scanner.nextLine();
              }
              
               Printlists.editProduct();
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
               while(!prod.checkCost(newCost)) {
            	   PrintUtils.println("Cost cannot be zero or negative!");
            	   PrintUtils.println("Enter the product cost: ");
                   newCost = scanner.nextDouble();
               }
               
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
              List<Category> categoriesList1 = category.getCategoriesList();
               String newCategory = categoriesList1.get(cat - 1).getName();
               prod.updateProductCategory(productName, newCategory);
               break; 
               default:
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
    
    
    public static void addInstaller() {
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
    
    
    public static void manageAccounts() {
     Customer customer=new Customer();
     Installer installer=new Installer();
    while(true) {
    Printlists.manageAccounts();	
    int choice=scanner.nextInt();	
    scanner.nextLine();	
    if(choice==6) {
       	break;
    }
    switch(choice) {
    case 1:
    Customer.printAccounts();
    break;
    case 2:
    PrintUtils.println("Enter the email of customer you want to delete");	
    String email=scanner.nextLine();
    customer.deleteAccount(email);
    break;
    case 3:
    Installer.printAccounts();
    break;
    case 4:
    addInstaller();	
    break;
    case 5:
    PrintUtils.println("Enter the email of installer you want to delete");	
    String email2=scanner.nextLine();
    installer.deleteAccount(email2);	
    break;
    default:
    PrintUtils.println("The choice is not valid");	
    break;	
    
        }//switch
    
    
      }//while loop
    
   }
    public static void printAppointments() {
    for (AppointmentBooking app : Customer.getBookingList()) {	
    PrintUtils.println("\nAppointment number: "+ app.getAppointment().getAppointmentNumber()+"\nInstaller Name: "+ app.getAppointment().getName()+ "\nInstaller email: "+ app.getAppointment().getEmail()+"\nCustomer Name: "+ app.getName()+"\nAppointment date: "+app.getAppointment().getDate()+"\nAppointment day: "+app.getAppointment().getDay()+"\nCar Brand : "+app.getCarBrand()+"\nCar Model : "+app.getCarModel()+"\nReason of request : "+app.getReason()+"\n");	
    }
}
    
    
    public static List<Users> getList(){
	       return adminList;
	 } 
			
}

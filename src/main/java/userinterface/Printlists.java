package userinterface;

public class Printlists {
	
	private Printlists() {
		
	}
	
	public static void userRolelist() {
	   PrintUtils.println("-> Choose how you want to get into the system:");
	   PrintUtils.println("1-Admin");
	   PrintUtils.println("2-Installer");
	   PrintUtils.println("3-Customer");
	   PrintUtils.println("4-Exit");
	}
	
	public static void printLoginorsignup() {
		PrintUtils.println("Choose what do you want to do:");
		PrintUtils.println("1-Sign Up");
		PrintUtils.println("2-Login");
		PrintUtils.println("3-Exit");
		}
	
	public static void printLogin() {
		PrintUtils.println("Choose what do you want to do:");
		PrintUtils.println("1-Login");
		PrintUtils.println("2-Exit");
		
		}
	
	public static void adminTasks(){
		PrintUtils.println("----Admin Dashboard----");
		PrintUtils.println("1-Manage product categories (add, edit, delete)");
		PrintUtils.println("2-Add and update product listings");
		PrintUtils.println("3-View and manage customer accounts.");
		PrintUtils.println("4-View booked appointments");
		PrintUtils.println("5-Logout");
		}
	
	public static void categoryListings() {
		PrintUtils.println("\nManage Categories");
        PrintUtils.println("1. Add Category");
        PrintUtils.println("2. Edit Category");
        PrintUtils.println("3. Delete Category");
        PrintUtils.println("4. List Categories");
        PrintUtils.println("5. Return to admin tasks");
        PrintUtils.println("Enter your choice: ");
	}
	
	
	public static void productListings(){
		PrintUtils.println("\nManage Products");
		PrintUtils.println("1. Add product");
		PrintUtils.println("2. Edit product");
		PrintUtils.println("3. Delete a product");
		PrintUtils.println("4. List Products");
        PrintUtils.println("5. Return to admin tasks");
        PrintUtils.println("Enter your choice: ");
	}
	
	public static void editProduct() {
		PrintUtils.println("Choose what do you want to edit");
        PrintUtils.println("1. Product name");
        PrintUtils.println("2. Product description");
        PrintUtils.println("3. Product cost");
        PrintUtils.println("4. Product quantity");
        PrintUtils.println("5. Product category");
        PrintUtils.println("Enter your choice: ");
	}
	
	public static void manageAccounts() {
		PrintUtils.println("\nManage Accounts");
        PrintUtils.println("1. List Customer accounts");
        PrintUtils.println("2. Delete Customer");
        PrintUtils.println("3. List Installer accounts");
        PrintUtils.println("4. Add Installer");
        PrintUtils.println("5. Delete Installer");
        PrintUtils.println("6. Return to admin tasks");
        PrintUtils.println("Enter your choice: ");	
	}
	
    public static void installerTasks() {
    	PrintUtils.println("----Installer Dashboard----");
	    PrintUtils.println("1-Add a free Appointment for customers");
	    PrintUtils.println("2-View your Appointments");
	    PrintUtils.println("3-View the Booked Appointments");
	    PrintUtils.println("4-Delete an appointment");
        PrintUtils.println("5-Logout");
	    PrintUtils.println("Enter your choice: ");	
     }
	
	public static void customerTasks(){
		PrintUtils.println("----Customer Dashboard----");
		PrintUtils.println("1-Edit your profile");
		PrintUtils.println("2-Browse products");
		PrintUtils.println("3-Search products");
		PrintUtils.println("4-Request installation services for a product.");
		PrintUtils.println("5-View installation requests history.");
		PrintUtils.println("6-View order history");
		PrintUtils.println("7-Logout");
		}
	public static void editProfile(){
		PrintUtils.println("\nEdit your profile");
		PrintUtils.println("1. Update your password");
		PrintUtils.println("2. Update your name");
		PrintUtils.println("3. Update your phone number");
		PrintUtils.println("4. Update your address");
		PrintUtils.println("5. Return to customer services");
		PrintUtils.println("Enter your choice: ");	
		}
	
	public static void searchProduct() {
		PrintUtils.println("---- Search Products ----");
		PrintUtils.println("1. Search product by name");
		PrintUtils.println("2. Search products included using specific range of price");
	 }
	
	public static void confirmOrDelete(){
		PrintUtils.println("1. Confirm order");
		PrintUtils.println("2. Delete order");
		}
	
}

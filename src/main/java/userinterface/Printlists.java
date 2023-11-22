package userinterface;
import java.util.logging.Logger;

public class Printlists {
	
	
	public static void printLoginorsignup() {
		PrintUtils.println("Choose what do you want to do:");
		PrintUtils.println("1-Sign Up");
		PrintUtils.println("2-Login");
		PrintUtils.println("3-Exit");
		}
	public static void adminTasks(){
		PrintUtils.println("----Admin Dashboard----");
		PrintUtils.println("1-Manage product categories (add, edit, delete)");
		PrintUtils.println("2-Add and update product listings");
		PrintUtils.println("3-View and manage customer accounts.");
		PrintUtils.println("4-Schedule and manage installation appointments.");
		PrintUtils.println("5-Logout");
		}
	
	public static void productListings(){
		PrintUtils.println("1-Add product");
		PrintUtils.println("2-Edit product");
		PrintUtils.println("3-Delete a product");
		PrintUtils.println("4-Return to admin tasks");
	}
	
	public static void customerTasks(){
		PrintUtils.println("1-Edit your profile");
		PrintUtils.println("2-Browse products");
		PrintUtils.println("3-Request installation services for a product.");
		PrintUtils.println("4-View order history");
		PrintUtils.println("5-View installation requests history");
		PrintUtils.println("6-Logout");
		}
	public static void editProfile(){
		PrintUtils.println("1-Update your password");
		PrintUtils.println("2-Update your phone number");
		PrintUtils.println("3-Update your address");
		
		}
     
}

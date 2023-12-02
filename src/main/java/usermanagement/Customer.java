package usermanagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import productmanagement.Product;
import productmanagement.ProductsManager;
import requestsmanagement.EmailSender;
import requestsmanagement.Order;
import requestsmanagement.OrderHistory;
import requestsmanagement.Appointment;
import requestsmanagement.AppointmentBooking;
import userinterface.PrintUtils;
import userinterface.Printlists;


public class Customer {
	
 private static String currentEmail;	
 private static List<Users> customerList = new ArrayList<>();
 private static List<Order> customerCart=new ArrayList<>();
 private static List<OrderHistory> orderHistory=new ArrayList<>();
 private static List<AppointmentBooking> appointmentBoooking=new ArrayList<>();

 
 
	 static {
		    Users customer0 = new Users("sawalha.saleh73@gmail.com","Jood","1234","0565589736","Ramallah");
		    Users customer =  new Users("surahamdallah@gmail.com","Sura","1234","0565589736","Ramallah");
			Users customer1 = new Users("baraahamdallah@gmail.com","Baraa","1234","0565589786","Jenin");
			Users customer2 = new Users("nabeel@gmail.com","Nabeel", "1234","0565785713","Tulkarm");
			Users customer3 = new Users("aya@gmail.com","Aya","1234","0565589786","Ramallah");
			Users customer4 = new Users("mohammadhamdallah@gmail.com","Mohammad", "1234","0565785713","Tulkarm");
			
			customerList.add(customer0);
			customerList.add(customer);
			customerList.add(customer1);
			customerList.add(customer2);
			customerList.add(customer3);
			customerList.add(customer4);
	}
	 
	 public Customer() {
		 
	 }
	
	
	 public static void customerServices() {
		ProductsManager productsManager = new ProductsManager();
	    Scanner scanner = new Scanner(System.in);
   	   
	    while(true) {
        Printlists.customerTasks();	
       
		int choice = scanner.nextInt();  
        String searchKeyword="";
        double minPrice=0;
        double maxPrice=0;
	    if(choice==7) {
         LoginLogout log=new LoginLogout();	
         log.logout();	
         PrintUtils.println("Logged out successfully");	
         customerCart.clear();
         break;	
         }
	     switch(choice) {
	     case 1:
	     editAccountInfo();	 
	     break;
	     case 2:
	     productsManager.listProducts();
	     PrintUtils.println("Do you want to buy anything? (enter yes/no)");
	     scanner.nextLine();
	     String y=scanner.nextLine();
	     if(y.equals("yes")) {
	     takeProductInfo(currentEmail);
	     }
	     else if(y.equals("no")) {
	     break;	 
	     }
         break;	 
	     case 3:
	     Printlists.searchProduct();
		 Scanner scanner1 = new Scanner(System.in);
         int num=scanner1.nextInt();
        
	     if(num==1) {
	     PrintUtils.println("Enter the beginning of the product name and we'll find it: ");
		 scanner.nextLine();
		 searchKeyword = scanner.nextLine().toLowerCase();	 
		 if(searchProducts(searchKeyword)) {
		  PrintUtils.println("Do you want to buy anything? (enter yes/no)");
		  String option=scanner.nextLine();
		  if(option.equals("yes")) {
		  takeProductInfo(currentEmail);
		 }
		  else if(option.equals("no")) {
		  break; 
		  }	 	 
		 }
	   }
	     else if(num==2) {
	     PrintUtils.println("Enter the minimum price: ");
	      minPrice = scanner.nextDouble();

	     PrintUtils.println("Enter the maximum price: ");
	     maxPrice = scanner.nextDouble();	 
	     if(searchProductsByPriceRange(minPrice,maxPrice)) {
	     scanner.nextLine();
	     PrintUtils.println("Do you want to buy anything? (enter yes/no)");
		 String option=scanner.nextLine();
		 if(option.equals("yes")) {
		 takeProductInfo(currentEmail);
		 }
		 else if(option.equals("no")) {
		 break; 
			 }	 	 
		  }
	     }
	     else {
		 PrintUtils.println("Invalid number ");
	     }
	   
	     break;	 
	     case 4:
	     if(installationForm(currentEmail)) {
	     sendInstallationRequestEmail(currentEmail); 
	     }
	     break;
	     case 5:
	     viewInstallationRequests(currentEmail);
	     break;
	     case 6:
	     viewOrderHistory(currentEmail);
	     break;
	     default:
	     PrintUtils.println("The choice is not valid");	
	     break;
	     }
		
		
		
       }//while loop 
	 
	}
	 
	 
	public static boolean viewInstallationRequests(String currentEmail2) {
		boolean found=false;
		 for (AppointmentBooking app : appointmentBoooking) {
	   	if(app.getCustomerEmail().equalsIgnoreCase(currentEmail2)) {
	   		found=true;
	   		PrintUtils.println("\nAppointment number: "+ app.getAppointment().getAppointmentNumber()+"\nInstaller Name: "+ app.getAppointment().getName()+"\nAppointment date: "+app.getAppointment().getDate()+"\nAppointment day: "+app.getAppointment().getDay()+"\nCar Brand : "+app.getCarBrand()+"\nCar Model : "+app.getCarModel()+"\nReason of request : "+app.getReason()+"\n");
	   	}
	}
		 if(!found) {
			 PrintUtils.println("No installation requests history found"); 
		 }
		 return found;
	}


	public static void sendInstallationRequestEmail(String currentEmail2) {
	
        String subject = "Installation Request";
        StringBuilder body = new StringBuilder("You have a new installaion request.\nRequest details:");
        String installerEmail="";
        for (AppointmentBooking app : appointmentBoooking) {
        	
        	if(app.getCustomerEmail().equalsIgnoreCase(currentEmail2)) {
        		installerEmail=app.getAppointment().getEmail();
            body.append("\nAppointment number: ").append(app.getAppointment().getAppointmentNumber())
                .append("\nAppointment date: ").append(app.getAppointment().getDate())
                .append("\nAppointment day: ").append(app.getAppointment().getDay())
                .append("\nAppointment time : ").append(app.getAppointment().getHour())
                .append("\nCustomer Name : ").append(app.getName())
                .append("\nCustomer phoneNumber : ").append(app.getPhone())
                .append("\nCustomer email : ").append(app.getCustomerEmail())
                .append("\nCar Brand : ").append(app.getCarBrand())
                .append("\nCar Model : ").append(app.getCarModel())
                .append("\nReason of request : ").append(app.getReason());

             }
        
        	
        	
        }

        // You can use the EmailSender class or any other method to send the email
        EmailSender.sendEmail(installerEmail, subject, body.toString());
		
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
         printAvailableAppointemnts();
         
         Appointment selectedAppointment=null;         
         PrintUtils.println("Enter the appointment number to book: ");
         int appointmentNumber = Integer.parseInt(scanner.nextLine());
         for(Appointment appointment:Installer.getAppointmentList()){
        	 if(appointment.getAppointmentNumber()==appointmentNumber){
        		 
        		if(appointment.getAvailability().equals("Booked")) {
        		PrintUtils.println("Sorry, appointment is alredy booked, choose another appointment or wait untill we add new dates");
        		return false;
        		}
        		 
        		 
        		else {
        		 selectedAppointment=getAppointment(appointmentNumber);
        		 appointment.setBooked(true);
        		 break;
        		}
        	 }
 		}
         requestInstallation(selectedAppointment,email, customerName,  phoneNumber,  reason,  carBrand, carModel); 
         return true;
	}

	
	public static void requestInstallation(Appointment  selectedAppointment,String customerEmail,String customerName, String phoneNumber, String reason, String carBrand, String carModel) {
		AppointmentBooking book=new AppointmentBooking(selectedAppointment,customerEmail,customerName,phoneNumber,reason,carBrand,carModel);
		appointmentBoooking.add(book);
		 PrintUtils.println("Appointment Booked successfully");

	}
	
	public static void printAvailableAppointemnts() {
		for(Appointment appointment:Installer.getAppointmentList()){
			PrintUtils.println(appointment);
		
	}
	
	}
	
	
	public static boolean viewOrderHistory(String email) {
	 boolean found=false;
    for(OrderHistory o:orderHistory) {
	   if(o.getCustomerEmail().equalsIgnoreCase(email)) {
		   found=true;
		   PrintUtils.println("---- Order History ----");
		   for(Order p:o.getOrderList()) {
			   PrintUtils.println( "Product: " + p.getProductName() +
               " | Quantity: " + p.getQuantity()+
               " |  Cost: " + p.getCost()+"$"+
               " | Subtotal: " + p.getSubtotal()+"$");
			   
	      }
		    PrintUtils.println("Total Cost: " + o.getTotal()+"$");
		    
		   
		  }
	   }
     if(!found) {
    	 PrintUtils.println("No order history available.");
         
     }
     return found;
	}
    
	 public static boolean searchProducts( String searchKeyword) {
	        ProductsManager productsManager=new ProductsManager();
             ArrayList<Product> matchingProducts = new ArrayList<>();
			for (Product product : productsManager.getProductList()) {
	            if (product.getName().toLowerCase().startsWith(searchKeyword)) {
	                matchingProducts.add(product);
	            }
	        }

	        if (matchingProducts.isEmpty()) {
	            PrintUtils.println("No matching products found.");
	            return false;
	        }

	        PrintUtils.println("Matching Products:");
	        for (int i = 0; i < matchingProducts.size(); i++) {
	            PrintUtils.println((i + 1) + ". " + matchingProducts.get(i).getName());
	        }

	       return true;   
	    }
	    
	 public static boolean searchProductsByPriceRange(double minPrice, double maxPrice) {
		    ProductsManager productsManager = new ProductsManager();
		    ArrayList<Product> matchingProducts = new ArrayList<>();

		    for (Product product : productsManager.getProductList()) {
		        double productPrice = product.getCost();
		        if (productPrice >= minPrice && productPrice <= maxPrice) {
		            matchingProducts.add(product);
		        }
		    }

		    if (matchingProducts.isEmpty()) {
		        PrintUtils.println("No matching products found in the specified price range.");
		        return false;
		    }

		    PrintUtils.println("Matching Products:");
		    for (int i = 0; i < matchingProducts.size(); i++) {
		        PrintUtils.println((i + 1) + ". " + matchingProducts.get(i).getName());
		        PrintUtils.println();
		    }

		    return true;
		}
	 
	 
	 
	 
	 public static void confirmOrDelete(String email) {
	 Scanner scanner = new Scanner(System.in);
     PrintUtils.println("Enter your choice: ");	
     Printlists.confirmOrDelete();
     int choice = scanner.nextInt();
	 switch(choice) {
	 case 1:
	 confirmOrder(email);	
	 sendOrderConfirmationEmail(email);
	 break;	 
	 case 2:
	 emptyCart();
	 PrintUtils.println("All products in the cart has been deleted ");
	 break;
	 
	 }
	 }

	public static void emptyCart() {
	customerCart.clear();
	}

	
	public static void takeProductInfo(String email) {
	 while(true) {
	 ProductsManager productsManager = new ProductsManager(); 
	 Scanner scanner = new Scanner(System.in);
	 PrintUtils.println("Enter the product name: ");
	 String productName = scanner.nextLine();
	 
	 if(!productsManager.checkexsist(productName)) {
	 Product prod=productsManager.getProduct(productName); 
	 PrintUtils.println("Enter the quantity : ");	 
	 int quantity = scanner.nextInt();	 
	 if(quantity > prod.getQuantity()|| quantity<=0){
	 PrintUtils.println("Not enough stock available for the selected quantity."); 
	 }
	 else {
	 addToCart(prod.getName(),prod.getCost(),quantity);	 
	 PrintUtils.println("\nIf you'r done shopping enter (exit) to confirm or delete the order, if you want to continue just press the (enter) button.");
	 scanner.nextLine();
	 String exit = scanner.nextLine();
	 if(exit.equals("exit")) {
	  confirmOrDelete(email);
	  break;
	 }
	}
	 
	 }// first if
	 
	 else {
	 PrintUtils.println("Product not found.");	 
	 } 
   }
}

	public static void addToCart(String productName,double cost,int quantity ) {
		 double subtotal=cost*quantity;	
		 customerCart.add(new Order(productName,cost,quantity,subtotal));
		 PrintUtils.println("Product added successfully to your shopping cart"+"\nProduct Name: "+productName+"\nProduct cost: "+cost+"$"+"\nProduct quantity: "+quantity+"\nSubtotal: "+subtotal+"$" );
	}
   
	public static void confirmOrder(String email) {
		 double total=0;
		  for(Order o:customerCart) {
	        	total+=o.getSubtotal();
	      }
		orderHistory.add(new OrderHistory(customerCart,email,total));
		PrintUtils.println("Order confirmed successfully");
		PrintUtils.println("Total cost= "+total+"$");
		ProductsManager prod=new ProductsManager();
		   for (Product i : prod.getProductList()) {
		        for(Order o:customerCart) {
		        	if(i.getName().equals(o.getProductName())) {
		        		i.setQuantity(i.getQuantity()-o.getQuantity());
		        	}
		        }
		      }
		}

	public static void sendOrderConfirmationEmail(String customerEmail) {
	      // Replace the following placeholders with your actual email sending logic
        String subject = "Order Confirmation";
        StringBuilder body = new StringBuilder("Thank you for your order! Your order has been placed successfully.\nOrder details:");
        double total=0;
        for (Order order : customerCart) {
            body.append("\nProduct name: ").append(order.getProductName())
                .append("\nProduct quantity: ").append(order.getQuantity())
                .append("\nProduct price: ").append(order.getCost()).append("$")
                .append("\nProduct subtotal : ").append(order.getSubtotal()).append("$\n");
        }
        for(OrderHistory o:orderHistory) {
        	if(o.getCustomerEmail().equalsIgnoreCase(customerEmail)) {
        		 total=o.getTotal();	
        	}
        	
        	
        }
        body.append("\nTotal cost of the order: ").append(total).append("$");

        // You can use the EmailSender class or any other method to send the email
        EmailSender.sendEmail(customerEmail, subject, body.toString());
	  }
	
	
     
	 public static void editAccountInfo() {
	 Customer customer=new Customer();	 
	 Scanner scanner = new Scanner(System.in);	 
	 while(true) {
	 Printlists.editProfile();	 
	 int choice = scanner.nextInt();	 
	 scanner.nextLine();
	 if(choice==5) {
     break;		 
	 }
	 switch(choice) {
	 case 1:
	 PrintUtils.println("Enter your old password");
	 String pass=scanner.nextLine();
	 PrintUtils.println("Enter your new password");
	 String newpass=scanner.nextLine();
	 customer.updatePass(currentEmail,pass,newpass);
	 break;
	 case 2:
	 PrintUtils.println("Enter your new phone number");
	 String newName=scanner.nextLine();
 	 customer.updatePhonenumber(currentEmail,newName);
     break;
	 case 3:
	 PrintUtils.println("Enter your new phone number");
 	 String newPhone=scanner.nextLine();
 	 customer.updatePhonenumber(currentEmail,newPhone);
 	 break;
	 case 4:
 	 PrintUtils.println("Enter your new address");
     String newAddress=scanner.nextLine();
     customer.updateAddress(currentEmail,newAddress);
     break;
     default:
     PrintUtils.println("Invalid choice. Please select a valid option.");
     break;
	 }//switch
	 
    }//while loop ends here
		 
 }
	 
    //Edit account info
 	 public void updateName(String email, String newName) {
		   for (Users i : customerList) {
	           if (i.getEmail().equalsIgnoreCase(email)) {
	        	i.setUsername(newName);
	              
	            PrintUtils.println("Name Updated successfully");
	            return;
	           }
	       }
	       PrintUtils.println("Wrong input");
	    }
	 
	 public  void updatePass(String email,String oldpass,String newPass) {
	       for (Users i : customerList) {
	           if (i.getEmail().equalsIgnoreCase(email)&&i.getPassword().equals(oldpass)) {
	        	i.setPassword(newPass);
	              
	            PrintUtils.println("Password Updated successfully");
	            return;
	           }
	       }
	       PrintUtils.println("Wrong input");
	   }
	   
	 public  void updatePhonenumber(String email, String newPhonenumber) {
		   for (Users i : customerList) {
	           if (i.getEmail().equalsIgnoreCase(email)) {
	        	i.setPhoneNumber(newPhonenumber);
	              
	            PrintUtils.println("Phone number Updated successfully");
	            return;
	           }
	       }
	       PrintUtils.println("Wrong input");
	   }
	   
	 public  void updateAddress(String email, String newAddress) {
		 for (Users i : customerList) {
	           if (i.getEmail().equalsIgnoreCase(email)) {
	        	i.setAddress(newAddress);
	              
	           PrintUtils.println("Address Updated successfully");
	           return;
	           }
	       }
	       PrintUtils.println("Wrong input");
	   }
	  
	 
	 //list accounts for admin
	public static  void printAccounts() {
	PrintUtils.println("-----------------------------------------------------");	
	PrintUtils.println("\nCustomers List");
	for (Users i : customerList) {
		System.out.println("Customer Email: " + i.getEmail());
        System.out.println("Customer Name: " + i.getName());
        System.out.println("Customer Phone number: " + i.getPhoneNumber());
        System.out.println("Customer Address: " + i.getAddress());
        System.out.println();
        System.out.println("*******");
	}
	PrintUtils.println("-----------------------------------------------------");
	}
	 
	 //delete account for admin
	 public void deleteAccount(String email) {
	 boolean found=false;
	 Iterator<Users> listIterator = customerList.iterator();
	 while (listIterator.hasNext()) {
	 Users customer = listIterator.next();
	 if (customer.getEmail().equalsIgnoreCase(email)) {
		 listIterator.remove();  // Use iterator's remove method to avoid ConcurrentModificationException
	 PrintUtils.println("Customer deleted successfully.");
	 found = true;
	  return;
	       }
	  }
	 if(!found) {
	   PrintUtils.println("Customer email cannot be found"); 
	   }	
	}
	 
	  public static Appointment  getAppointment(int num) {
		for (Appointment a : Installer.getAppointmentList()) {
	          if (a.getAppointmentNumber()==num) {
	              return a;
	          }
	      }
	      return null; // Product not found  
		  
	  }
	  
	  public static  List<Users> getList(){
	       return customerList;
	  }
	 
	  public static  List<OrderHistory> getOrderList(){
		    return orderHistory;
	  }
       
	  public static  List<AppointmentBooking> getBookingList(){
		    return appointmentBoooking;
	  }
	  
	  
	 public static void setCurrent(String email) {
	 currentEmail=email;	 
	 }
}

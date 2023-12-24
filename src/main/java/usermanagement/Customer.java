package usermanagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import productmanagement.Product;
import productmanagement.ProductsManager;
import requestsmanagement.*;
import userinterface.*;


public class Customer {
private static final String WRONG="Wrong input";
 private static  List<User> customerList = new ArrayList<>();
 private  List<Order> customerCart=new ArrayList<>();
 private static List<OrderHistory> orderHistory=new ArrayList<>();
 private static List<AppointmentBooking> appointmentBoooking=new ArrayList<>();

 
 
	 static {
		   
			customerList.add(new User("sawalha.saleh73@gmail.com","Jood","1234","0565589736","Nablus"));
			customerList.add(new User("surahamdallah@gmail.com","Sura","1234","0565589736","Ramallah"));
			customerList.add(new User("baraahamdallah@gmail.com","Baraa","1234","0565589786","Jenin"));
			customerList.add(new User("nabeel@gmail.com","Nabeel", "1234","0565785713","Tulkarm"));
			customerList.add(new User("aya@gmail.com","Aya","1234","0565589786","Ramallah"));
			customerList.add(new User("mohammadhamdallah@gmail.com","Mohammad", "1234","0565785713","Tulkarm"));
	}
	 
	 public Customer() {
    // TODO document why this constructor is empty
  }
	 
	 
	public boolean viewInstallationRequests(String currentEmail2) {
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


	public void sendInstallationRequestEmail(String currentEmail2) {
	
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

	public void requestInstallation(Appointment  selectedAppointment,String customerEmail,String customerName, String phoneNumber, String reason, String carBrand, String carModel) {
	     AppointmentBooking book=new AppointmentBooking(selectedAppointment,customerEmail,customerName,phoneNumber,reason,carBrand,carModel);
		 selectedAppointment.setBooked(true);
		 appointmentBoooking.add(book);
		 PrintUtils.println("Appointment Booked successfully");

	}
	
	public void printAvailableAppointemnts() {
		for(Appointment appointment:Installer.getAppointmentList()){
			PrintUtils.println(appointment);
		
	}
	
	}
	public  boolean viewOrderHistory(String email) {
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
    
	
	 public boolean searchProducts( String searchKeyword) {
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
	    
	 public  boolean searchProductsByPriceRange(double minPrice, double maxPrice) {
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
	 
	 
	

	public void emptyCart() {
	customerCart.clear();

	}


	public void addToCart(String productName,double cost,int quantity ) {
		 double subtotal=cost*quantity;	
		 customerCart.add(new Order(productName,cost,quantity,subtotal));
		 PrintUtils.println("Product added successfully to your shopping cart"+"\nProduct Name: "+productName+"\nProduct cost: "+cost+"$"+"\nProduct quantity: "+quantity+"\nSubtotal: "+subtotal+"$" );
	}
   
	public void confirmOrder(String email) {
		 double total=0;
		 
		  List<Order> cartCopy = new ArrayList<>(customerCart);
		    
		  // Calculate the total
		  for (Order o : cartCopy) {
	      total += o.getSubtotal();
		  }

	     // Add the copy to orderHistory
		 orderHistory.add(new OrderHistory(cartCopy, email, total));
	
		 
		PrintUtils.println("Order confirmed successfully");
		PrintUtils.println("Total cost= "+total+"$");
		ProductsManager prod=new ProductsManager();
		   for (Product i : prod.getProductList()) {
		        for(Order o:cartCopy) {
		        	if(i.getName().equalsIgnoreCase(o.getProductName())) {
		        		
		        		i.setQuantity(i.getQuantity()-o.getQuantity());
		        	}
		        }
		      }
		}

	public void sendOrderConfirmationEmail(String customerEmail) {
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
       customerCart.clear();
	  }
	
	
 
	 
    //Edit account info
 	 public void updateName(String email, String newName) {
		   for (User i : customerList) {
	           if (i.getEmail().equalsIgnoreCase(email)) {
	        	i.setUsername(newName);
	              
	            PrintUtils.println("Name Updated successfully");
	            return;
	           }
	       }
	    }
	 
	 public  void updatePass(String email,String oldpass,String newPass) {
	       for (User i : customerList) {
	           if (i.getEmail().equalsIgnoreCase(email)&&i.getPassword().equals(oldpass)) {
	        	i.setPassword(newPass);
	              
	            PrintUtils.println("Password Updated successfully");
	            return;
	           }
	       }
	       PrintUtils.println( WRONG);
	   }
	   
	 public  void updatePhonenumber(String email, String newPhonenumber) {
		   for (User i : customerList) {
	           if (i.getEmail().equalsIgnoreCase(email)) {
	        	i.setPhoneNumber(newPhonenumber);
	              
	            PrintUtils.println("Phone number Updated successfully");
	            return;
	           }
	       }
	   }
	   
	 public  void updateAddress(String email, String newAddress) {
		 for (User i : customerList) {
	           if (i.getEmail().equalsIgnoreCase(email)) {
	        	i.setAddress(newAddress);
	              
	           PrintUtils.println("Address Updated successfully");
	           return;
	           }
	       }
	   }
	  
	 
	 //list accounts for admin
	public static void printAccounts() {
	PrintUtils.println("-----------------------------------------------------");	
	PrintUtils.println("\nCustomers List");
	for (User i : customerList) {
		PrintUtils.println("Customer Email: " + i.getEmail());
		PrintUtils.println("Customer Name: " + i.getName());
		PrintUtils.println("Customer Phone number: " + i.getPhoneNumber());
		PrintUtils.println("Customer Address: " + i.getAddress());
		PrintUtils.println();
		PrintUtils.println("*******");
	}
	PrintUtils.println("-----------------------------------------------------");
	}
	 
	 //delete account for admin
	 public void deleteAccount(String email) {
	 Iterator<User> listIterator = customerList.iterator();
	 while (listIterator.hasNext()) {
	 User customer = listIterator.next();
	 if (customer.getEmail().equalsIgnoreCase(email)) {
		 listIterator.remove();  // Use iterator's remove method to avoid ConcurrentModificationException
	 PrintUtils.println("Customer deleted successfully.");
	  
	  return;
	       }
	  }
	
	   PrintUtils.println("Customer email cannot be found"); 
	   	
	}
	 
	  public static Appointment getAppointment(int num) {
		for (Appointment a : Installer.getAppointmentList()) {
	          if (a.getAppointmentNumber()==num) {
	              return a;
	          }
	      }
	      return null; 
		  
	  }
	  
	  public static List<User> getCustomerList(){
	       return customerList;
	  }
	 
	  public  List<OrderHistory> getOrderList(){
		    return orderHistory;
	  }
       
	  public static  List<AppointmentBooking> getBookingList(){
		    return appointmentBoooking;
	  }
	   
	
}

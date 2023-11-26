package usermanagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import userinterface.PrintUtils;

public class Customer {
 private static List<Users> customerList = new ArrayList<>();
 
	 static {
		    Users customer = new Users("surahamdallah@gmail.com","Sura","1234","0565589736","Ramallah");
			Users customer1 = new Users("baraahamdallah@gmail.com","Baraa","1234","0565589786","Jenin");
			Users customer2 = new Users("nabeel@gmail.com","Nabeel", "1234","0565785713","Tulkarm");
			Users customer3 = new Users("aya@gmail.com","Aya","1234","0565589786","Ramallah");
			Users customer4 = new Users("mohammadhamdallah@gmail.com","Mohammad", "1234","0565785713","Tulkarm");
			
			customerList.add(customer);
			customerList.add(customer1);
			customerList.add(customer2);
			customerList.add(customer3);
			customerList.add(customer4);
	}
	 public Customer() {
		 
	 }
	 
	 
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
	 
	 public void updatePass(String email,String oldpass,String newPass) {
	       for (Users i : customerList) {
	           if (i.getEmail().equalsIgnoreCase(email)&&i.getPassword().equals(oldpass)) {
	        	i.setPassword(newPass);
	              
	            PrintUtils.println("Password Updated successfully");
	            return;
	           }
	       }
	       PrintUtils.println("Wrong input");
	   }
	   
	   public void updatePhonenumber(String email, String newPhonenumber) {
		   for (Users i : customerList) {
	           if (i.getEmail().equalsIgnoreCase(email)) {
	        	i.setPhoneNumber(newPhonenumber);
	              
	            PrintUtils.println("Phone number Updated successfully");
	            return;
	           }
	       }
	       PrintUtils.println("Wrong input");
	   }
	   
	    public void updateAddress(String email, String newAddress) {
		 for (Users i : customerList) {
	           if (i.getEmail().equalsIgnoreCase(email)) {
	        	i.setAddress(newAddress);
	              
	           PrintUtils.println("Phone number Updated successfully");
	           return;
	           }
	       }
	       PrintUtils.println("Wrong input");
	   }
	   
	 
	public static void printAccounts() {
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
	 
	
	 public static  List<Users> getList(){
	       return customerList;
	 }
}

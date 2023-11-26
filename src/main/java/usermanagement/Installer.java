package usermanagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import userinterface.PrintUtils;

public class Installer {
	 private static List<Users> installerList = new ArrayList<>();
	 static {
		  	
			Users installer1 = new Users("leema@gmail.com","Leema","1234","0565589786","Qalqilya");
			Users installer2 = new Users("dana@gmail.com","Dana", "1234","0565785713","Nablus");
			
			
			installerList.add(installer1);
			installerList.add(installer2);
			
	}
	 
	 public Installer() {
		 
	 }
	 
	  public void addInstaller(String email,String name, String password, String phonenumber, String address) {
		  boolean found=false;
		  Users newInstaller = new Users(email,name,password,phonenumber,address);
			for(Users i:installerList) {
		    if(i.getEmail().equalsIgnoreCase(email)) {
		    found=true;
		    PrintUtils.println("This installer email is already registered");
		    break;
		    }
		}
		 if(!found) {
			installerList.add(newInstaller);
			PrintUtils.println("Installer added successfully");
		 }
		    
	        
	  }
	  
	  public void deleteAccount(String email) {
	 boolean found=false;
	 Iterator<Users> listIterator = installerList.iterator();
	 while (listIterator.hasNext()) {
	 Users installer = listIterator.next();
	 if (installer.getEmail().equalsIgnoreCase(email)) {
	 listIterator.remove();  // Use iterator's remove method to avoid ConcurrentModificationException
	 PrintUtils.println("Installer deleted successfully.");
	 found = true;
	  return;
	       }
	  }
	 if(!found) {
	   PrintUtils.println("Installer email cannot be found"); 
	   }	
	}
	 
		public static void printAccounts() {
			PrintUtils.println("-----------------------------------------------------");	
			PrintUtils.println("\nInstallers List");
			for (Users i : installerList) {
				
				System.out.println("Installer Email: " + i.getEmail());
		        System.out.println("Installer Name: " + i.getName());
		        System.out.println("Installer Phone number: " + i.getPhoneNumber());
		        System.out.println("Installer Address: " + i.getAddress());
		        System.out.println();
		        System.out.println("*******");
			}
			PrintUtils.println("-----------------------------------------------------");
			}
	 
	 public static List<Users> getList(){
	       return installerList;
	 }	 
}

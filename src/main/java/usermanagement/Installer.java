package usermanagement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import requestsmanagement.Appointment;
import requestsmanagement.AppointmentBooking;

import userinterface.PrintUtils;
import userinterface.Printlists;

public class Installer {
	 
	 private static List<User> installerList = new ArrayList<>();
	 private static List<Appointment> appointmentList=new ArrayList<>();
	 	
     
	
	 
	 static Scanner scanner = new Scanner(System.in);
	 static {
     installerList.add(new User("s12028227@stu.najah.edu","Jood Hamdallah","1234","0565584756","Tulkarm"));
	 installerList.add(new User("leema@gmail.com","Leema","1234","0565589786","Qalqilya"));
	 installerList.add(new User("dana@gmail.com","Dana", "1234","0565785713","Nablus"));
	 appointmentList.add(new Appointment("2023-12-12", "Tuesday", "10:30 AM","s12028227@stu.najah.edu","Jood Hamdallah"));
	 appointmentList.add(new Appointment("2023-12-24", "Sunday", "3:30 AM","leema@gmail.com","Leema"));
   
	}
	  
	  public Installer() {
     // TODO document why this constructor is empty
   }

	
	  public void deleteAppointmentByNumber(int number) {
		    Iterator<Appointment> iterator = appointmentList.iterator();
		    while (iterator.hasNext()) {
		        Appointment appointment = iterator.next();
		        if (appointment.getAppointmentNumber() == number) {
		            iterator.remove();
		            PrintUtils.println("Appointment deleted successfully");
		        }
		    }
		}
	  
	  
	public  boolean viewAppointmentBookings(String currentEmail2) {
		  boolean found=false;
		 List<AppointmentBooking> appointmentBookings=Customer.getBookingList();
		 for (AppointmentBooking app : appointmentBookings) {
         	if(app.getAppointment().getEmail().equalsIgnoreCase(currentEmail2)) {
         	PrintUtils.println("\nAppointment number: "+ app.getAppointment().getAppointmentNumber()+"\nInstaller Name: "+ app.getAppointment().getName()+"\nAppointment date: "+app.getAppointment().getDate()+"\nAppointment day: "+app.getAppointment().getDay()+"\nCustomer Name : "+app.getName()+"\nCustomer phone number : "+app.getPhone() +"\nCar Brand : "+app.getCarBrand()+"\nCar Model : "+app.getCarModel()+"\nReason of request : "+app.getReason()+"\n");	
         	found=true;	
         	}
         }
		 
		 if(!found) {
		  PrintUtils.println("No booked appointments"); 
		 }
		 return found;
	  }

	

	
   public  void addAppointemnt(String date, String day, String hour,String  installerEmail,String installerName) {
        Appointment newAppointment = new Appointment(date, day, hour,installerEmail, installerName);
        appointmentList.add(newAppointment);
        PrintUtils.println("Appointment added: " + newAppointment);
    }

	public boolean viewAppointments(String installerEmail) {
            boolean found=false;
            for (Appointment appointment : appointmentList) {
            	if(appointment.getEmail().equalsIgnoreCase(installerEmail)) {
            	found=true;	
            	 PrintUtils.println(appointment);
            	}
            }
        if(!found){
        PrintUtils.println("No appointments available.");
        }
        return found;
    }

	public void addInstaller(String email,String name, String password, String phonenumber, String address) {
		  boolean found=false;
		  User newInstaller = new User(email,name,password,phonenumber,address);
			for(User i:installerList) {
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
	
	 Iterator<User> listIterator = installerList.iterator();
	 while (listIterator.hasNext()) {
	 User installer = listIterator.next();
	 if (installer.getEmail().equalsIgnoreCase(email)) {
	 listIterator.remove();  // Use iterator's remove method to avoid ConcurrentModificationException
	 PrintUtils.println("Installer deleted successfully.");
	
	  return;
	       }
	  }
	 
	   PrintUtils.println("Installer email cannot be found"); 
	   	
	}
	 
		public static void printAccounts() {
			PrintUtils.println("-----------------------------------------------------");	
			PrintUtils.println("\nInstallers List");
			for (User i : installerList) {
				
				 PrintUtils.println("Installer Email: " + i.getEmail());
				 PrintUtils.println("Installer Name: " + i.getName());
				 PrintUtils.println("Installer Phone number: " + i.getPhoneNumber());
				 PrintUtils.println("Installer Address: " + i.getAddress());
				 PrintUtils.println();
				 PrintUtils.println("*******");
			}
			PrintUtils.println("-----------------------------------------------------");
	}
	 
		
	
		
	 public static List<User> getInstallerList(){
	       return installerList;
	 }	
	 
	 public static List<Appointment> getAppointmentList(){
	       return appointmentList;
	 }	

	 
	 
}

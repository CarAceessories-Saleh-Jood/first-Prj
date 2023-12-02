package usermanagement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.Scanner;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import requestsmanagement.Appointment;
import requestsmanagement.AppointmentBooking;

import java.util.Properties;
import userinterface.PrintUtils;
import userinterface.Printlists;

public class Installer {
	 private static String currentEmail;
	 private static List<Users> installerList = new ArrayList<>();
	 private static List<Appointment> appointmentList=new ArrayList<>();
	 	
     
	
	 
	 static Scanner scanner = new Scanner(System.in);
	 static {
     installerList.add(new Users("s12028227@stu.najah.edu","Jood Hamdallah","1234","0565584756","Tulkarm"));
	 installerList.add(new Users("leema@gmail.com","Leema","1234","0565589786","Qalqilya"));
	 installerList.add(new Users("dana@gmail.com","Dana", "1234","0565785713","Nablus"));
	 appointmentList.add(new Appointment("2023-12-12", "Tuesday", "10:30 AM","s12028227@stu.najah.edu","Jood Hamdallah"));
	 appointmentList.add(new Appointment("2023-12-24", "Sunday", "3:30 AM","leema@gmail.com","Leema"));
   
	}
	  
	  public Installer() {
		  
       }

	  public static void installerTasks() {
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
	     newAppointment(currentEmail); 
	     break;
		 case 2:
		 PrintUtils.println("All available Appointments:");
         viewAppointments(currentEmail);
		 break;
		 case 3:
		 viewAppointmentBookings(currentEmail);	
		 break;
		 case 4:
	     if(viewAppointments(currentEmail)) {
	     deleteAppointment();	 
	     }
	     break;
		 default:
		 PrintUtils.println("The choice is not valid");	
		 break;
			
	     }
		 
	   }//while
	} 
	  
	
	  public static void deleteAppointment() {
		Scanner scanner = new Scanner(System.in);
        PrintUtils.println("Enter the appointment number you want to delete:"); 
        int appointmentNumber=scanner.nextInt();
        deleteAppointmentByNumber(appointmentNumber);
        
	 }

	  public static void deleteAppointmentByNumber(int number) {
		    Iterator<Appointment> iterator = appointmentList.iterator();
		    while (iterator.hasNext()) {
		        Appointment appointment = iterator.next();
		        if (appointment.getAppointmentNumber() == number) {
		            iterator.remove();
		            PrintUtils.println("Appointment deleted successfully");
		        }
		    }
		}
	  
	  
	public static boolean viewAppointmentBookings(String currentEmail2) {
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

	public static void newAppointment(String currentEmail2) {
		  Scanner scanner = new Scanner(System.in);
		  String installerName="";
		  System.out.print("Enter your name ");
          String name = scanner.nextLine();
		  System.out.print("Enter date (e.g., 01-12-2023): ");
          String date = scanner.nextLine();
          System.out.print("Enter day (e.g., Monday): ");
          String day = scanner.nextLine();
          System.out.print("Enter hour (e.g., 09:00 AM): ");
          String hour = scanner.nextLine();
          
           addAppointemnt(date,day,hour,currentEmail2, name);
		
	}

	
   public static void addAppointemnt(String date, String day, String hour,String  installerEmail,String installerName) {
        Appointment newAppointment = new Appointment(date, day, hour,installerEmail, installerName);
        appointmentList.add(newAppointment);
        PrintUtils.println("Appointment added: " + newAppointment);
    }

	public static boolean viewAppointments(String installerEmail) {
            boolean found=false;
            for (Appointment appointment : appointmentList) {
            	if(appointment.getEmail().equalsIgnoreCase(installerEmail)) {
            	found=true;	
                System.out.println(appointment);
            	}
            }
        if(!found){
        PrintUtils.println("No appointments available.");
        }
        return found;
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
	 
		
	 public static void setCurrent(String email) {
			 currentEmail=email;	 
	 }	
		
	 public static List<Users> getList(){
	       return installerList;
	 }	
	 
	 public static List<Appointment> getAppointmentList(){
	       return appointmentList;
	 }	

	 
	 
}

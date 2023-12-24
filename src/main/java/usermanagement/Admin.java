package usermanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import requestsmanagement.AppointmentBooking;
import userinterface.PrintUtils;

public class Admin{
	static Scanner scanner = new Scanner(System.in);	
	private static List<User> adminList = new ArrayList<>();
	static {
    adminList.add(new User("jood.hamdallah12@gmail.com","Jood Hamdallah","1234","0565584756","Tulkarm"));
	adminList.add(new User("sawalha.saleh3@gmail.com","Saleh Sawalha", "1234","0565785656","Nablus"));
	}
	

	public void viewCustomerInfo() {
        Customer.printAccounts();
    }
	
	public void viewInstallerInfo() {
        Installer.printAccounts();
    }
	
	
    public void printAppointments() {
    for (AppointmentBooking app : Customer.getBookingList()) {	
    PrintUtils.println("\nAppointment number: "+ app.getAppointment().getAppointmentNumber()+"\nInstaller Name: "+ app.getAppointment().getName()+ "\nInstaller email: "+ app.getAppointment().getEmail()+"\nCustomer Name: "+ app.getName()+"\nAppointment date: "+app.getAppointment().getDate()+"\nAppointment day: "+app.getAppointment().getDay()+"\nCar Brand : "+app.getCarBrand()+"\nCar Model : "+app.getCarModel()+"\nReason of request : "+app.getReason()+"\n");	
    }
}
   
    public static List<User> getAdminList(){
	       return adminList;
	 } 
			
}

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import userinterface.PrintUtils;
import userinterface.Printlists;
import usermanagement.Admin;
import usermanagement.Customer;
import usermanagement.Installer;
import usermanagement.LoginLogout;
import usermanagement.SignUp;
import usermanagement.Users;

public class Main {
	
	private static String Email;
	private static final String ENTER_EMAIL = "Enter your email: ";
	private static final String ENTER_PASS = "Enter your password: ";
	private static final String THANK_MSG = "Thank you for using our system. Goodbye!";
	private static final String NOT_AVAILABLE = "The choice is not valid";
	private static List<Users> userList = new ArrayList<>();
	
	public static void setlist(List<Users> userList) {
	Main.userList=userList;	
	}
	
	
	
    public static void  printLoginInfo() {
    	Scanner scan = new Scanner(System.in);	
		LoginLogout log = new LoginLogout();
		 while (true) {
		 PrintUtils.println(ENTER_EMAIL);
		 String email = scan.nextLine();
		 PrintUtils.println(ENTER_PASS);
		 String password = scan.nextLine();
		 if (log.login(email, password, userList)) {
		 PrintUtils.println("Login succeeded");
		 Email=email;
		 break; 
		 }
		 else 
		 {
		 log.printInvalid();
		 }
		 
		 }
	
     }
	
   public static void printSignUpInfo() {
    	
        Scanner scan = new Scanner(System.in);
        SignUp sign = new SignUp(userList);
        
        PrintUtils.println(ENTER_EMAIL);
        String email = scan.nextLine();
        
        while (!sign.emailFormat(email) || !sign.isEmailUnique(email)) {
        if (!sign.emailFormat(email)) {
        PrintUtils.println("Invalid email format");
        }
        if (!sign.isEmailUnique(email)) {
        PrintUtils.println("Email already exists!");
        }
        PrintUtils.println("Enter your email again: ");
        email = scan.nextLine();
        }
         Email=email;
         PrintUtils.println(ENTER_PASS);
         String password = scan.nextLine();
         PrintUtils.println("Enter your name: ");
         String name = scan.nextLine();
         PrintUtils.println("Enter your phonenumber: ");
         String phonenumber = scan.nextLine();
         PrintUtils.println("Enter your address: ");
         String address = scan.nextLine();
         
         if(!sign.signUp(email,name, password,phonenumber,address)) {
        	 PrintUtils.println("Registered successfully");
         }
   }
    
    
    
    
	public static void main(String[] args) {
     int Type;
	 PrintUtils.println("------* Welcome to our Car Accessories system *------");
     Scanner scan = new Scanner(System.in);	
	 List<Users> userList;
	 
	 while (true) {
	 try {	 
	 Printlists.userRolelist();
	 
	 Type = scan.nextInt();	 
	 
     if(Type==1){                 ///admin
    	Printlists.printLogin(); //Login or Exit
    	int num=scan.nextInt();
    	if(num==1) { //LOGIN
    	userList =Admin.getList();
    	setlist(userList);
    	printLoginInfo();
    	Admin.adminTasks();
    	}
    	else if(num==2) {
    	 
    	 PrintUtils.println(THANK_MSG);
         System.exit(1);	
    	}
    	else {
    	PrintUtils.println(NOT_AVAILABLE);
    
       }
    }
     
     if(Type==2){ //Installer
     Printlists.printLogin();
     int num=scan.nextInt();
     if(num==1) {
     userList =Installer.getList();
     setlist(userList);
     printLoginInfo();
     Installer.setCurrent(Email);
     Installer.installerTasks();
     }
     else if(num==2) {
     PrintUtils.println(THANK_MSG);
     System.exit(1);	
    	}
     else {
     PrintUtils.println(NOT_AVAILABLE);
     
     }
     }
     
     
     if(Type==3) {  //Customer
     userList =Customer.getList(); 	 
     setlist(userList);
     Printlists.printLoginorsignup();
     int num=scan.nextInt();
     if(num==1) {
     printSignUpInfo();	
     Customer.setCurrent(Email);
     Customer.customerServices();
     }
     else if(num==2) {
     printLoginInfo();
     Customer.setCurrent(Email);
     Customer.customerServices();
     }
     else if(num==3) {
     PrintUtils.println(THANK_MSG);
     System.exit(1);	 
     }
     else {
     PrintUtils.println(NOT_AVAILABLE);
 
     }
     }
     
     
     
     if(Type==4){
         PrintUtils.println(THANK_MSG);
         System.exit(1);
     }
     if (Type!=1 && Type!=2 && Type!=3 &&Type!=4) {
  	   PrintUtils.println(NOT_AVAILABLE);
        
     }
     
	 }
	
	 
	 catch (InputMismatchException e) {
         PrintUtils.println("Invalid input. Please enter a valid integer.");
         scan.nextLine(); // Consume the invalid input
       }
	 
         }//While loop ends here
	}//main function ends here	
}

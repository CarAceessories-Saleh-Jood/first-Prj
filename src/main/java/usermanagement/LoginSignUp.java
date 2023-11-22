package usermanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import userinterface.PrintUtils;



public class LoginSignUp {
	
    private static List<Users> user = new ArrayList<>();
	private boolean isLogged=false;
	private boolean isRegistered;
	
	
	static {
	  	
	Users user1 = new Users("jood.hamdallah12@gmail.com","1234","0565584756","Tulkarm","1");
	Users user2 = new Users("sawalha.saleh3@gmail.com",  "1234","0565785656","Nablus","1");
	Users user3 = new Users("user1@gmail.com","1234","0565587542","Ramallah","2");
	Users user4 = new Users("user2@gmail.com","1234","0565584756","Jenin","3");
	Users user5 = new Users("user3@gmail.com","1234","0565584756","Qalqilya","3");
	Users user6 = new Users("user4@gmail.com","1234","0565584756","Hebron","3");
	
	user.add(user1);
    user.add(user2);
	user.add(user3);
	user.add(user4);
	user.add(user5);
	user.add(user6);
	}
	
	 public LoginSignUp(){}
	 
	
	
	public boolean emailCheck(String email) {
		
		for (Users i : user) {
	    if (i.getEmail().equalsIgnoreCase(email) ) {
		          
	    return false;	
	    }
	    }
		
		return true; 
    }
	
	
	public boolean emailFormat(String email) {
		 return email.contains("@gmail.com");
	}
	
	
	 public boolean signUp(String email, String password, String phonenumber, String address, String type ) {
	Users userget = new Users(email,password,phonenumber,address,type) ;
	for (Users i : user) {
    if (i.getEmail().equals(email) ) {
	          
    isRegistered=true;	
    
    } 
	else {
	addToArrayList(userget);
	setIsLogged(true);
	//isLogged=true;
	break;
	}
    }
	return isRegistered; 
	}
	 	   

	 	   
   public boolean login(String Email, String loginPassword,String type) {
   for (Users i : user) {
   if (i.getEmail().equals(Email)&& i.getPassword().equals(loginPassword)&&i.gettype().equals(type)){
	
    isLogged=true; 
    }
	}
     return isLogged;
    }
   
   public void updatePass(String email,String oldpass,String newPass) {
       for (Users i : user) {
           if (i.getEmail().equals(email)&&i.getPassword().equals(oldpass)) {
        	i.setPassword(newPass);
              
            PrintUtils.println("Password Updated successfully");
            break;
           }
       }
       PrintUtils.println("Wrong input");
      
   }
   
   public void updatePhonenumber(String email, String newPhonenumber) {
	   for (Users i : user) {
           if (i.getEmail().equals(email)) {
        	i.setPhoneNumber(newPhonenumber);
              
            PrintUtils.println("Phone number Updated successfully");
            break;
           }
       }
       PrintUtils.println("Wrong input");
       
   }
   
   
   
   public void updateAddress(String email, String newAddress) {
	   for (Users i : user) {
           if (i.getEmail().equals(email)) {
        	i.setSAddress(newAddress);
              
            PrintUtils.println("Phone number Updated successfully");
           break;
           }
       }
       PrintUtils.println("Wrong input");
       
   }
   
   
   
  public boolean getIsLogged() {
	    return this.isLogged;
   }
  
  public void logout() {
	  this.isLogged=false;
}
  
   public boolean getIsRegistered() {
	   return isRegistered;
   } 
   
   public static void addToArrayList(Users obj) {
      user.add(obj);
   }

   public  void setIsLogged(boolean islogged) {
	this.isLogged=islogged;   
   }
   
   public List<Users> getList(){
       return user;
   }
   
   public  void printInvalid() {
	 PrintUtils.println("Invalid email or password");
	 }
	    
	    
}

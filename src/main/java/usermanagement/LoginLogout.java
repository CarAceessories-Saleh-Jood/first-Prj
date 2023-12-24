package usermanagement;

import java.util.List;

import userinterface.PrintUtils;

public class LoginLogout {

	

	
private boolean isLogged=false;


   public boolean login(String email, String password, List<User> userList) {
	   for (User i : userList) {
	   if (i.getEmail().equalsIgnoreCase(email)&& i.getPassword().equals(password)){
		
	    isLogged=true; 
	    }
		}
	     return isLogged;
      }

  public void logout() {
  this.isLogged=false;
  }

  public void setIsLogged(boolean islogged) {
	this.isLogged=islogged;   
  }

  public void printInvalid() {
	  PrintUtils.println("Invalid email or password");
  }

  public boolean getIsLogged() {
    return this.isLogged;
 }
}

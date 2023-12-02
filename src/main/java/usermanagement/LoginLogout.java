package usermanagement;

import java.util.List;

import userinterface.PrintUtils;

public class LoginLogout {
	
private boolean isLogged=false;

public LoginLogout() {
	
}

   public boolean login(String Email, String password, List<Users> userList) {
	   for (Users i : userList) {
	   if (i.getEmail().equalsIgnoreCase(Email)&& i.getPassword().equals(password)){
		
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

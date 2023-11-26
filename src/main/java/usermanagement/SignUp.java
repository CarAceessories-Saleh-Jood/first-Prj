package usermanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp {
	
	private boolean isRegistered=false;
	private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$";
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
	private List<Users> customerList;

    public SignUp(List<Users> customerList) {
	this.customerList = customerList;
	}
	
	public boolean isEmailUnique(String email) {
		if (email == null) {
        throw new IllegalArgumentException("Email cannot be null");
    }
		for (Users i : customerList) {
	    if (i.getEmail().equalsIgnoreCase(email) ) {
		          
	    return false;	
	    }
	    }
		
		return true; 
    }
	
  public boolean emailFormat(String email) {
		
		Matcher matcher = EMAIL_PATTERN.matcher(email);
		return  matcher.matches();
	}
  
  public boolean signUp(String email,String name, String password, String phonenumber, String address) {
	    LoginLogout log=new LoginLogout();
		Users newCustomer = new Users(email,name,password,phonenumber,address);
		
	    if(customerList.add(newCustomer)) {
	    isRegistered=true;	
	    }
	    log.setIsLogged(true);
	    
       return isRegistered;
}
  
  public boolean getIsRegistered() {
	   return isRegistered;
  }
}

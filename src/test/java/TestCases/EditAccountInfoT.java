package TestCases;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import usermanagement.Customer;
import usermanagement.LoginLogout;
import usermanagement.Users;

//@Before
public class EditAccountInfoT {
	private String email,name,password,phonenumber,address,newpass,newname,newphone,newaddress;
    LoginLogout obj;
    Customer obj2;
    List<Users> usersList;
    
    
    
    public EditAccountInfoT() {
    this.obj=new LoginLogout();
    this.obj2=new Customer();
    usersList = obj2.getList();
   }
	@Given("the customer is logged in with email {string} and password {string}")
	public void theCustomerIsLoggedInWithEmailAndPassword(String email, String password) {
		this.email=email;	
		this.password=password;
	    obj.login(email, password,this.usersList);
		assertTrue(obj.getIsLogged());
	}

	@Given("he enters a new password {string}")
	public void heEntersANewPassword(String newpass) {
 this.newpass=newpass;
	}

	@Then("the password will be changed")
	public void thePasswordWillBeChanged() {
		
		obj2.updatePass( email,password, newpass);	
			
	  for (Users i : usersList) {
	   if (i.getEmail().equals(email)){
		
	     this.password=i.getPassword();
	     break;
	    }
		}
	  assertEquals(newpass,this.password); 
	    }

	@Given("he enters a new name {string}")
	public void heEntersANewName(String newname) {
	  this.newname=newname;
	}

	@Then("the name will be changed")
	public void theNameWillBeChanged() {
		
			
	obj2.updateName(email, newname);	
     for (Users i : usersList) {
	 if (i.getEmail().equals(email)){
				
	 this.name=i.getName();
	 break;
	}
	}
	 assertEquals(newname,this.name); 
		
	}

	@Given("he enters a new phone number {string}")
	public void heEntersANewPhoneNumber(String newphone) {
	this.newphone=newphone;
	}

	@Then("the phone number  will be changed")
public void thePhoneNumberWillBeChanged() {
		
		obj2.updatePhonenumber(email,newphone);	
		
		  for (Users i : usersList) {
		   if (i.getEmail().equals(email)){
			
		     this.phonenumber=i.getPhoneNumber();
		     break;
		    }
			}
		  assertEquals(newphone,this.phonenumber); 
	}


	@Given("he enters a new address {string}")
	public void heEntersANewAddress(String newaddress) {
		 this.newaddress=newaddress;  
	}

	@Then("the address  will be changed")
	public void theAddressWillBeChanged() {
		obj2.updateAddress(email, newaddress);
		
		  for (Users i : usersList) {
		   if (i.getEmail().equals(email)){
			
		     this.address=i.getAddress();
		     break;
		    }
			}
		  assertEquals(newaddress,this.address); 
		
	}
}

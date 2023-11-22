package Testcar;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import usermanagement.LoginSignUp;
import usermanagement.Users;
public class EditAccountInfoT {
	private String email,password,phonenumber,address,userchoice,newpass,newphone,newaddress;
    LoginSignUp obj;
    Users obj1;
    List<Users> usersList;
    
    public EditAccountInfoT() {
    this.obj=new LoginSignUp();
    this.obj1=new Users();
     usersList = obj.getList();
   }
	@Given("the customer is logged in with email {string} and password {string} and userType {string}")
	public void theCustomerIsLoggedInWithEmailAndPassword(String email, String password,String userchoice) {
		this.email=email;	
		this.password=password;
		System.out.println(password);
		this.userchoice=userchoice;
		obj.login(email, password,userchoice);
		assertTrue(obj.getIsLogged());
		}

	@Given("he enters a new password {string}")
	public void heEntersANewPassword(String newpass) {
		  this.newpass=newpass;
	}

	@Then("the password will be changed")
	public void thePasswordWillBeChanged() {
	
	obj.updatePass( email,password, newpass);	
		
  for (Users i : usersList) {
   if (i.getEmail().equals(email)){
	
     this.password=i.getPassword();
     break;
    }
	}
  assertEquals(newpass,this.password); 
    }
		
 @Given("he enters a new phone number {string}")
	public void heEntersANewPhoneNumber(String newphone) {
		   this.newphone=newphone;
	}

	@Then("the phone number  will be changed")
	public void thePhoneNumberWillBeChanged() {
		
		obj.updatePhonenumber(email,newphone);	
		
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
		obj.updateAddress(email, newaddress);
		
		  for (Users i : usersList) {
		   if (i.getEmail().equals(email)){
			
		     this.address=i.getAddress();
		     break;
		    }
			}
		  assertEquals(newaddress,this.address); 
		
	}
}

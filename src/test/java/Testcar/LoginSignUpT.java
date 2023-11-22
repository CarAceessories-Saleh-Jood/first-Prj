package Testcar;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import usermanagement.LoginSignUp;

public class LoginSignUpT {
    LoginSignUp obj;
	
    private String email, password,phonenumber,address,user_choice;
    public LoginSignUpT() {
       this.obj=new LoginSignUp();
       
    }
	@Given("that the user is not logged in")
	public void thatTheUserIsNotLoggedIn() {
		 assertFalse(obj.getIsLogged());
	}

	@Given("the email is {string}")
	public void theEmailIs(String email) {
		this.email=email;  
	}

	@Given("the password is {string}")
	public void thePasswordIs(String password) {
		  this.password=password;
	}

	@Given("his user choice is {string}")
	public void hisUserChoiceIs(String user_choice) {
		this.user_choice=user_choice;
	}

	@Then("the user login succeeds")
	public void theUserLoginSucceeds() {
		assertTrue(obj.login(this.email,this.password,this.user_choice)); 
		}

	@Given("that the user is not signed up")
	public void thatTheUserIsNotSignedUp() {
		assertFalse(obj.getIsRegistered()); 
	}

	@Given("the email matches the email format")
	public void theEmailMatchesTheEmailFormat() {
		assertTrue(obj.emailFormat(this.email));
	}

	@Given("the phone number is {string}")
	public void thePhoneNumberIs(String phonenumber) {
		this.phonenumber=phonenumber;
	}

	@Given("the address is {string}")
	public void theAddressIs(String address) {
		this.address=address;
	}

	@Then("the user will register successfully")
	public void theUserWillRegisterSuccessfully() {
	    assertFalse(obj.signUp(this.email, this.password, this.phonenumber, this.address,this.user_choice));
		}

	@Then("the user will not be registerd")
	public void theUserWillNotBeRegisterd() {
		assertFalse(obj.getIsRegistered());
	}

	@Then("the user will not login")
	public void theUserWillNotLogin() {
		assertFalse(obj.getIsLogged());
	}
	@Then("show the message")
	public void showTheMessage() {
		obj.printInvalid(); 
	}

	@Given("that the user is logged in with email {string} and password {string} and type {string}")
	public void thatTheUserIsLoggedInWithEmailAndPassword(String email, String password,String user_choice) {
		this.email=email;
		this.password=password;
		this.user_choice=user_choice;
		obj.login(this.email,this.password,this.user_choice);
	   assertTrue(obj.getIsLogged());
	}

	@Then("the user logout successfully")
	public void theUserLogoutSuccessfully() {
		obj.logout();
	    assertFalse(obj.getIsLogged());
	}

}

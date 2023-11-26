package TestCases;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import usermanagement.Admin;
import usermanagement.Customer;
import usermanagement.Installer;
import usermanagement.LoginLogout;
import usermanagement.SignUp;
import usermanagement.Users;

public class SignupT {
	Customer customer;
	SignUp obj;
	private String email,name,password,phonenumber,address;
	private List<Users> userList;
	
	public SignupT() {
	this.customer=new Customer();	
	this.userList = customer.getList();
	this.obj=new SignUp(userList);
	}
	@Given("that the customer is not signed up")
	public void thatTheCustomerIsNotSignedUp() {
		assertFalse(obj.getIsRegistered());
	}

	@Given("the email {string}")
	public void theEmail(String email) {
	   this.email=email;
	}

	@Given("the email matches the email format")
	public void theEmailMatchesTheEmailFormat() {
		assertTrue(obj.emailFormat(this.email));
	}

	@Given("the name is {string}")
	public void theNameIs(String name) {
	   this.name=name;
	}

	@Given("the phone number is {string}")
	public void thePhoneNumberIs(String phonenumber) {
	    this.phonenumber=phonenumber;
	}

	@Given("the address is {string}")
	public void theAddressIs(String address) {
	    this.address=address;
	}

	@Then("the customer will register successfully")
	public void theCustomerWillRegisterSuccessfully() {
		assertTrue(obj.signUp(this.email,this.name, this.password, this.phonenumber, this.address));
	}

	@Then("the customer will not be registerd")
	public void theCustomerWillNotBeRegisterd() {
		assertFalse(obj.getIsRegistered());
	}

}

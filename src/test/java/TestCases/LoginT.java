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
import usermanagement.Users;

public class LoginT {
	 LoginLogout obj;
	 Admin admin;
	 Customer customer;
	 Installer installer;
	 private List<Users> userList;	
	 private String email,password;
	 public LoginT() {
		  this.obj=new LoginLogout();
		  this.admin=new Admin();  
		  this.customer=new Customer();
		  this.installer=new Installer();
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

	@Then("the admin login succeeds")
	public void theAdminLoginSucceeds() {
		this.userList = admin.getList();
		assertTrue(obj.login(email, password, userList));
	}

	@Then("the customer login succeeds")
	public void theCustomerLoginSucceeds() {
		this.userList = customer.getList();
		assertTrue(obj.login(email, password, userList));
	}

	@Then("the installer login succeeds")
	public void theInstallerLoginSucceeds() {
		this.userList = installer.getList();
		assertTrue(obj.login(email, password, userList));
	}

	@Then("the user will not login")
	public void theUserWillNotLogin() {
		assertFalse(obj.getIsLogged());
	}

	@Then("show the message")
	public void showTheMessage() {
		obj.printInvalid();
	}
}

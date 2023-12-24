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
import usermanagement.User;

public class LogoutT {
	LoginLogout obj;
	 
	 Customer customer;
	 Installer installer;
	 private List<User> userList;	
	 private String email,password;
	 public LogoutT() {
	 this.obj=new LoginLogout();
	
     this.customer=new Customer();
	 this.installer=new Installer();
    }
	@Given("that the admin is logged in with email {string} and password {string}")
	public void thatTheAdminIsLoggedInWithEmailAndPassword(String email, String password) {
	   this.email=email;
	   this.password=password;
	   this.userList=Admin.getAdminList();
	   obj.login(email, password, userList);
	   assertTrue(obj.getIsLogged());
	}

	@Then("the admin logs out successfully")
	public void theAdminLogsOutSuccessfully() {
		obj.logout();
	    assertFalse(obj.getIsLogged());
	}

	@Given("that the customer is logged in with email {string} and password {string}")
	public void thatTheCustomerIsLoggedInWithEmailAndPassword(String email, String password) {
	 this.email=email;
     this.password=password;
	 this.userList=Customer.getCustomerList();
	 obj.login(email, password, userList);
	 assertTrue(obj.getIsLogged());
	}

	@Then("the customer logs out successfully")
	public void theCustomerLogsOutSuccessfully() {
		obj.logout();
	    assertFalse(obj.getIsLogged());
	}

	@Given("that the installer is logged in with email {string} and password {string}")
	public void thatTheInstallerIsLoggedInWithEmailAndPassword(String email, String password) {
	 this.email=email;
	 this.password=password;
	 this.userList=Installer.getInstallerList();
	 obj.login(email, password, userList);
		   assertTrue(obj.getIsLogged());
	}

	@Then("the installer logs out successfully")
	public void theInstallerLogsOutSuccessfully() {
		obj.logout();
	    assertFalse(obj.getIsLogged());
	}

}

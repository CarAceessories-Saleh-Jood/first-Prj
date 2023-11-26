package TestCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import usermanagement.Customer;
import usermanagement.Installer;
import usermanagement.LoginLogout;
import usermanagement.Users;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class ManageAccountsT {
	Customer customer;
	Installer installer;
	private LoginLogout obj;
	private String email,password,name,phonenumber,address;
    private List<Users> customerList;
    private List<Users> installerList;
    
	public ManageAccountsT() {
	this.obj=new LoginLogout();	
	this.customer=new Customer();
	this.installer=new Installer();
	
	this.customerList = Customer.getList();
	this.installerList=Installer.getList();
	}
	@Given("that admin logged in")
	public void thatAdminLoggedIn() {
	   obj.setIsLogged(true);
	}

	@Given("he enters the email {string}")
	public void heEntersTheEmail(String email) {
	    this.email=email;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Then("the customer will be deleted")
	public void theCustomerWillBeDeleted() {
	   customer.deleteAccount(this.email); 
	   assertFalse(customerList.contains(email));
		 
	}

	@SuppressWarnings("unlikely-arg-type")
	@Then("the installer will be deleted")
	public void theInstallerWillBeDeleted() {
		installer.deleteAccount(this.email); 
		assertFalse(installerList.contains(email));
	}

	@Given("the password {string}")
	public void thePassword(String password) {
	 this.password=password;  
    }
	@Given("the name {string}")
	public void theName(String name) {
	    this.name=name;
	}

	@Given("the phone {string}")
	public void thePhone(String phone) {
	    this.phonenumber=phone;
	}

	@Given("the address {string}")
	public void theAddress(String address) {
	    this.address=address;
	}

	@Then("the installer will be added")
	public void theInstallerWillBeAdded() {
		int installersBeforeAdd = Installer.getList().size();
		installer.addInstaller(email, name, password, phonenumber, address);
		
	     int installersAfterAdd = Installer.getList().size();
	     assertEquals(installersBeforeAdd+ 1, installersAfterAdd );     
	
	}
}
	

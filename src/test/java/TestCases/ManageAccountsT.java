package TestCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import usermanagement.Admin;
import usermanagement.Customer;
import usermanagement.Installer;
import usermanagement.LoginLogout;
import usermanagement.User;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class ManageAccountsT {
	Customer customer;
	Installer installer;
	Admin admin;
	private LoginLogout obj;
	private String email,password,name,phonenumber,address;
    private List<User> customerList;
    private List<User> installerList;
    
	public ManageAccountsT() {
	this.obj=new LoginLogout();	
	this.customer=new Customer();
	this.installer=new Installer();
	this.admin=new Admin();
	this.customerList = Customer.getCustomerList();
	this.installerList=Installer.getInstallerList();
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

	@Then("the customer will not be found and deleted")
	public void theCustomerWillNotBeFoundAndDeleted() {
		int customersBeforeDelete = Installer.getInstallerList().size();
		 customer.deleteAccount(this.email); 
		
	    int customersAfterDelete = Installer.getInstallerList().size();
	    assertEquals(customersBeforeDelete, customersAfterDelete );    
	}

	@SuppressWarnings("unlikely-arg-type")
	@Then("the installer will be deleted")
	public void theInstallerWillBeDeleted() {
		installer.deleteAccount(this.email); 
		assertFalse(installerList.contains(email));
	}
	
	@Then("the installer will not be found and deleted")
	public void theInstallerWillNotBeFoundAndDeleted() {
		int installersBeforeDelete = Installer.getInstallerList().size();
		 installer.deleteAccount(this.email); 
		
	    int installersAfterDelete = Installer.getInstallerList().size();
	    assertEquals(installersBeforeDelete, installersAfterDelete );  
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
		int installersBeforeAdd = Installer.getInstallerList().size();
		installer.addInstaller(email, name, password, phonenumber, address);
		
	     int installersAfterAdd = Installer.getInstallerList().size();
	     assertEquals(installersBeforeAdd+ 1, installersAfterAdd );     
	
	}
	
	@Then("the installer will not be added")
	public void theInstallerWillNotBeAdded() {
		int installersBeforeAdd = Installer.getInstallerList().size();
		installer.addInstaller(email, name, password, phonenumber, address);
		
	    int installersAfterAdd = Installer.getInstallerList().size();
	    assertEquals(installersBeforeAdd, installersAfterAdd );    
	}
	
	@Given("that admin logged in and he wants to see customers information")
	public void thatAdminLoggedInAndHeWantsToSeeCustomersInformation() {
		obj.setIsLogged(true);
	}

	
	
	@Then("the customer information will be printed")
	public void theCustomerInformationWillBePrinted() {
	   assertNotNull(customerList);
	   admin.viewCustomerInfo();
	}
	
	@Given("that admin logged in and he wants to see installers information")
	public void thatAdminLoggedInAndHeWantsToSeeInstallersInformation() {
		obj.setIsLogged(true);
	}

	@Then("the installer information will be printed")
	public void theInstallerInformationWillBePrinted() {
		 assertNotNull(installerList);
		 admin.viewInstallerInfo();
	}

	@Given("that admin logged in and he wants to see the booked appointments")
	public void thatAdminLoggedInAndHeWantsToSeeTheBookedAppointments() {
		obj.setIsLogged(true);
	}

	@Then("the booked appointments will be printed")
	public void theBookedAppointmentsWillBePrinted() {
		 assertNotNull(Customer.getBookingList());
		 admin.printAppointments();
	}	
	
}
	

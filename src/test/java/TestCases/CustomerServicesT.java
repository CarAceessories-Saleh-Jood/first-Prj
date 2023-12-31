package TestCases;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import productmanagement.*;
import usermanagement.*;
import requestsmanagement.*;
public class CustomerServicesT {
	LoginLogout log;
	ProductsManager product;
	Customer customer;
	Appointment appointment;
	
	private String productName,email1,searchword,name,phonenumber,carbrand,carmodel,reason;
	private double cost,minprice,maxprice;
	private int quantity;
	
	public CustomerServicesT(){
	this.log=new LoginLogout();	
	this.product=new ProductsManager();	
	this.customer=new Customer();	
	this.appointment=new Appointment();
		
	}
	@Given("that customer is logged in with email {string}")
	public void thatCustomerIsLoggedInWithEmail(String email) {
		   log.setIsLogged(true);
		   this.email1=email;
	}

	@Given("he wants to buy a product with product name {string} and cost {double}")
	public void heWantsToBuyAProductWithProductNameAndCost(String productName, Double cost) {
	    this.productName=productName;
	    this.cost=cost;
	    
	}

	@Given("the he chooses the quantity {int}")
	public void theHeChoosesTheQuantity(Integer quantity) {
		   this.quantity=quantity;
	}
	@Then("the the product will be added to the cart")
	public void theTheProductWillBeAddedToTheCart() {
		product.getProduct(productName);
		customer.addToCart(productName, cost, quantity);
	}


	@Then("when he confirms to buy")
	public void whenHeConfirmsToBuy() {
		customer.confirmOrder(email1);
	}

	@Then("a confirmation email will be sent successfully")
	public void aConfirmationEmailWillBeSentSuccessfully() {
		customer.sendOrderConfirmationEmail(email1);
	}

	@Given("he enters {string} to search for a product")
	public void heEntersToSearchForAProduct(String searchword) {
	    this.searchword=searchword;
	}

	@Then("the products of this word will be found")
	public void theProductWillBeFoundAndPrinted() {
	     assertTrue(customer.searchProducts(searchword));
	}


	@Then("the products of this word will not be found")
	public void theProductsOfThisWordWillNotBeFound() {
		 assertFalse(customer.searchProducts(searchword));
		}

	@Given("he enters {double} and {double} to search for a product")
	public void heEntersAndToSearchForAProduct(Double minprice, Double maxprice) {
		   this.minprice=minprice;
		   this.maxprice=maxprice;
	}

	@Then("the products of this price will be found")
	public void theProductWillBeFound() {
		   assertTrue(customer.searchProductsByPriceRange(minprice, maxprice));
		}


	@Then("the products of this price will not be found")
	public void theProductsOfThisPriceWillNotBeFound() {
		assertFalse(customer.searchProductsByPriceRange(minprice, maxprice));
	}

	@Given("that customer is logged in with email {string} and he wants to see the order history")
	public void thatCustomerIsLoggedInWithEmailAndHeWantsToSeeTheOrderHistory(String email) {
	   this.email1=email;
	}

	@Then("his order history will be printed")
	public void hisOrderHistoryWillBePrinted() {
	   assertTrue(customer.viewOrderHistory(email1));
	}
	
	@Then("his order history will not found or printed")
	public void hisOrderHistoryWillNotFoundOrPrinted() {
		assertFalse(customer.viewOrderHistory(email1));
	}


	@Given("that customer is logged in with email {string} and he wants to request an installation service")
	public void thatCustomerIsLoggedInWithEmailAndHeWantsToRequestAnInstallationService(String email) {
	   this.email1=email;
	}

	@Given("he enters the name {string}")
	public void heEntersTheName(String name) {
	   this.name=name;
	}

	@Given("the phone number {string}")
	public void thePhoneNumber(String phonenumber) {
		 this.phonenumber=phonenumber;
		}

	@Given("the car brand {string}")
	public void theCarBrand(String carbrand) {
		  this.carbrand=carbrand;
		}

	@Given("the car model {string}")
	public void theCarModel( String carmodel) {
		   this.carmodel=carmodel;
		}

	@Given("the reason {string}")
	public void theReason(String reason) {
		   this.reason=reason;
		}

	@Given("he chooses the appointment number {int} with the installer {string}")
	public void heChoosesTheAppointmentNumberWithTheInstaller(int number, String email2) {
	 customer.printAvailableAppointemnts();
	  this.appointment=Customer.getAppointment(number);
	  
	  
	}

	@Then("installation request will be sent")
	public void installationRequestWillBeSent() {
		  customer.requestInstallation(appointment, email1, name, phonenumber, reason, carbrand, carmodel);
		  customer.sendInstallationRequestEmail(email1);
		}

	@Given("that customer is logged in with email {string} and he wants to see the installation requests history")
	public void thatCustomerIsLoggedInWithEmailAndHeWantsToSeeTheInstallationRequestsHistory(String email) {
		  this.email1=email;
		  
	}

	@Then("his installation requests history will be printed")
	public void hisInstallationRequestsHistoryWillBePrinted() {
		assertTrue(customer.viewInstallationRequests(email1));
	}
	
	@Then("the installation request history will not be found or printed")
	public void theInstallationRequestHistoryWillNotBeFoundOrPrinted() {
		assertFalse(customer.viewInstallationRequests(email1));
	}

}

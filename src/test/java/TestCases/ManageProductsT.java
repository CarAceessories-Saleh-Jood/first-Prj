package TestCases;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import productmanagement.Product;
import productmanagement.ProductsManager;
import usermanagement.LoginLogout;

public class ManageProductsT {
	private LoginLogout obj;
	private ProductsManager obj1;
	private String productName,productDescription,categoryName,newName,newDescription,newCategory;
	private double cost,newCost,delta=0.0001;
	private int quantity,newQuantity;
	
	private ArrayList<Product> productList;
	
	public ManageProductsT() {
	this.obj=new LoginLogout();
	this.obj1=new ProductsManager();
	productList=obj1.getProductList();
	
	}
	@Given("that admin is logged in")
	public void thatAdminIsLoggedIn() {
    obj.setIsLogged(true);
	}

	@Given("the product name is  {string}")
	public void theProductNameIs(String productName) {
	this.productName=productName;
	}

	@Given("product description is {string}")
	public void productDescriptionIs(String productDescription) {
    this.productDescription=productDescription;
	}

	@Given("the product does not exsist before")
	public void theProductDoesNotExsistBefore() {
	assertTrue(obj1.checkexsist(this.productName));  
	}

	@Given("product cost is {double}")
	public void productCostIs(Double cost) {
	this.cost=cost;
	}

	@Given("product cost is valid")
	public void productCostIsValid() {
	assertTrue(obj1.checkCost(cost));
	}

	@Given("product quantity is {int}")
	public void productQuantityIs(Integer quantity) {
	this.quantity=quantity;
	}

	@Given("category name is {string}")
	public void categoryNameIs(String categoryName) {
	this.categoryName=categoryName;
	}

	@Then("the product is added to the list")
	public void theProductIsAddedToTheList() {
		int productsBeforeAdd = obj1.getProductList().size();
		obj1.addProduct(productName, productDescription, cost, quantity, categoryName);
		
	     int productsAfterAdd = obj1.getProductList().size();
	     assertEquals(productsBeforeAdd+ 1, productsAfterAdd );   
	     
	}

	@Given("the new name is {string}")
	public void theNewNameIs(String newName) {
	    this.newName=newName;
	}

	@Then("the product name is updated")
	public void theProductNameIsUpdated() {
		obj1.updateProductName(productName, newName);
		
		
		  for (Product i : productList) {
		   if (i.getName().equalsIgnoreCase(newName)){
			 
			 this.productName=i.getName();
		     break;
		    }
			}
		  assertEquals(this.newName,this.productName); 
		  
    }  

	@Given("the new description is {string}")
	public void theNewDescriptionIs(String newDescription) {
		 this.newDescription= newDescription;
	}

	@Then("the product description is updated")
	public void theProductDescriptionIsUpdated() {
		obj1.updateProductDescription(productName, newDescription);
		
		  for (Product i : productList) {
		   if (i.getName().equalsIgnoreCase(productName)){
			
			 this.productDescription=i.getDescription();
		     break;
		    }
			}
		  assertEquals(newDescription,this.productDescription); 
     }  

	@Given("the new cost is {double}")
	public void theNewCostIs(Double newCost) {
	this.newCost=newCost;
	}

	@Then("the product cost is updated")
	public void theProductCostIsUpdated() {
		obj1.updateProductCost(productName, newCost);
		
		  for (Product i : productList) {
		   if (i.getName().equalsIgnoreCase(productName)){
			
			 this.cost=i.getCost();
		     break;
		    }
			}
		  assertEquals(newCost,this.cost,this.delta); 
	}

	@Given("the new quantity is {int}")
	public void theNewQuantityIs(Integer newQuantity) {
	this.newQuantity=newQuantity;
	}

	@Then("the product quantity is updated")
	public void theProductQuantityIsUpdated() {
		obj1.updateProductQuantity(productName, newQuantity);
		
		  for (Product i : productList) {
		   if (i.getName().equalsIgnoreCase(productName)){
			this.quantity=i.getQuantity();
		     break;
		    }
			}
		
		  assertEquals(newQuantity,this.quantity);    
	}

	@Given("the new category is {string}")
	public void theNewCategoryIs(String newCategory) {
	this.categoryName=newCategory;
	}

	@Then("the product category is updated")
	public void theProductCategoryIsUpdated() {
		obj1.updateProductCategory(productName, newCategory);
		
		  for (Product i : productList) {
		   if (i.getName().equalsIgnoreCase(productName)){
			
			 this.categoryName=i.getCategory();
		     break;
		    }
		}
	 assertEquals( newCategory,this.categoryName);     
	}

	@SuppressWarnings("unlikely-arg-type")
	@Then("the product will be deleted")
	public void theProductWillBeDeleted() {
		obj1.deleteProduct(productName);
		assertFalse(productList.contains(productName));
	}
}

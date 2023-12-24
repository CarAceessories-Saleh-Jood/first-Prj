package TestCases;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import productmanagement.CategoriesManager;
import productmanagement.Category;
import productmanagement.ProductsManager;
import usermanagement.LoginLogout;
import productmanagement.Product;

public class ManageCategoriesT {
	private String categoryName,categoryDescription,newName,newDescription;
	private CategoriesManager obj;
	private ProductsManager obj1;
	private LoginLogout log;
	private List<Category> categoryList;
	private List<Product> productList;
	
	public ManageCategoriesT() {
		this.obj=new CategoriesManager();
		this.obj1=new ProductsManager();
		this.log=new LoginLogout();
		categoryList=obj.getCategoriesList();
		productList=obj1.getProductList();
	}
	
	@Given("admin enters category name  {string}")
	public void adminEntersCategoryName(String name) {
	this.categoryName=name;
	}

	@Given("category description  {string}")
	public void categoryDescription(String description) {
	this.categoryDescription=description;
	}

	@Then("the category is added to the list")
	public void theCategoryIsAddedToTheList() {
		int categoriesBefore = obj.getCategoriesList().size();
		obj.addCategory(categoryName, categoryDescription);
		
	     int categoriesAfterAdd = obj.getCategoriesList().size();
	     assertEquals(categoriesBefore+ 1, categoriesAfterAdd ); 
	}

	@Given("the admins enters a new name {string}")
	public void theAdminsEntersANewName(String newname) {
	this.newName=newname;
	}

	@Given("a new description {string}")
	public void aNewDescription(String newdescription) {
	this.newDescription=newdescription;
	}

	@Then("the category is edited")
	public void theCategoryIsEdited() {
		obj.editCategory(categoryName, newName, newDescription);
		
		  for (Category i : categoryList) {
		   if (i.getName().equals(newName)){
			
		     this.categoryName=i.getName();
		     this.categoryDescription=i.getDescription();
		     break;
		    }
			}
		  assertEquals(newName,this.categoryName);
		  assertEquals(newDescription,this.categoryDescription);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Then("the category and its products will be deleted from lists")
	public void theCategoryAndItsProductsWillBeDeletedFromLists() {
		
		 obj.deleteCategory(categoryName);   
		 assertFalse(categoryList.contains(categoryName));
		 assertFalse(productList.contains(categoryName));
		}
	
	@Given("that the admin is logged in and he wants to see the categories")
	public void thatTheAdminIsLoggedInAndHeWantsToSeeTheCategories() {
	 this.log.setIsLogged(true);
	}

	@Then("the categories will be printed")
	public void theCategoriesWillBePrinted() {
		 assertNotNull(categoryList);
		 obj.listCategories();
	}

}

package productmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.Iterator;

import userinterface.PrintUtils;


public class CategoriesManager {
	
 private static ArrayList<Category> categoryList= new ArrayList<>();	

 static {
	   Category cat1=new Category("Interior", "Category for interior products");
	   Category cat2=new Category("Lightings", "Category for lightings products");
	   Category cat3=new Category("Audio", "Category for audio products");
	   Category cat4=new Category("Electronics", "Category for electronics products");
	   Category cat5=new Category("Body parts", "Category for electronics products");
	   
	    categoryList.add(cat1);
	    categoryList.add(cat2);
	    categoryList.add(cat3);
	    categoryList.add(cat5);
	    
 }
	
 public CategoriesManager() {}
 
 public  ArrayList<Category> getCategoriesList() {
     return categoryList;
 }

	 public  void addCategory(String name, String description) {
	        Category newCategory = new Category(name, description);
	        categoryList.add(newCategory);
	        PrintUtils.println("Category added successfully.");
	}

	public void editCategory(String name, String newName, String newDescription) {
	for (Category category : categoryList) {
	 if (category.getName().equalsIgnoreCase(name)) {
	     category.setName(newName);
	     category.setDescription(newDescription);
	      PrintUtils.println("Category updated successfully.");
	        return;
	            }
	        }
	        PrintUtils.println("Category not found.");
	 }

	
	 public void deleteCategory(String name) {
       ProductsManager product=new ProductsManager();
	   ArrayList<Product> prodList = product.getProductList();
	   boolean found=false;
	   
	   
	   Iterator<Category> categoryIterator = categoryList.iterator();
	    while (categoryIterator.hasNext()) {
	        Category category = categoryIterator.next();
	        if (category.getName().equalsIgnoreCase(name)) {
	           categoryIterator.remove();  // Use iterator's remove method to avoid ConcurrentModificationException
	            PrintUtils.println("Category deleted successfully.");
	            found = true;
	            break;
	        }
	    }
	
	   List<Product> productsToRemove = new ArrayList<>();
	   for (Product prod : prodList) {
	        if (prod.getCategory().equalsIgnoreCase(name)) {
	        	
	            productsToRemove.add(prod);
	        }
	    }
	   prodList.removeAll(productsToRemove);
     if(!found) {
    	 PrintUtils.println("Category not found"); 
     }
	  
}

	 
	    public void listCategories() {
	        PrintUtils.println("Product Categories:");
	        for (Category category : categoryList) {
	            PrintUtils.println("Name: " + category.getName());
	            PrintUtils.println("Description: " + category.getDescription());
	            PrintUtils.println();
	        }
	    }
	   
}
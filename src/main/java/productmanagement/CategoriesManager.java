package productmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import userinterface.PrintUtils;


public class CategoriesManager {
	
 private static ArrayList<Category> categoryList= new ArrayList<>();	

 static {
	  
        categoryList.add(new Category("Interior", "Decor and functional items for spaces."));
	    categoryList.add(new Category("Lightings", "Various lighting solutions."));
	    categoryList.add(new Category("Audio", "Sound products and accessories."));
	    categoryList.add(new Category("Electronics", " Diverse electronic devices."));
	    categoryList.add(new Category("Body parts", "External vehicle components."));
	    categoryList.add(new Category("Brakes", "Products for vehicle braking."));
	    categoryList.add(new Category("Automative Tools", "Tools for automotive tasks."));
 }

 /**
  * Default constructor for CategoriesManager.
  * This constructor is intentionally left empty.
  */
 public CategoriesManager() {
	
	 //TOOO
	 
	 }
 
 
 public List<Category> getCategoriesList() {
     return categoryList;
 }

	 public void addCategory(String name, String description) {
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
	   List<Product> prodList = product.getProductList();
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
	    	 PrintUtils.println("-----------------------------------------------------");
	    	    PrintUtils.println("\u001B[34mProduct Categories:\u001B[0m");  // Blue color

	    	    for (Category category : categoryList) {
	    	        String nameAndDescription = "\u001B[32mName:\u001B[0m " + category.getName() +   // Green color
	    	                                    " | \u001B[31mDescription:\u001B[0m " + category.getDescription();  // Red color
	    	        PrintUtils.println(nameAndDescription);
	    	        PrintUtils.println();
	    	    }
	    	 PrintUtils.println("-----------------------------------------------------");	    
	    }
	   
}
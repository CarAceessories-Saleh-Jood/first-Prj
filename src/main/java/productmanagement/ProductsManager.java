package productmanagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import userinterface.PrintUtils;

public class ProductsManager {

	private static ArrayList<Product> productList = new ArrayList<>();
    private boolean exsist=true;
    private boolean added=false;
	
    static {
	  	
    	Product prod1 = new Product("Head lights","High-quality headlights designed to provide optimal illumination for your vehicle. ",300,20,"Lightings");
    	Product prod2 = new Product("Speaker","Engineered with precision, this speaker is designed to seamlessly integrate into various car models, ensuring a versatile enhancement to your in-car audio.",70,10,"Audio");
    	Product prod3 = new Product("Battery", " A high-performance car battery designed to provide reliable  and efficient power to your vehicle's electrical system.",450,0,"Electronics");
    	Product prod4 = new Product("Tail lights","High-quality  ",30,20,"Lightings");
    	productList.add(prod1);
        productList.add(prod2);
    	productList.add(prod3);
    	productList.add(prod4);
    	
    }
    
    
    public ArrayList<Product> getProductList(){
        return productList;
    }
     
    public boolean getExsist(){
    	return this.exsist;
    }
    
    public boolean getAdded() {
        return added;
    }
    public void addProduct(String name,String description, double cost,int quantity, String selectedCategory) {
    	Product product =new Product(name,description, cost, quantity, selectedCategory);	
        if(productList.add(product)) {
        	this.added=true;
        }
        
    }
    
    public boolean checkexsist(String name) {
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                return false;
            }
        }
        return true;
    }

    
    
    public boolean checkCost(double Cost) {
    	return Cost>=1;
    }
    
    public void listProducts() {
    	 PrintUtils.println("-----------------------------------------------------");
    	for (Product product : productList) {
    		 PrintUtils.println("Product Category: " + product.getCategory());
    		 PrintUtils.println("Product Name: " + product.getName());
    		 PrintUtils.println("Product Description: " + product.getDescription());
    		 PrintUtils.println("Product Cost: " + product.getCost());
    		 PrintUtils.println("Product Quantity: " + product.getQuantity());
    		 PrintUtils.println("Product Availability: " + (product.isAvailable()?"in stock":"out of stock"));
            System.out.println();
        }
    	 PrintUtils.println("-----------------------------------------------------");
    }
	 
  public void updateProductName(String productName, String newProductName) {
	   for (Product i : productList) {
           if (i.getName().equalsIgnoreCase(productName)) {
        	i.setName(newProductName);
              
            PrintUtils.println("Product Name Updated successfully");
            return;
           }
       }
       PrintUtils.println("Wrong input");
       
   }
  
  public void updateProductDescription(String productName, String newDescription) {
	   for (Product i : productList) {
           if (i.getName().equalsIgnoreCase(productName)) {
        	i.setDescription(newDescription);
              
            PrintUtils.println("Product Description Updated successfully");
            return;
           }
       }
       PrintUtils.println("Wrong input");
       
   }
   public void updateProductCost(String productName, double newCost) {
	   for (Product i : productList) {
           if (i.getName().equalsIgnoreCase(productName)) {
        	i.setCost(newCost);
              
            PrintUtils.println("Product Cost Updated successfully");
            return;
           }
       }
       PrintUtils.println("Wrong input");
       
   }
  public void updateProductQuantity(String productName, int newQuantity) {
	   for (Product i : productList) {
           if (i.getName().equals(productName)) {
        	i.setQuantity(newQuantity);
              
            PrintUtils.println("Product quantity Updated successfully");
            return;
           }
       }
       PrintUtils.println("Wrong input");
       
   }  
  
  public void updateProductCategory(String productName, String newCategory) {
	   for (Product i : productList) {
          if (i.getName().equalsIgnoreCase(productName)) {
       	   i.setCategory(newCategory);
             
           PrintUtils.println("Product category Updated successfully");
           return;
          }
      }
      PrintUtils.println("Wrong input");
      
  }
  
  public void deleteProduct(String name) {
	  boolean found=false;
	   Iterator<Product> productIterator = productList.iterator();
	    while (productIterator.hasNext()) {
	        Product prod = productIterator.next();
	        if (prod.getName().equalsIgnoreCase(name)) {
	        	productIterator.remove();  // Use iterator's remove method to avoid ConcurrentModificationException
	            PrintUtils.println("Product deleted successfully.");
	            found = true;
	            return;
	        }
	    }
	     if(!found) {
	    	 PrintUtils.println("Product cannot be found"); 
	     }
     }
  
}

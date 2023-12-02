package productmanagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import userinterface.PrintUtils;

public class ProductsManager {

	private static ArrayList<Product> productList = new ArrayList<>();
	private static final String WRONG_INPUT="Wrong input";
    private boolean exsist=true;
    private boolean added=false;
	
    static {
	  	
    	productList.add(new Product("Head lights","High-quality headlights designed to provide optimal illumination for your vehicle. ",300,20,"Lightings"));
        productList.add(new Product("Speaker","Engineered with precision, this speaker is designed to seamlessly integrate into various car models, ensuring a versatile enhancement to your in-car audio.",70,10,"Audio"));
    	productList.add(new Product("Battery", "A high-performance car battery designed to provide reliable  and efficient power to your vehicle's electrical system.",450,0,"Electronics"));
    	productList.add(new Product("Tail lights","High-quality tail lights to enhance visibility and safety for your vehicle. ",150,20,"Lightings"));
    	productList.add(new Product("Floor Mats","Premium floor mats for added comfort and protection, elevating the interior aesthetics of your space.",299.9,20,"Interior"));
    	productList.add(new Product("Front Brake Kit","Upgrade your vehicle's braking efficiency with this quality front brake kit, ensuring a safer driving experience.",124.35,50,"Brakes"));
    	productList.add(new Product("Touchscreen Display","Elevate your vehicle's interior with a high-quality touchscreen display for a modern audiovisual experience.",499.99,100,"Audio"));
    	productList.add(new Product("Pneumatic Fluid Evacuator","Efficient pneumatic fluid evacuator, designed for quick and hassle-free automotive maintenance.",204.74,5,"Automative Tools"));
    	productList.add(new Product("Pedal pad set","High-quality pedal pad set, enhancing both the driving experience and aesthetic appeal.",94.05,80,"Interior"));
    	
    }
    
    
    public List<Product> getProductList(){
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
    	
        for (Product i : productList) {
       if (i.getName().equalsIgnoreCase(name)) {
       	
    	  return false;
       }
       
       }
        return true;
    }
    
    
    public boolean checkCost(double Cost) {
    	return Cost>=1;
    }
    
    public void listProducts() {
    	String url="http://127.0.0.1:5500/ph.html";
    	 PrintUtils.println("-----------------------------------------------------");
    	for (Product product : productList) {
    		PrintUtils.println("Product Name: " + product.getName());
            PrintUtils.println("Product Description: " + product.getDescription());
            PrintUtils.println("Product Cost: " + product.getCost()+"$");
            PrintUtils.println("Product Quantity: " + product.getQuantity());
            PrintUtils.println("Product Availability: " +(product.isAvailable()?"In stock":"Out of stock"));
            PrintUtils.println("Product Category: " + product.getCategory());
            PrintUtils.println();
        }
    	
    	 PrintUtils.println("Copy this url and paste in your browser to see the products: "+ url);
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
       PrintUtils.println(WRONG_INPUT);
       
   }
  
  public void updateProductDescription(String productName, String newDescription) {
	   for (Product i : productList) {
           if (i.getName().equalsIgnoreCase(productName)) {
        	i.setDescription(newDescription);
              
            PrintUtils.println("Product Description Updated successfully");
            return;
           }
       }
       PrintUtils.println(WRONG_INPUT);
       
   }
   public void updateProductCost(String productName, double newCost) {
	   for (Product i : productList) {
           if (i.getName().equalsIgnoreCase(productName)) {
        	i.setCost(newCost);
              
            PrintUtils.println("Product Cost Updated successfully");
            return;
           }
       }
       PrintUtils.println(WRONG_INPUT);
       
   }
  public void updateProductQuantity(String productName, int newQuantity) {
	   for (Product i : productList) {
           if (i.getName().equalsIgnoreCase(productName)) {
        	
        	i.setQuantity(newQuantity);
              
            PrintUtils.println("Product quantity Updated successfully");
            return;
           }
       }
       PrintUtils.println(WRONG_INPUT);
       
   }  
  
  public void updateProductCategory(String productName, String newCategory) {
	   for (Product i : productList) {
          if (i.getName().equalsIgnoreCase(productName)) {
       	   i.setCategory(newCategory);
             
           PrintUtils.println("Product category Updated successfully");
           return;
          }
      }
      PrintUtils.println(WRONG_INPUT);
      
  }
  
  public void deleteProduct(String name) {
	
	   Iterator<Product> productIterator = productList.iterator();
	    while (productIterator.hasNext()) {
	        Product prod = productIterator.next();
	        if (prod.getName().equalsIgnoreCase(name)) {
	        	productIterator.remove();  
	            PrintUtils.println("Product deleted successfully.");
	            
	            return;
	        }
	    }
	    
	    	 PrintUtils.println("Product cannot be found"); 
	    
     }
  
  public Product getProduct(String productName) {
	  for (Product product : productList) {
          if (product.getName().equalsIgnoreCase(productName)) {
              return product;
          }
      }
      return null; // Product not found  
  }
}

package productmanagement;

import java.util.ArrayList;
import java.util.List;

import usermanagement.Users;

public class Product{

    private String name;
    private double cost;
    private int quantity;
    private String category;
    private String description;
    
    
    public Product(String name,String description, double cost, int quantity, String category) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
    }
    
    public Product() {
    	
    }
    
	

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public boolean isAvailable() {
        return quantity > 0;
    }

 

    public String getCategory() {
        return category;
    }
    
    public String getDescription() {
    	return this.description;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
  
    
    
    
    
}
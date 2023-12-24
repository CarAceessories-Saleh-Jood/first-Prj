package requestsmanagement;

public class Order {
	
	
private String productName;
private int quantity;
private double cost;
private double subtotal;

public Order(String productName,double cost,int quantity,double subtotal) {
	
	this.productName=productName;
	this.cost=cost;
	this.quantity=quantity;
	this.subtotal=subtotal;
}

public String getProductName() {
	return productName;
}

public int getQuantity() {
	return quantity;
}

public double getCost() {
	return cost;
}

public double getSubtotal() {
	return subtotal;
}





}

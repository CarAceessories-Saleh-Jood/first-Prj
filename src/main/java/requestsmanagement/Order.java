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

public void setProductName(String productName) {
	this.productName = productName;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public double getCost() {
	return cost;
}

public void setCost(double cost) {
	this.cost = cost;
}

public double getSubtotal() {
	return subtotal;
}

public void setSubtotal(double subtotal) {
	this.subtotal = subtotal;
}




}

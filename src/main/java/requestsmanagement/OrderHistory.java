package requestsmanagement;

import java.util.List;

import usermanagement.Users;

public class OrderHistory {

private static  List<Order> orderList;
private String customerEmail;
private double total;

public OrderHistory(List<Order> customerCart,String customerEmail,double total){
setOrderList(customerCart);
this.setCustomerEmail(customerEmail);
this.setTotal(total);
}

public double getTotal() {
	return total;
}

public void setTotal(double total) {
	this.total = total;
}

public String getCustomerEmail() {
	return customerEmail;
}

public void setCustomerEmail(String customerEmail) {
	this.customerEmail = customerEmail;
}

public static List<Order> getOrderList() {
	return orderList;
}

public static void setOrderList(List<Order> orderList) {
	OrderHistory.orderList = orderList;
}








}

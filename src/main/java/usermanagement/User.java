package usermanagement;

public class User{
	 private String email;
	 private String name;
	 private String password;
	 private String phonenumber;
	 private String address;
	
	 public User() {
		 
	 }
       public User(String email,String name, String password, String phonenumber,String address) {
       this.email = email;
       this.name=name;
       this.password = password;
       this.phonenumber=phonenumber;
       this.address=address;
     
       }
       
       public String getEmail() {
           return this.email;
       }

       public String getPassword() {
           return this.password;
       }
       public String getPhoneNumber() {
           return this.phonenumber;
       }
       public String getAddress() {
           return this.address;
       }
       public String getName() {
           return this.name;
       }
     
       public void setUsername(String name) {
           this.name = name;
       }
       public void setPassword(String password) {
           this.password = password;
       }
       
       public void setPhoneNumber(String phonenumber) {
           this.phonenumber = phonenumber;
       }
       
       public void setAddress(String address) {
           this.address = address;
       }
      
}

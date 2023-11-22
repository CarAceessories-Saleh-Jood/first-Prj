package usermanagement;

public class Users {

	 private String email;
	 private String password;
	 private String phonenumber;
	 private String address;
	 private String type;
	  
	 
	      public Users() {
	    	  
	      }
           	 
	       public  Users (String email, String password, String phonenumber,String address,String type) {
	        this.email = email;
	        this.password = password;
	        this.phonenumber=phonenumber;
	        this.address=address;
	        this.type=type;
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
	        public String gettype() {
	            return this.type;
	        }
	      

	        public void setUsername(String email) {
	            this.email = email;
	        }

	        public void setPassword(String password) {
	            this.password = password;
	        }
	        
	        public void setPhoneNumber(String phonenumber) {
	            this.phonenumber = phonenumber;
	        }
	        
	        public void setSAddress(String address) {
	            this.address = address;
	        }
	        public void setType(String type) {
	            this.type = type;
	        }
}

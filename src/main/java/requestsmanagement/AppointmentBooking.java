package requestsmanagement;


public class AppointmentBooking{
	    private Appointment appointment;
	    
	    private String customerName;
	    private String phoneNumber;
	    private String customerEmail;
        private String carBrand;
	    private String carModel;
	    private String reason;

	    public AppointmentBooking(Appointment  selectedAppointment,String customerEmail,String customerName, String phoneNumber, String reason, String carBrand, String carModel){
	    	this.setAppointment(selectedAppointment);
	        this.customerName = customerName;
	        this.customerEmail=customerEmail;
	        this.phoneNumber = phoneNumber;
	        this.reason = reason;
	        this.carBrand=carBrand;
	        this.carModel=carModel;
	       }

	    @Override
	    public String toString() {
	        return "Appointment Booking - " + ", Customer: " + customerName +
	                ", Phone Number: " + phoneNumber + ", Reason: " + reason +
	                ", Car Brand: " + carBrand+", Car Model: "+carModel ;
	    }
	    
	    public String getName() {
	    	return customerName;
	    }
	    
	    public String getPhone() {
	    	return phoneNumber;
	    }
	    public String getReason() {
	    	return reason;
	    }
	    public String getCarBrand() {
	    	return carBrand;
	    }
	    public String getCarModel() {
	    	return carModel;
	    }

		public String getCustomerEmail() {
			return customerEmail;
		}

		public Appointment getAppointment() {
			return appointment;
		}

		public void setAppointment(Appointment appointment) {
			this.appointment = appointment;
		}
	    
	}


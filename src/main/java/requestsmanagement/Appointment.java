package requestsmanagement;

public class Appointment {
	private static int nextAppointmentNumber = 1;
    private int appointmentNumber;
    private String date;
    private String day;
    private String hour;
    private String installerEmail;
    private String installerName;
    private boolean booked;
    
    public Appointment() {
    	
    }
    
    public Appointment(String date, String day, String hour,String installerEmail,String installerName) {
        this.appointmentNumber = nextAppointmentNumber++;
        this.date = date;
        this.day = day;
        this.hour = hour;
        this.booked = false;
        this.installerEmail=installerEmail;
        this.installerName=installerName;
    }
     
    public int getAppointmentNumber() {
        return appointmentNumber;
    }
    public String getDate() {
        return date;
    }
    
    public String getDay() {
        return day;
    }
    public String getHour() {
        return hour;
    }
    public String getName() {
        return installerName;
    }
    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
    
    public  String getAvailability() {
    	return isBooked()?"Booked":"Available";
    }
    public  String getEmail() {
    	return installerEmail;
    }
    
    @Override
    public String toString() {
        return "Appointment " + appointmentNumber + ": Date - " + date + ", Day - " + day + ", Time - " + hour+" ,Installer Name - "+installerName+",  Availability: "+ getAvailability();
    }
}

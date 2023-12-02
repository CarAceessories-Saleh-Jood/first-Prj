package TestCases;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import requestsmanagement.Appointment;
import usermanagement.Installer;
import usermanagement.LoginLogout;
public class InstallerTasks {
	
	private String email,name,date,day,hour;
	private int number;
	LoginLogout log;
	Appointment app;
	Installer installer;
	public InstallerTasks() {
		this.log=new LoginLogout();		
	}
	
	@Given("that installer is logged in with email {string} and he wants to add a free appointment")
	public void thatInstallerIsLoggedInWithEmailAndHeWantsToAddAFreeAppointment(String email) {
		
	  this.email=email;
	  log.setIsLogged(true);
	}

	@Given("he enters appointment date {string} and appointment day {string} and appointment hour {string} and his name {string}")
	public void heEntersAppointmentDateAndAppointmentDayAndAppointmentHourAndHisName(String date, String day, String hour, String name) {
	   this.date=date;
	   this.day=day;
	   this.hour=hour;
	   this.name=name;
	}

	@Then("the appointment will be added successfully")
	public void theAppointmentWillBeAddedSuccessfully() {
	 
	   int apointmentsBeforeAdd = Installer.getAppointmentList().size();
	   Installer.addAppointemnt(date, day, hour, email, name);
		
	     int apointmentsAfterAdd = Installer.getAppointmentList().size();
	     assertEquals(apointmentsBeforeAdd+ 1, apointmentsAfterAdd );   
	}

	@Given("that installer is logged in with email {string} and he wants to see his appointments")
	public void thatInstallerIsLoggedInWithEmailAndHeWantsToSeeHisAppointments(String email) {
	   this.email=email;
	}

	@Then("the appointments will found and printed")
	public void theAppointmentsWillFoundAndPrinted() {
	    assertTrue(Installer.viewAppointments(email));
	}

	@Given("that installer is logged in with email {string} and he wants to see the booked appointments")
	public void thatInstallerIsLoggedInWithEmailAndHeWantsToSeeTheBookedAppointments(String email) {
	    this.email=email;
	}

	@Then("the booked appointments will found and printed")
	public void theBookedAppointmentsWillFoundAndPrinted() {
		 assertTrue(Installer.viewAppointmentBookings(email)); 
	}

	@Given("that installer is logged in with email {string} and he wants to delete the appointment that has the number {int}")
	public void thatInstallerIsLoggedInWithEmailAndHeWantsToDeleteTheAppointmentThatHasTheNumber(String email, Integer number) {
	   this.email=email;
	   this.number=number;
	}

	@Then("the appointment will be deleted")
	public void theAppointmentWillBeDeleted() {
		Installer.deleteAppointmentByNumber(number);
		assertFalse(Installer.getAppointmentList().contains(number));
	}

}

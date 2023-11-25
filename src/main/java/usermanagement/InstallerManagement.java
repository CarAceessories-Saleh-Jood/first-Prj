package usermanagement;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.Scanner;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import userinterface.PrintUtils;


public class InstallerManagement {
    private ArrayList<Appointment> appointments;
    private ArrayList<AppointmentBooking> appointmentBookings;

    private static class AppointmentBooking {
        private String customerName;
        private String phoneNumber;
        private String reason;
        private String installerEmail;
        private Appointment appointment;

        public AppointmentBooking(String customerName, String phoneNumber, String reason, String installerEmail, Appointment appointment) {
            this.customerName = customerName;
            this.phoneNumber = phoneNumber;
            this.reason = reason;
            this.installerEmail = installerEmail;
            this.appointment = appointment;
        }

        @Override
        public String toString() {
            return "Appointment Booking - " + appointment + ", Customer: " + customerName +
                    ", Phone Number: " + phoneNumber + ", Reason: " + reason +
                    ", Installer Email: " + installerEmail;
        }
    }

    private static class Appointment {
        private static int nextAppointmentNumber = 1;

        private int appointmentNumber;
        private String date;
        private String day;
        private String hour;
        private boolean booked;

        public Appointment(String date, String day, String hour) {
            this.appointmentNumber = nextAppointmentNumber++;
            this.date = date;
            this.day = day;
            this.hour = hour;
            this.booked = false;
        }

        public int getAppointmentNumber() {
            return appointmentNumber;
        }

        public boolean isBooked() {
            return booked;
        }

        public void setBooked(boolean booked) {
            this.booked = booked;
        }

        @Override
        public String toString() {
            return "Appointment " + appointmentNumber + ": Date - " + date + ", Day - " + day + ", Time - " + hour;
        }
    }

    public InstallerManagement() {
        this.appointments = new ArrayList<>();
        this.appointmentBookings = new ArrayList<>();
        appointments.add(new Appointment("2023-11-25", "Thursday", "10:30 AM"));
        appointments.add(new Appointment("2023-11-26", "Friday", "02:00 PM"));
    }

    public void addNewAppointment(String date, String day, String hour) {
        Appointment newAppointment = new Appointment(date, day, hour);
        appointments.add(newAppointment);
        PrintUtils.println("Appointment added: " + newAppointment);
    }

    public void viewAppointments() {
        if (appointments.isEmpty()) {
            PrintUtils.println("No appointments available.");
        } else {
            PrintUtils.println("All available Appointments:");
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }

    public void bookAppointment(int appointmentNumber, String customerName, String phoneNumber, String reason) {
        Appointment selectedAppointment = getAppointment(appointmentNumber);

        if (selectedAppointment != null && !selectedAppointment.isBooked()) {
            PrintUtils.println("Appointment booked successfully!");
        } else {
            PrintUtils.println("Invalid appointment number or the appointment is already booked.");
        }
    }

    public void requestInstallation(String customerName, String phoneNumber, String reason, String installerEmail) {
        AppointmentBooking appointmentBooking = new AppointmentBooking(
                customerName, phoneNumber, reason, installerEmail, null
        );
        appointmentBookings.add(appointmentBooking);
        PrintUtils.println("Installation request recorded successfully!");
    }

    private Appointment getAppointment(int appointmentNumber) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentNumber() == appointmentNumber) {
                return appointment;
            }
        }
        return null;
    }

    public void viewAppointmentBookings() {
        if (appointmentBookings.isEmpty()) {
            PrintUtils.println("No appointment bookings available.");
        } else {
            PrintUtils.println("All Appointment Bookings:");
            for (AppointmentBooking appointmentBooking : appointmentBookings) {
            	System.out.println(appointmentBooking);
            }
        }
    }



 
  
    
    //main
    public static void main(String[] args) {
        InstallerManagement installerManagement = new InstallerManagement();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
        	 PrintUtils.println("1. Add Appointment");
        	 PrintUtils.println("2. View Appointments");
        	 PrintUtils.println("3. View Appointment Bookings");
        	 PrintUtils.println("4. Exit");
        	 PrintUtils.println("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter date (e.g., 2023-12-01): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter day (e.g., Monday): ");
                    String day = scanner.nextLine();
                    System.out.print("Enter hour (e.g., 09:00 AM): ");
                    String hour = scanner.nextLine();

                    installerManagement.addNewAppointment(date, day, hour);
                    break;
                case 2:
                    installerManagement.viewAppointments();
                    break;
                case 3:
                    installerManagement.viewAppointmentBookings();
                    break;

                case 4:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
              
                
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        } while (choice != 3);

        scanner.close();
    }
}


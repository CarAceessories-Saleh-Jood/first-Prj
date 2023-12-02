package userinterface;

import java.util.logging.Logger;


import requestsmanagement.Appointment;

public class PrintUtils {
    private static Logger logger = Logger.getLogger(PrintUtils.class.getName());

	
	
	 public static void println(String message) {
		 logger.info(message);
	  }
	 
	 public static void println(Appointment app) {
		 //logger.info(app);
	  }
	 
	 public static void println() {
			
			
		} 
	 
}

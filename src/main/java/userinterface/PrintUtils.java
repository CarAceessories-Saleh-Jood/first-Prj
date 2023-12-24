package userinterface;

import requestsmanagement.Appointment;

import java.io.PrintWriter;

public class PrintUtils {
   

    private static final PrintWriter writer = new PrintWriter(System.out, true);

    public static void println(String message) {
        print(message);
    }

    public static void println(Appointment app) {
        print(app.toString());
    }

    public static void println() {
        print("");  // Empty string, as there's no logger in this version
    }

    private static void print(String output) {
        writer.println(output);
    }
}
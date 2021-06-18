package SeatDiscountSystem;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class SeatDiscountSystem {
	
	public static void main (String[] args)  throws FileNotFoundException {
		
		// Declaring scanners and file reader.
		Scanner input = new Scanner (System.in);
		Scanner file = new Scanner (new FileReader("C:\\Users\\Anon\\eclipse-workspace\\SeatBookingSystem\\src\\seats.txt"));
		
		// Declaring the variables used throughout the application.
		String seatType;
		double discountRate = 20.0, seatPrice, seatBookings, seatDiscount, seatIncome, totalIncome = 0, totalDisc = 0;
		
		// Main Menu
		System.out.println("-- Seat Booking System --\n\n"
				+ "Specify Custom Discount Rate [Y|N]: ");
		String choice = input.nextLine().toUpperCase();
		
		// Ask user if they wish to specify a discount rate, also notify them of invalid input.
		if (choice.contentEquals("Y")) {
			System.out.println("Specify Discount Rate (%):");
			discountRate = input.nextDouble();
		} else if (choice.contentEquals("N")) {
			System.out.printf("Assuming Discount Rate = %.1f%%\n", discountRate);
		} else {
			System.out.println("Invalid Input! Please try again.");
		}
		
		// While the file has contents iterate the conditions stated within the loop.
		while(file.hasNext()) {
			
			// Populating the variable with their respective data from the given text file.
			seatType = file.next();
			seatPrice = file.nextDouble();
			seatBookings = file.nextDouble();
			
			// Calculating the seat discount and seat income.
			seatDiscount = ((seatPrice * seatBookings) * discountRate) / 100;
			seatIncome = (seatPrice * seatBookings) - seatDiscount;
			
			// Output seating information.
			System.out.printf("\nSeat Type: %s, Seat Price: £%.2f, Bookings: %.0f, Discount: £%.2f, Income: £%.2f"
					, seatType, seatPrice, seatBookings, seatDiscount, seatIncome);
			
			// Tally the total income and total discount.
			totalIncome += seatIncome;
			totalDisc += seatDiscount;
		}
		
		// Output total income and total discount.
		System.out.printf("\n\nTotal Income: £%.2f\n", totalIncome);
		System.out.printf("Total Discount: £%.2f", totalDisc);
		
		// Close both scanners;
		file.close();
		input.close();
		
	}
	
}

package com.company;

public class Main {

    public static void main(String[] args) {
        int num_months = 0;
        double interest_due;
        double interest_paid = 0;

        // Take in user data for the simulation
        System.out.println("What is the cost of the stereo?");
        double principle = Double.parseDouble(TextIO.getlnString());

        System.out.println("What is the annual interest rate percentage?");
        double interest_percentage = Double.parseDouble(TextIO.getlnString());
        double monthly_interest_rate = (interest_percentage / 100) / 12;

        System.out.println("What is the monthly payment?");
        double monthly_payment = Double.parseDouble(TextIO.getlnString());

        boolean still_paying = true;  // FLow control variable, change to false to stop the loop
        while(still_paying){  // Simulate the payments one month at a time
            // Find this months interest due
            interest_due = calculate_interest_due(principle, monthly_interest_rate);
            
            // If the monthly payment is less than the interest due, kill program to avoid infinite loop
            if((monthly_payment - interest_due) <= 0){
                System.out.println("Insufficient monthly payment; will never pay off");
                System.exit(0);
            }

            // Modify output variables
            // This is done before the check to see if payment is done so that the final result is correct
            interest_paid = calculate_interest_paid(interest_paid, interest_due);  // The interests due is paid
            num_months++;   // Number of months goes up by one

            // Check to see if the payments are complete after this month,
            if(principle <= monthly_payment - interest_due) {  // If so stop looping
                still_paying = false;
            } else{ // If not reduce the principle
                principle = calculate_remaining_principle(principle, monthly_payment, interest_due);
            }
        }

        System.out.println("Months to pay off: " + num_months);
        System.out.println("Interest paid: " + interest_paid);

    }

    // Calculation methods
    public static double calculate_interest_due(double principle, double monthly_interest_rate) {
        return principle * monthly_interest_rate;
    }

    public static double calculate_interest_paid(double interest_paid, double interest_due) {
        return interest_paid + interest_due;
    }

    public static double calculate_remaining_principle(double principle, double monthly_payment, double interest_due) {
        return principle - (monthly_payment - interest_due);
    }
}


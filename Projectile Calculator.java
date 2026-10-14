// Name: Abdul Qadir Batavia
// Program Name: Simple Java Application
// Date: Feb 4, 2024
// Description: The program prints the projectile position at time, 
// horizontal position and Vertical position.


package Package1; // The code is in the "Pack" package

import java.util.Scanner;

public class Activity1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for initial angle
        double initialAngle = getPositiveDoubleInput(scanner, "Enter the initial angle of the projectile in degrees:");

        // Prompt user for initial velocity
        double initialVelocity = getPositiveDoubleInput(scanner, "Enter the initial velocity of the projectile in m/s:");

        // Prompt user for time
        double time = getPositiveDoubleInput(scanner, "Enter the time at which you want to calculate the projectile's position in seconds:");

        // Calculate projectile position
        double horizontalPosition = calculateHorizontalPosition(initialVelocity, initialAngle, time);
        double verticalPosition = calculateVerticalPosition(initialVelocity, initialAngle, time);

        // Display results rounded to two decimal places
        System.out.println("Projectile position at time " + time + " seconds:");
        System.out.println("Horizontal position: " + roundToTwoDecimalPlaces(horizontalPosition) + " meters");
        System.out.println("Vertical position: " + roundToTwoDecimalPlaces(verticalPosition) + " meters");

        scanner.close();
    }

    // Function to get positive double input from the user
    private static double getPositiveDoubleInput(Scanner scanner, String prompt) {
        double value;
        do {
            System.out.println(prompt);
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a positive number.");
                scanner.next(); // Consume invalid input
            }
            value = scanner.nextDouble();
            if (value <= 0) {
                System.out.println("Invalid input. Please enter a positive number.");
            }
        } while (value <= 0);
        return value;
    }

    // Function to calculate horizontal position using projectile motion formula
    private static double calculateHorizontalPosition(double initialVelocity, double initialAngle, double time) {
        double angleInRadians = Math.toRadians(initialAngle);
        return initialVelocity * Math.cos(angleInRadians) * time;
    }

    // Function to calculate vertical position using projectile motion formula
    private static double calculateVerticalPosition(double initialVelocity, double initialAngle, double time) {
        double angleInRadians = Math.toRadians(initialAngle);
        double gravitationalForce = -9.81; // m/s^2
        return (initialVelocity * Math.sin(angleInRadians) * time) + (0.5 * gravitationalForce * Math.pow(time, 2));
    }

    // Function to round a value to two decimal places
    private static double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}

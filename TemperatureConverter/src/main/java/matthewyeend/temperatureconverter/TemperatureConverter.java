/*
 * Auther:  Matthew Yeend
 * Project: Temperature Converter
 * Version: v1.1.1
 * Date:    21/03/2025
 */

package matthewyeend.temperatureconverter;

import java.util.Scanner;

/**
 *
 * @author matthewyeend
 */
public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Temperature Converter ---");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Celsius to Kelvin");
            System.out.println("3. Fahrenheit to Celsius");
            System.out.println("4. Fahrenheit to Kelvin");
            System.out.println("5. Kelvin to Celsius");
            System.out.println("6. Kelvin to Fahrenheit");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 6) {
                System.out.print("Enter temperature: ");
                double temp = scanner.nextDouble();
                double convertedTemp = convertTemperature(choice, temp);
                System.out.println("Converted Temperature: " + convertedTemp);
            } else if (choice == 7) {
                System.out.println("Exiting... Goodbye!");
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
    
    private static double convertTemperature(int choice, double temp) {
        switch (choice) {
            case 1: return (temp * 9/5) + 32;  // Celsius to Fahrenheit
            case 2: return temp + 273.15;      // Celsius to Kelvin
            case 3: return (temp - 32) * 5/9;  // Fahrenheit to Celsius
            case 4: return (temp - 32) * 5/9 + 273.15;  // Fahrenheit to Kelvin
            case 5: return temp - 273.15;      // Kelvin to Celsius
            case 6: return (temp - 273.15) * 9/5 + 32;  // Kelvin to Fahrenheit
            default: return 0;
        }
    }
}

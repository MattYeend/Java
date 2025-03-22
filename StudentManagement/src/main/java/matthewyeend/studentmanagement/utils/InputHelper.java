/*
 * Author:  Matthew Yeend
 * Project: StudentManagement
 * File:    StudentService
 * Version: v1.1.1
 * Date:    22/03/2025
 */

package matthewyeend.studentmanagement.utils;

import java.util.Scanner;

/**
 *
 * @author matthewyeend
 */
public class InputHelper {
    // Method to get integer input with validation
    public static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}

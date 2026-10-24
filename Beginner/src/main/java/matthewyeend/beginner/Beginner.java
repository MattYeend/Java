/*
 * Author:  Matthew Yeend
 * Project: Beginner
 * File:    Beginner
 * Version: v1.1.1
 * Date:    24/10/2026
 */

package matthewyeend.beginner;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 *
 * @author matthewyeend
 */
public class Beginner {

    private Beginner() {
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            System.out.print("Enter your name: ");
            String input = scanner.nextLine();

            try {
                System.out.println(Greeter.greet(input));
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid input: " + ex.getMessage());
            }
        }
    }
}

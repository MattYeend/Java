/*
 * Author:  Matthew Yeend
 * Project: Helper Files
 * File:    Helping (main)
 * Version: v1.1.1
 * Date:    22/03/2025
 */

package matthewyeend.helping;

import matthewyeend.helping.models.User;
import matthewyeend.helping.utils.Helper;

/**
 *
 * @author matthewyeend
 */
public class Helping {

    public static void main(String[] args) {
        System.out.println("Welcome to My Java Project!");

        // Create a new user
        User user = new User("John Doe", 25);

        // Print user details
        System.out.println(user);

        // Use helper method
        Helper.printMessage("Project setup is successful!");
    }
}

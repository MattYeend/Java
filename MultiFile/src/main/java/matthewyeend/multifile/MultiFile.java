/*
 * Author:  Matthew Yeend
 * Project: Multi File Project
 * Version: v1.1.1
 * Date:    22/03/2025
 */

package matthewyeend.multifile;

import utils.Helper;
import models.User;

/**
 *
 * @author matthewyeend
 */
public class MultiFile {

    public static void main(String[] args) {
        System.out.println("Welcome to the Java Multi-File Project!");
        
        Helper.sayHello("Alice");
        
        User user = new User("Alice", 25);
        System.out.println(user);
    }
}

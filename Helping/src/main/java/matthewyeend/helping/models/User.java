/*
 * Author:  Matthew Yeend
 * Project: Helper Files
 * File:    User
 * Version: v1.1.1
 * Date:    22/03/2025
 */

package matthewyeend.helping.models;

/**
 *
 * @author matthewyeend
 */
public class User {
    private String name;
    private int age;

    // Constructor
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter Methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Overriding toString() method
    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + "}";
    }
}

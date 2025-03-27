/*
 * Author:  Matthew Yeend
 * Project: EmployerManagement
 * File:    Person
 * Version: v1.1.1
 * Date:    27/03/2025
 */

package matthewyeend.employermanagement;

/**
 *
 * @author matthewyeend
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

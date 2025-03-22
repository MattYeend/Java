/*
 * Author:  Matthew Yeend
 * Project: StudentManagement
 * File:    Student
 * Version: v1.1.1
 * Date:    22/03/2025
 */

package matthewyeend.studentmanagement.models;

/**
 *
 * @author matthewyeend
 */
public class Student {
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // toString method to display student details
    @Override
    public String toString() {
        return "Student{Name='" + name + "', Age=" + age + "}";
    }
}

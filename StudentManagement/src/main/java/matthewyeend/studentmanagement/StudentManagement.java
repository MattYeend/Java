/*
 * Author:  Matthew Yeend
 * Project: StudentManagement
 * File:    StudentManagement (main)
 * Version: v1.1.1
 * Date:    22/03/2025
 */

package matthewyeend.studentmanagement;

import matthewyeend.studentmanagement.models.Student;
import matthewyeend.studentmanagement.services.StudentService;
import matthewyeend.studentmanagement.utils.InputHelper;
import java.util.Scanner;

/**
 *
 * @author matthewyeend
 */
public class StudentManagement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = InputHelper.getIntInput(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter student age: ");
                    int age = InputHelper.getIntInput(scanner);

                    Student student = new Student(name, age);
                    studentService.addStudent(student);
                    break;
                    
                case 2:
                    studentService.displayStudents();
                    break;
                    
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

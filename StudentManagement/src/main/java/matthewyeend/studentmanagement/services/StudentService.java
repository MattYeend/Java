/*
 * Author:  Matthew Yeend
 * Project: StudentManagement
 * File:    StudentService
 * Version: v1.1.1
 * Date:    22/03/2025
 */

package matthewyeend.studentmanagement.services;

import matthewyeend.studentmanagement.models.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matthewyeend
 */
public class StudentService {
    private List<Student> students = new ArrayList<>();

    // Add a student to the list
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully: " + student);
    }

    // Display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\nList of Students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}

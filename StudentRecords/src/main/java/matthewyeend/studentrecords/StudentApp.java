/*
 * Author:  Matthew Yeend
 * Project: Student Records
 * File:    StudentApp
 * Version: v1.1.1
 * Date:    24/10/2026
 */
package matthewyeend.studentrecords;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author matthewyeend
 */
public final class StudentApp {

    private static final System.Logger LOGGER = System.getLogger(StudentApp.class.getName());

    private StudentApp() {
    }

    public static void main(String[] args) {
        try (Connection connection = Database.getConnection();
             Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            run(new StudentRepository(connection), scanner);
        } catch (IllegalStateException ex) {
            System.out.println("Configuration error: " + ex.getMessage());
        } catch (SQLException ex) {
            logDatabaseError(ex);
            System.out.println("Could not connect to the database.");
        }
    }

    private static void run(StudentRepository repository, Scanner scanner) {
        boolean running = true;
        while (running) {
            printMenu();
            try {
                switch (prompt(scanner, "Choose an option").strip()) {
                    case "1" -> addStudent(repository, scanner);
                    case "2" -> printStudents(repository.findAll());
                    case "3" -> searchStudents(repository, scanner);
                    case "4" -> deleteStudent(repository, scanner);
                    case "5" -> running = false;
                    default -> System.out.println("Please choose 1 to 5.");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid input: " + ex.getMessage());
            } catch (SQLIntegrityConstraintViolationException ex) {
                System.out.println("A student with that email already exists.");
            } catch (SQLException ex) {
                logDatabaseError(ex);
                System.out.println("A database error occurred. Please try again.");
            } catch (NoSuchElementException ex) {
                System.out.println("Input ended. Goodbye.");
                running = false;
            }
        }
    }

    private static void addStudent(StudentRepository repository, Scanner scanner)
            throws SQLException {
        Student student = Student.newStudent(
                prompt(scanner, "First name"),
                prompt(scanner, "Last name"),
                prompt(scanner, "Email"));
        long id = repository.add(student);
        System.out.println("Student saved with ID " + id + ".");
    }

    private static void searchStudents(StudentRepository repository, Scanner scanner)
            throws SQLException {
        String lastName = prompt(scanner, "Last name to search for").strip();
        if (lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name must not be blank.");
        }
        printStudents(repository.findByLastName(lastName));
    }

    private static void deleteStudent(StudentRepository repository, Scanner scanner)
            throws SQLException {
        long id = parseId(prompt(scanner, "ID of student to delete"));
        System.out.println(repository.deleteById(id)
                ? "Student deleted."
                : "No student found with that ID.");
    }

    private static long parseId(String input) {
        try {
            long id = Long.parseLong(input.strip());
            if (id < 1) {
                throw new IllegalArgumentException("ID must be a positive whole number.");
            }
            return id;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("ID must be a positive whole number.");
        }
    }

    private static void printStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.printf("%-6s %-20s %-20s %s%n", "ID", "First name", "Last name", "Email");
        for (Student student : students) {
            System.out.printf("%-6d %-20s %-20s %s%n",
                    student.id(), student.firstName(), student.lastName(), student.email());
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1) Add student");
        System.out.println("2) List students");
        System.out.println("3) Search by last name");
        System.out.println("4) Delete student");
        System.out.println("5) Quit");
    }

    private static String prompt(Scanner scanner, String label) {
        System.out.print(label + ": ");
        return scanner.nextLine();
    }

    /** Logs only the SQL state code, never the message, which can contain table or query detail. */
    private static void logDatabaseError(SQLException ex) {
        LOGGER.log(System.Logger.Level.ERROR, "Database error. SQLState: " + ex.getSQLState());
    }
}

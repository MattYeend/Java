/*
 * Author:  Matthew Yeend
 * Project: Student Records
 * File:    Student
 * Version: v1.1.1
 * Date:    24/10/2026
 */
package matthewyeend.studentrecords;

import java.util.Locale;
import java.util.regex.Pattern;

/**
 *
 * @author matthewyeend
 */
public record Student(long id, String firstName, String lastName, String email) {

    private static final int MAX_NAME_LENGTH = 50;
    private static final int MAX_EMAIL_LENGTH = 100;
    private static final Pattern NAME_PATTERN = Pattern.compile("[\\p{L} '-]+");
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");

    public Student {
        firstName = validateName(firstName, "First name");
        lastName = validateName(lastName, "Last name");
        email = validateEmail(email);
    }

    /** Creates a student that has not been saved yet (the database assigns the id). */
    public static Student newStudent(String firstName, String lastName, String email) {
        return new Student(0, firstName, lastName, email);
    }

    private static String validateName(String value, String label) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(label + " must not be blank.");
        }
        String cleaned = value.strip();
        if (cleaned.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    label + " must be " + MAX_NAME_LENGTH + " characters or fewer.");
        }
        if (!NAME_PATTERN.matcher(cleaned).matches()) {
            throw new IllegalArgumentException(
                    label + " may only contain letters, spaces, apostrophes and hyphens.");
        }
        return cleaned;
    }

    private static String validateEmail(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Email must not be blank.");
        }
        String cleaned = value.strip().toLowerCase(Locale.ROOT);
        if (cleaned.length() > MAX_EMAIL_LENGTH) {
            throw new IllegalArgumentException(
                    "Email must be " + MAX_EMAIL_LENGTH + " characters or fewer.");
        }
        if (!EMAIL_PATTERN.matcher(cleaned).matches()) {
            throw new IllegalArgumentException("Email address is not in a valid format.");
        }
        return cleaned;
    }
}
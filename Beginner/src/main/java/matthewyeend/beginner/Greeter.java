/*
 * Author:  Matthew Yeend
 * Project: Beginner
 * File:    Greeter
 * Version: v1.1.1
 * Date:    24/10/2026
 */
package matthewyeend.beginner;

/**
 *
 * @author matthewyeend
 */
public final class Greeter {

    private static final int MAX_NAME_LENGTH = 50;
    private static final String VALID_NAME_PATTERN = "[\\p{L} '-]+";

    private Greeter() {
        // Utility class, no instances needed.
    }

    public static String greet(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be blank.");
        }

        String cleanedName = name.strip();

        if (cleanedName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    "Name must be " + MAX_NAME_LENGTH + " characters or fewer.");
        }

        if (!cleanedName.matches(VALID_NAME_PATTERN)) {
            throw new IllegalArgumentException(
                    "Name may only contain letters, spaces, apostrophes and hyphens.");
        }

        return "Hello, " + cleanedName + "!";
    }
}
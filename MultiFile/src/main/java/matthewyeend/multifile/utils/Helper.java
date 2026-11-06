/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matthewyeend.multifile.utils;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 *
 * @author matthewyeend
 */
public class Helper {
    // Letters (any script), spaces, apostrophes and hyphens; 1 to 100 characters.
    private static final Pattern VALID_NAME =
            Pattern.compile("^\\p{L}[\\p{L} '\\-]{0,99}$");

    private Helper() {
        throw new AssertionError("Utility class must not be instantiated");
    }

    public static void sayHello(String name) {
        System.out.println("Hello, " + requireValidName(name) + "!");
    }

    public static String requireValidName(String name) {
        Objects.requireNonNull(name, "name must not be null");
        String trimmed = name.strip();
        if (!VALID_NAME.matcher(trimmed).matches()) {
            throw new IllegalArgumentException("Name contains invalid characters or is too long");
        }
        return trimmed;
    }
}

/*
 * Author:  Matthew Yeend
 * Project: Student Records
 * File:    Database
 * Version: v1.1.1
 * Date:    24/10/2026
 */
package matthewyeend.studentrecords;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author matthewyeend
 */
public final class Database {
    private Database() {
    }

    public static Connection getConnection() throws SQLException {
        String url = requireEnv("DB_URL");
        String user = requireEnv("DB_USER");
        String password = requireEnv("DB_PASSWORD");
        return DriverManager.getConnection(url, user, password);
    }

    private static String requireEnv(String name) {
        String value = System.getenv(name);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Missing environment variable: " + name);
        }
        return value;
    }
}

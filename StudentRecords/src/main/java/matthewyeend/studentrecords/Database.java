/*
 * Author:  Matthew Yeend
 * Project: Student Records
 * File:    Database
 * Version: v1.1.1
 * Date:    24/10/2026
 */
package matthewyeend.studentrecords;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Set;


/**
 *
 * @author matthewyeend
 */
public final class Database {
    private static final Path CONFIG_PATH = Path.of(
            System.getProperty("user.home"), ".config", "studentrecords", "db.properties");

    private Database() {
    }

    public static Connection getConnection() throws SQLException {
        Properties config = loadConfig();
        return DriverManager.getConnection(
                require(config, "db.url"),
                require(config, "db.user"),
                require(config, "db.password"));
    }

    private static Properties loadConfig() {
        if (!Files.isRegularFile(CONFIG_PATH)) {
            throw new IllegalStateException("Config file not found: " + CONFIG_PATH);
        }
        try {
            Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(CONFIG_PATH);
            boolean tooOpen = permissions.stream().anyMatch(p -> p.name().startsWith("GROUP_")
                    || p.name().startsWith("OTHERS_"));
            if (tooOpen) {
                throw new IllegalStateException(
                        "Config file must be readable by you only. Run: chmod 600 " + CONFIG_PATH);
            }
            Properties config = new Properties();
            try (InputStream in = Files.newInputStream(CONFIG_PATH)) {
                config.load(in);
            }
            return config;
        } catch (IOException ex) {
            throw new IllegalStateException("Could not read the config file.");
        }
    }

    private static String require(Properties config, String key) {
        String value = config.getProperty(key);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Missing setting in config file: " + key);
        }
        return value.strip();
    }
}

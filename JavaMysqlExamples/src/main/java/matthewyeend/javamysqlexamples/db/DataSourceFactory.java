/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matthewyeend.javamysqlexamples.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.util.Objects;
/**
 *
 * @author matthewyeend
 */
public final class DataSourceFactory {

    private DataSourceFactory() {
    }

    public static HikariDataSource create() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(required("DB_URL"));
        config.setUsername(required("DB_USER"));
        config.setPassword(required("DB_PASSWORD"));
        config.setMaximumPoolSize(10);
        config.setConnectionTimeout(5_000);
        config.setPoolName("demo-pool");
        return new HikariDataSource(config);
    }

    private static String required(String name) {
        // System property (IDE run configuration) takes precedence, then the environment
        String value = System.getProperty(name, System.getenv(name));
        return Objects.requireNonNull(value, "Missing configuration: " + name);
    }
}

/*
 * Author:  Matthew Yeend
 * Project: Student Records
 * File:    StudentRepository
 * Version: v1.1.1
 * Date:    24/10/2026
 */
package matthewyeend.studentrecords;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author matthewyeend
 */
public final class StudentRepository {

    private static final String INSERT_SQL =
            "INSERT INTO students (first_name, last_name, email) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_SQL =
            "SELECT id, first_name, last_name, email FROM students "
            + "ORDER BY last_name, first_name LIMIT 100";
    private static final String SELECT_BY_LAST_NAME_SQL =
            "SELECT id, first_name, last_name, email FROM students "
            + "WHERE last_name = ? ORDER BY first_name LIMIT 100";
    private static final String DELETE_SQL = "DELETE FROM students WHERE id = ?";

    private final Connection connection;

    public StudentRepository(Connection connection) {
        this.connection = Objects.requireNonNull(connection);
    }

    public long add(Student student) throws SQLException {
        try (PreparedStatement statement =
                     connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, student.firstName());
            statement.setString(2, student.lastName());
            statement.setString(3, student.email());
            statement.executeUpdate();

            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getLong(1);
                }
                throw new SQLException("No generated key was returned.");
            }
        }
    }

    public List<Student> findAll() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL);
             ResultSet results = statement.executeQuery()) {
            return readStudents(results);
        }
    }

    public List<Student> findByLastName(String lastName) throws SQLException {
        try (PreparedStatement statement =
                     connection.prepareStatement(SELECT_BY_LAST_NAME_SQL)) {
            statement.setString(1, lastName);
            try (ResultSet results = statement.executeQuery()) {
                return readStudents(results);
            }
        }
    }

    public boolean deleteById(long id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
            statement.setLong(1, id);
            return statement.executeUpdate() == 1;
        }
    }

    private static List<Student> readStudents(ResultSet results) throws SQLException {
        List<Student> students = new ArrayList<>();
        while (results.next()) {
            students.add(new Student(
                    results.getLong("id"),
                    results.getString("first_name"),
                    results.getString("last_name"),
                    results.getString("email")));
        }
        return students;
    }
}
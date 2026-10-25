/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package matthewyeend.javamysqlexamples;

import matthewyeend.javamysqlexamples.domain.PaymentDescriber;
import matthewyeend.javamysqlexamples.domain.CardPayment;
import matthewyeend.javamysqlexamples.domain.BankTransfer;
import com.zaxxer.hikari.HikariDataSource;
import matthewyeend.javamysqlexamples.db.CustomerRepository;
import matthewyeend.javamysqlexamples.db.CustomerRepository.Customer;
import matthewyeend.javamysqlexamples.db.DataSourceFactory;
import matthewyeend.javamysqlexamples.report.CountryReport;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author matthewyeend
 */
public final class JavaMysqlExamples {

    private JavaMysqlExamples() {
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(PaymentDescriber.describe(new CardPayment("4242")));
        System.out.println(PaymentDescriber.describe(new BankTransfer("12")));

        try (HikariDataSource dataSource = DataSourceFactory.create()) {
            CustomerRepository repository = new CustomerRepository(dataSource);

            final String email = "alice@example.com";
            Optional<Customer> existing = repository.findByEmail(email);
            long id = existing.isPresent()
                    ? existing.get().id()
                    : repository.insert(email, "Alice Example", "GB");

            // Log the surrogate key only, never personal data (ISO 27001 A.8.15)
            System.out.println("Customer id: " + id);
        }

        List<Customer> sample = List.of(
                new Customer(1, "a@example.com", "A", "GB"),
                new Customer(2, "b@example.com", "B", "FR"),
                new Customer(3, "c@example.com", "C", "GB"));
        System.out.println(CountryReport.customersPerCountry(sample));
    }
}
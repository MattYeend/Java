/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matthewyeend.javamysqlexamples.report;

import matthewyeend.javamysqlexamples.db.CustomerRepository.Customer;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author matthewyeend
 */
class CountryReportTest {

    @Test
    void countsCustomersPerCountryInSortedOrder() {
        List<Customer> customers = List.of(
                new Customer(1, "a@example.com", "A", "GB"),
                new Customer(2, "b@example.com", "B", "FR"),
                new Customer(3, "c@example.com", "C", "GB"));

        Map<String, Long> result = CountryReport.customersPerCountry(customers);

        assertEquals(Map.of("FR", 1L, "GB", 2L), result);
        assertEquals(List.of("FR", "GB"), List.copyOf(result.keySet()));
    }
}
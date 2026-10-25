/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matthewyeend.javamysqlexamples.report;

import matthewyeend.javamysqlexamples.db.CustomerRepository.Customer;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 *
 * @author matthewyeend
 */
public final class CountryReport {

    private CountryReport() {
    }

    public static Map<String, Long> customersPerCountry(List<Customer> customers) {
        return customers.stream()
                .collect(Collectors.groupingBy(
                        Customer::country,
                        TreeMap::new,
                        Collectors.counting()));
    }
}
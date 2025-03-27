/*
 * Author:  Matthew Yeend
 * Project: EmployerManagement
 * File:    EmployerManagement (main)
 * Version: v1.1.1
 * Date:    27/03/2025
 */

package matthewyeend.employermanagement;

/**
 *
 * @author matthewyeend
 */
public class EmployerManagement {

    public static void main(String[] args) {
        Company company = new Company("TechCorp");

        Employee emp1 = new Employee("Alice", 30, "Software Engineer", 70000);
        Employee emp2 = new Employee("Bob", 35, "Manager", 90000);

        company.addEmployee(emp1);
        company.addEmployee(emp2);

        company.listEmployees();
    }
}

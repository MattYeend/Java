/*
 * Author:  Matthew Yeend
 * Project: EmployerManagement
 * File:    Company
 * Version: v1.1.1
 * Date:    27/03/2025
 */

package matthewyeend.employermanagement;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matthewyeend
 */
public class Company {
    private String name;
    private List<Employee> employees;

    public Company(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void listEmployees() {
        System.out.println("Employees at " + name + ":");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}

/*
 * Author:  Matthew Yeend
 * Project: EmployerManagement
 * File:    Employee
 * Version: v1.1.1
 * Date:    27/03/2025
 */

package matthewyeend.employermanagement;

/**
 *
 * @author matthewyeend
 */
public class Employee extends Person{
    private String position;
    private double salary;

    public Employee(String name, int age, String position, double salary) {
        super(name, age);
        this.position = position;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Position: " + position + ", Salary: $" + salary;
    }
}

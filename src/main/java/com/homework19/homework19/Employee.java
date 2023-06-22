package com.homework19.homework19;

import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.Random;

import static org.springframework.util.StringUtils.capitalize;

public class Employee {
    private String firstName;
    private String lastName;
    private int departmentId;
    private int salary;



    public Employee(String firstName, String lastName) {
        Random random = new Random();
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
        this.departmentId = random.nextInt(5) + 1;
        this.salary = random.nextInt(10000) + 1000;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getSalary() {
        return salary;
    }

    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
public String getFullName() {return firstName + " " + lastName;}
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof  Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }
    @Override
    public int hashCode(){
        return Objects.hash(firstName,lastName, salary, departmentId);
    }
    @Override
    public String toString(){
        return "Employee{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", salary='" + salary + '\'' + ", department='" + '}';
    }
}

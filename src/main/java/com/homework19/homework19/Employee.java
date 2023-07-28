package com.homework19.homework19;

import java.util.Objects;

import static org.springframework.util.StringUtils.capitalize;

public class Employee {
    private String firstName;
    private String lastName;
    private int departmentId;
    private int salary;



    public Employee(String firstName, String lastName, int salary, int departmentId2) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
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

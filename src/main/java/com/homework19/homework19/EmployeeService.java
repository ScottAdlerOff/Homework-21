package com.homework19.homework19;

import java.util.Collection;

public interface EmployeeService {

    Employee add(String firstName, String lastName, int salary, int departmentId);

    Employee remove(String firstName, String lastName, int salary, int departmentId);

    Employee find(String firstName, String lastName, int salary, int departmentId);

    Collection<Employee> findAll();
}

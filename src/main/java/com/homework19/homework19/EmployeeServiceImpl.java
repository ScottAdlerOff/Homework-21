package com.homework19.homework19;

import org.springframework.stereotype.Service;

import java.util.*;

import static org.springframework.util.StringUtils.capitalize;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;
    private final EmployeeValidationService validationService;

    public EmployeeServiceImpl(EmployeeValidationService validationService) {

        this.validationService = validationService;
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int departmentId) {
        validationService.validate(firstName,lastName);
        return addEmployee(new Employee(capitalize(firstName), capitalize(lastName)));
    }

    @Override
    public Employee add(String firstName, String lastName){
        validationService.validate(firstName,lastName);
        return addEmployee(new Employee(capitalize(firstName), capitalize(lastName)));
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = find(firstName, lastName);
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        String fullNameKey = firstName + " " + lastName;
        if (!employees.containsKey(fullNameKey)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(fullNameKey);
    }


    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }

    private Employee addEmployee(Employee employee){
        if (employees.containsKey(employee.getFullName())){
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }
}

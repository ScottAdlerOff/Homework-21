package com.homework19.homework19;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmenrServiceImpl implements DepartmentService{
    private final EmployeeService employeeService;

    public DepartmenrServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalary(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeWithMinSalary(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> findEmployeesByDepartment(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .sorted(comparing(Employee::getFullName).thenComparing(Employee::getFirstName))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeesByDepartment() {
        return employeeService.findAll().stream()
                .sorted(comparing(Employee::getFullName).thenComparing(Employee::getFirstName))
                .collect(groupingBy(Employee::getDepartmentId));
    }
}

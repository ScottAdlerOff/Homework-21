package com.homework19.homework19;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Integer getDepartmentSalarySum(int departmentId);
    Employee findEmployeeWithMaxSalary(int departmentId);

    Employee findEmployeeWithMinSalary(int departmentId);

    Collection<Employee> findEmployeesByDepartment(int departmentId);
    Map<Integer, List<Employee>> findEmployeesByDepartment();
}

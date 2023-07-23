package com.homework19.homework19;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.homework19.homework19.EmployeeTestConstants.*;
import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void shouldReturnTotalSalaryByDepartment(){
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(DEPARTMENT_TOTAL_SALARY,departmentService.getDepartmentSalarySum(DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnEmployeeWithMaxByDepartment(){
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals (MAX_SALARY_EMPLOYEE,departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnEmployeeWithMinByDepartment(){
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals (MIN_SALARY_EMPLOYEE,departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldEmployeeNotFoundExceptionWithFindEmployeeWithMaxSalary(){
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows (EmployeeNotFoundException.class,
                () -> departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldEmployeeNotFoundExceptionWithFindEmployeeWithMinSalary(){
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows (EmployeeNotFoundException.class,
                () -> departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnEmployeesByDepartmentId() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);

        assertEquals(EMPLOYEES, departmentService.findEmployeesByDepartment(DEPARTMENT_ID));
        assertEquals(singletonList(OTHER_DEPARTMENT_EMPLOYEE), departmentService.findEmployeesByDepartment(DEPARTMENT_ID2));
    }

    @Test
    public void shouldReturnAllEmployees() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);

        assertEquals(EMPLOYEES_BY_DEPARTMENT_MAP, departmentService.findEmployeesByDepartment());
    }

    @Test
    public void shouldReturnEmptyMapWhenAllEmployees() {
        when(employeeService.findAll()).thenReturn(emptyList());

        assertEquals(emptyMap(), departmentService.findEmployeesByDepartment());
    }
}

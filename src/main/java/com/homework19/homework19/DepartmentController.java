package com.homework19.homework19;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
private final DepartmentService departmentService;


    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}/salary/sum")
    public Integer getDepartmentSalarySum(@PathVariable int departmentId){
        return departmentService.getDepartmentSalarySum(departmentId);
    }
    @GetMapping("/{departmentId}/salary/max")
    public Employee findEmployeeWithMaxSalary(@PathVariable int departmentId){
        return departmentService.findEmployeeWithMaxSalary(departmentId);
    }
    @GetMapping("/{departmentId}/salary/min")
    public Employee findEmployeeWithMinSalary(@PathVariable int departmentId){
        return departmentService.findEmployeeWithMinSalary(departmentId);
    }
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> findEmployeesByDepartment(){
        return departmentService.findEmployeesByDepartment();
    }
    @GetMapping(value = "/{departmentId}/employees")
    public Collection<Employee> findEmployeesByDepartment(@PathVariable int departmentId){
        return departmentService.findEmployeesByDepartment(departmentId);
    }

}

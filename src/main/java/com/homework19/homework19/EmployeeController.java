package com.homework19.homework19;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @GetMapping(path = "/add")
    public Employee addEmployee (@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam int department){
        return service.add(firstName,lastName, salary, department);
    }
    @GetMapping(path = "/remove")
    public Employee removeEmployee (@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam int department){
        return service.remove(firstName,lastName);
    }
    @GetMapping(path = "/find")
    public Employee findEmployee (@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam int department){
        return service.find(firstName,lastName);
    }
    @GetMapping
    public Collection<Employee> findAll() {
        return service.findAll();
    }
}
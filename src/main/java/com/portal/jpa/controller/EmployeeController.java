package com.portal.jpa.controller;

import com.portal.jpa.dto.EmployeeResponseDTO;
import com.portal.jpa.dto.EmployeeResponseWithDepartmentDTO;
import com.portal.jpa.entity.Employee;
import com.portal.jpa.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public EmployeeResponseWithDepartmentDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }
}

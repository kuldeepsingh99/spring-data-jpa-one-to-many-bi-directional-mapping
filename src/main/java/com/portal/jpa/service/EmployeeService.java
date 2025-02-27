package com.portal.jpa.service;

import com.portal.jpa.dto.DepartmentResponseDTO;
import com.portal.jpa.dto.EmployeeResponseDTO;
import com.portal.jpa.dto.EmployeeResponseWithDepartmentDTO;
import com.portal.jpa.entity.Employee;
import com.portal.jpa.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public EmployeeResponseWithDepartmentDTO getEmployee(Long id) {

        var employee = employeeRepository.findById(id).orElseThrow();

        return new EmployeeResponseWithDepartmentDTO(
                new EmployeeResponseDTO(
                        employee.getId(),
                        employee.getName()
                ),
                new DepartmentResponseDTO(
                        employee.getDepartment().getId(),
                        employee.getDepartment().getName(),
                        employee.getDepartment().getDepartmentCode()
                )
        );
    }
}

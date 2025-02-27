package com.portal.jpa.service;

import com.portal.jpa.dto.*;
import com.portal.jpa.entity.Department;
import com.portal.jpa.entity.Employee;
import com.portal.jpa.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department saveDepartment(CreateDepartmentDTO createDepartmentDTO) {
        Department department = new Department();
        department.setName(createDepartmentDTO.name());
        department.setDepartmentCode(createDepartmentDTO.departmentCode());

        createDepartmentDTO.employeeNames().forEach(employeeName -> {
            Employee employee = new Employee();
            employee.setName(employeeName);
            employee.setDepartment(department);
            department.getEmployees().add(employee);
        });
        return departmentRepository.save(department);
    }

    public Department addEmployee(AddEmployeeDTO addEmployeeDTO) {
        Department department = departmentRepository.findById(addEmployeeDTO.departmentId()).orElseThrow();
        Employee employee = new Employee();
        employee.setName(addEmployeeDTO.name());
        employee.setDepartment(department);
        department.getEmployees().add(employee);
        return departmentRepository.save(department);
    }

    public DepartmentResponseWithEmployeeDTO getDepartment(Long id) {
        var department = departmentRepository.findById(id).orElseThrow();
        return new DepartmentResponseWithEmployeeDTO(
                new DepartmentResponseDTO(department.getId(),
                        department.getName(),
                        department.getDepartmentCode()),

                department.getEmployees().stream()
                        .map(employee ->
                                new EmployeeResponseDTO(employee.getId(),
                                        employee.getName()))
                        .collect(Collectors.toList())
        );
    }

    public List<DepartmentResponseWithEmployeeDTO> getAllDepartment() {


        var departments =  departmentRepository.findAll();

        return departments.stream()
                .map(department -> new DepartmentResponseWithEmployeeDTO(
                        new DepartmentResponseDTO(department.getId(),
                                department.getName(),
                                department.getDepartmentCode()),
                        department.getEmployees().stream()
                                .map(employee ->
                                        new EmployeeResponseDTO(employee.getId(),
                                                employee.getName()))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }
}

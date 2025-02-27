package com.portal.jpa.controller;

import com.portal.jpa.dto.AddEmployeeDTO;
import com.portal.jpa.dto.CreateDepartmentDTO;
import com.portal.jpa.dto.DepartmentResponseWithEmployeeDTO;
import com.portal.jpa.entity.Department;
import com.portal.jpa.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/save")
    public Long saveDepartment(@RequestBody CreateDepartmentDTO createDepartmentDTO) {
        return departmentService.saveDepartment(createDepartmentDTO).getId();
    }

    @PostMapping("/addEmployee")
    public Long addEmployee(@RequestBody AddEmployeeDTO addEmployeeDTO) {
        return departmentService.addEmployee(addEmployeeDTO).getId();
    }

    @GetMapping("/get/{id}")
    public DepartmentResponseWithEmployeeDTO getDepartment(@PathVariable Long id) {
        return departmentService.getDepartment(id);
    }

    @GetMapping
    public List<DepartmentResponseWithEmployeeDTO> getDepartment() {
        return departmentService.getAllDepartment();
    }
}

package com.portal.jpa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CreateDepartmentDTO(
        @JsonProperty("department_name")
        String name,

        @JsonProperty("department_code")
        String departmentCode,

        @JsonProperty("employee_names")
        List<String> employeeNames

) {
}

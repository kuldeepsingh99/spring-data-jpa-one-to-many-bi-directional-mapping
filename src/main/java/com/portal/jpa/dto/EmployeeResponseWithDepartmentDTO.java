package com.portal.jpa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EmployeeResponseWithDepartmentDTO(

        @JsonProperty("employee")
        EmployeeResponseDTO employee,

        @JsonProperty
        DepartmentResponseDTO department
) {
}

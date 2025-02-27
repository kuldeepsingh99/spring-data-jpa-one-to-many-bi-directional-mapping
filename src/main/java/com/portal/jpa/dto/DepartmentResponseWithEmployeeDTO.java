package com.portal.jpa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record DepartmentResponseWithEmployeeDTO(

        @JsonProperty
        DepartmentResponseDTO department,

        @JsonProperty("employees")
        List<EmployeeResponseDTO> employees
) {
}

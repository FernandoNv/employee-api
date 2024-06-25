package com.example.employee_api.department;

import com.example.employee_api.employee.Employee;
import jakarta.validation.constraints.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DepartmentSaveDTO(
        @NotBlank
        String name,
        @NotNull
        Boolean active,
        @NotNull
        @Valid
        Employee manager,
        @NotNull
        List<Employee> employeeList,
        @NotNull
        List<Position> positionList,

) {
}

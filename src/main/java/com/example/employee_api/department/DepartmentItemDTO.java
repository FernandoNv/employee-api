package com.example.employee_api.department;

import com.example.employee_api.employee.Employee;
import jakarta.validation.constraints.Null;

public record DepartmentItemDTO(
        Long id,
        String name,
        Boolean active,
        Employee manager,
        List<Employee> employeeList,
        List<Position> positionList

) {
    public DepartmentItemDTO(Department department) {
        this(
            department.getId(), 
            department.getName(),
            department.getActive(),
            department.getManager(),
            department.getEmployeeList(),
            department.getPositionList()
            );
    }
}
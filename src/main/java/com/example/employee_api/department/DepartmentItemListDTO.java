package com.example.employee_api.department;

import com.example.employee_api.employee.EmployeeItemDTO;

import java.util.List;

public record DepartmentItemListDTO(
        Long id,
        String name,
        EmployeeItemDTO manager,
        List<PositionItemListDTO> positions
) {

    public DepartmentItemListDTO(Department department) {
        this(
                department.getId(),
                department.getName(),
                new EmployeeItemDTO(department.getManager()),
                department.getPositionList().stream().map(PositionItemListDTO::new).toList()
        );
    }
}

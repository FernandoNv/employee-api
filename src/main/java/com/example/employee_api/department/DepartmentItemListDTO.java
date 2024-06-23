package com.example.employee_api.department;

import java.util.List;

public record DepartmentItemListDTO(
        Long id,
        String name,
        List<PositionItemListDTO> positionList
) {

    public DepartmentItemListDTO(Department department) {
        this(
                department.getId(),
                department.getName(),
                department.getPositionList().stream().map(PositionItemListDTO::new).toList()
        );
    }
}

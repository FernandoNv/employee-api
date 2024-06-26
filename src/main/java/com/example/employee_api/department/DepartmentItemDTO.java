package com.example.employee_api.department;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DepartmentItemDTO(
        Long id,
        String name,
        Long idManager,
        @NotNull @Valid
        List<PositionItemListDTO> positionList
) {
    public DepartmentItemDTO(Department department) {
        this(
                department.getId(),
                department.getName(),
                department.getManager().getId(),
                department.getPositionList().stream().map(PositionItemListDTO::new).toList()
        );
    }
}

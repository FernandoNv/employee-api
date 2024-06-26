package com.example.employee_api.department;

import java.util.List;

public record DepartmentSaveDTO(
        String name,
        Long idManager,
        List<PositionItemDTO> positions
) {
}

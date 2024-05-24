package com.example.employee_api.department;

public record PositionItemListDTO(
        Long id,
        String name
) {
    public PositionItemListDTO(Position position) {
        this(position.getId(), position.getName());
    }
}

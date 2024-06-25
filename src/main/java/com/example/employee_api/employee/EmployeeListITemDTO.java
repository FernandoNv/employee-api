package com.example.employee_api.employee;

public record EmployeeListITemDTO(
        Long id,
        String name,
        String department,
        String position,
        Seniority seniority
) {
    public EmployeeListITemDTO(Employee e) {
        this(
                e.getId(),
                e.getName(),
                e.getDepartment() != null ? e.getDepartment().getName() : null,
                e.getPosition() != null ? e.getPosition().getName() : null,
                e.getSeniority()
        );
    }
}

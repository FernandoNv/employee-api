package com.example.employee_api.employee;

import com.example.employee_api.address.AddressDTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmployeeItemDTO(
        Long id,
        String name,
        Seniority seniority,
        String cpf,
        String phone,
        String email,
        LocalDate birthDate,
        BigDecimal salary,
        AddressDTO address,
        String department,
        String position,
        TypeEmployee typeEmployee
) {
    EmployeeItemDTO(Employee employee) {
        this(
                employee.getId(),
                employee.getName(),
                employee.getSeniority(),
                employee.getCpf(),
                employee.getPhone(),
                employee.getEmail(),
                employee.getBirthDate(),
                employee.getSalary(),
                new AddressDTO(employee.getAddress()),
                employee.getDepartment().getName(),
                employee.getPosition().getName(),
                employee.getTypeEmployee()
        );
    }
}

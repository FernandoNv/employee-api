package com.example.employee_api.employee;

import com.example.employee_api.address.AddressDTO;
import jakarta.validation.constraints.Null;

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
    public EmployeeItemDTO(Employee employee) {
        this(
                employee.getId(),
                employee.getName(),
                employee.getSeniority(),
                employee.getCpf(),
                employee.getPhone(),
                employee.getEmail(),
                employee.getBirthDate(),
                employee.getSalary(),
                employee.getTypeEmployee().equals(TypeEmployee.EMPLOYEE) ? new AddressDTO(employee.getAddress()) : null,
                employee.getTypeEmployee().equals(TypeEmployee.EMPLOYEE) ? employee.getDepartment().getName() : null,
                employee.getTypeEmployee().equals(TypeEmployee.EMPLOYEE) ? employee.getPosition().getName() : null,
                employee.getTypeEmployee()
        );
    }
}

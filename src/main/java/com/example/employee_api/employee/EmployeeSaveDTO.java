package com.example.employee_api.employee;

import com.example.employee_api.address.AddressSaveDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmployeeSaveDTO(
        @NotBlank
        String name,
        @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")
        String cpf,
        @NotNull
        LocalDate birthDate,
        @NotBlank
        @Email
        String email,
        @Pattern(regexp = "^\\(\\d{2}\\) \\d{4,5}-\\d{4}$")
        String phone,
        @NotNull
        @Valid
        AddressSaveDTO address,
        @NotNull
        Long department,
        @NotNull
        Long position,
        @NotNull
        Seniority seniority,
        @NotNull
        BigDecimal salary
) {
}

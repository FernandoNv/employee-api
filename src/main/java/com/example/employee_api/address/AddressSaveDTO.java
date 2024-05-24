package com.example.employee_api.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AddressSaveDTO(
        @NotBlank
        String address,
        @NotNull
        Integer number,
        @NotBlank
        String neighborhood,
        @NotBlank
        String city,
        @NotBlank
        String state,
        @NotBlank
        @Pattern(regexp = "^\\d{5}-\\d{3}$")
        String postalCode,
        String address2
) {
}

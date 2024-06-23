package com.example.employee_api.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SigninDTO(
        @NotBlank
        @Email
        String email
) {
}

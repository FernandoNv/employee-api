package com.example.employee_api.auth;

import com.example.employee_api.employee.Employee;
import com.example.employee_api.employee.EmployeeItemDTO;
import com.example.employee_api.employee.EmployeeService;
import com.example.employee_api.employee.TypeEmployee;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    private final EmployeeService employeeService;

    public AuthController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/signin", consumes = "application/json", produces = "application/json")
    public ResponseEntity<EmployeeItemDTO> signin(@RequestBody @Valid SigninDTO signinDTO) {
        Employee employee = employeeService.getByEmail(signinDTO.email());

        return ResponseEntity.ok(new EmployeeItemDTO(employee));
    }
}

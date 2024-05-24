package com.example.employee_api.employee.validations;

import com.example.employee_api.employee.EmployeeSaveDTO;

public interface EmployeeSaveValidation {
    void validate(EmployeeSaveDTO employee);
}

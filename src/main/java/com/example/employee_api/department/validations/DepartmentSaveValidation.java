package com.example.employee_api.department.validations;

import com.example.employee_api.department.DepartmentSaveDTO;

public interface DepartmentSaveValidation {
    void validate(DepartmentSaveDTO department);
}
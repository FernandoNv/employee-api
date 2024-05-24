package com.example.employee_api.employee.validations;

import com.example.employee_api.department.DepartmentRepository;
import com.example.employee_api.employee.EmployeeSaveDTO;
import jakarta.persistence.EntityNotFoundException;

public class EmployeeValidadeDepartment implements EmployeeSaveValidation {
    private final DepartmentRepository departmentRepository;

    EmployeeValidadeDepartment(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void validate(EmployeeSaveDTO employee) {
        if (!this.departmentRepository.existsById(employee.department())) {
            throw new EntityNotFoundException();
        }
    }
}

package com.example.employee_api.employee.validations;

import com.example.employee_api.department.DepartmentRepository;
import com.example.employee_api.employee.EmployeeSaveDTO;
import jakarta.persistence.EntityNotFoundException;

public class EmployeeValidatePosition implements EmployeeSaveValidation {
    private final DepartmentRepository departmentRepository;

    EmployeeValidatePosition(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void validate(EmployeeSaveDTO employee) {
        if (!departmentRepository.existsById(employee.department())) {
            throw new EntityNotFoundException();
        }

        departmentRepository.getPositionByIdAndDepartmentById(employee.position(), employee.department()).orElseThrow();
    }
}

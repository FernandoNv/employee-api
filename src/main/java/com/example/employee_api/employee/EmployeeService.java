package com.example.employee_api.employee;

import com.example.employee_api.department.Department;
import com.example.employee_api.department.DepartmentRepository;
import com.example.employee_api.department.Position;
import com.example.employee_api.employee.validations.EmployeeSaveValidation;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    private final List<EmployeeSaveValidation> validationsSave;

    EmployeeService(
            EmployeeRepository employeeRepository,
            DepartmentRepository departmentRepository,
            List<EmployeeSaveValidation> validationsSave
    ) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.validationsSave = validationsSave;
    }

    @Transactional
    public EmployeeItemDTO create(EmployeeSaveDTO employeeSaveDTO) {
        validationsSave.forEach(validation -> validation.validate(employeeSaveDTO));

        Employee employee = new Employee(employeeSaveDTO);
        Department department = departmentRepository.getReferenceById(employeeSaveDTO.department());
        Position position = departmentRepository
                .getPositionByIdAndDepartmentById(employeeSaveDTO.position(), employeeSaveDTO.department()).orElseThrow();
        employee.setDepartment(department);
        employee.setPosition(position);

        return new EmployeeItemDTO(employeeRepository.save(employee));
    }

    @Transactional
    public EmployeeItemDTO update(Long id, EmployeeSaveDTO employeeData) {
        Employee employee = employeeRepository.findByIdAndActiveTrue(id).orElseThrow();
        validationsSave.forEach(validation -> validation.validate(employeeData));

        Department department = departmentRepository.getReferenceById(employeeData.department());
        Position position = departmentRepository
                .getPositionByIdAndDepartmentById(employeeData.position(), employeeData.department()).orElseThrow();
        employee.setDepartment(department);
        employee.setPosition(position);

        employee.updateValues(employeeData);

        return new EmployeeItemDTO(employeeRepository.save(employee));
    }
}

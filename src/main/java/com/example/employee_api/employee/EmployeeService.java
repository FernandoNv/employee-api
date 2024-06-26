package com.example.employee_api.employee;

import com.example.employee_api.department.Department;
import com.example.employee_api.department.DepartmentRepository;
import com.example.employee_api.department.Position;
import com.example.employee_api.employee.validations.EmployeeSaveValidation;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Employee getById(Long id) {
        return employeeRepository.findByIdAndActiveTrue(id).orElseThrow();
    }

    public Employee getByEmail(String email) {
        return employeeRepository.findByEmailAndActiveTrue(email).orElseThrow();
    }

    @Transactional
    public EmployeeItemDTO create(EmployeeSaveDTO employeeSaveDTO) {
        Employee employee;
        if (employeeSaveDTO.typeEmployee().equals(TypeEmployee.EMPLOYEE)) {
            validationsSave.forEach(validation -> validation.validate(employeeSaveDTO));
            employee = new Employee(employeeSaveDTO);
            Department department = departmentRepository.getReferenceById(employeeSaveDTO.department());
            Position position = departmentRepository
                    .getPositionByIdAndDepartmentById(employeeSaveDTO.position(), employeeSaveDTO.department()).orElseThrow();
            employee.setDepartment(department);
            employee.setPosition(position);
        } else {
            employee = new Employee(employeeSaveDTO);
        }

        employee.setTypeEmployee(employeeSaveDTO.typeEmployee());
        return new EmployeeItemDTO(employeeRepository.save(employee));
    }

    @Transactional
    public EmployeeItemDTO update(Long id, EmployeeSaveDTO employeeData) {
        Employee employee = getById(id);
        if (employeeData.typeEmployee().equals(TypeEmployee.EMPLOYEE)) {
            validationsSave.forEach(validation -> validation.validate(employeeData));
            Department department = departmentRepository.getReferenceById(employeeData.department());
            Position position = departmentRepository
                    .getPositionByIdAndDepartmentById(employeeData.position(), employeeData.department()).orElseThrow();
            employee.setDepartment(department);
            employee.setPosition(position);
        }

        employee.updateValues(employeeData);

        return new EmployeeItemDTO(employeeRepository.save(employee));
    }

    public Page<EmployeeListITemDTO> getAllEmployee(Pageable pageable) {
        return employeeRepository.findAllByActiveTrue(pageable).map(EmployeeListITemDTO::new);
    }

    public Page<EmployeeListITemDTO> getAllManager(Pageable pageable) {
        return employeeRepository.findAllByActiveTrueAndTypeEmployeeManager(pageable).map(EmployeeListITemDTO::new);
    }
}

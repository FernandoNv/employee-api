package com.example.employee_api.department;

import com.example.employee_api.employee.EmployeeRepository;
import com.example.employee_api.department.Position;
import com.example.employee_api.department.PositionItemListDTO;
import com.example.employee_api.department.validations.DepartmentSaveValidation;
import com.example.employee_api.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final List<DepartmentSaveValidation> validationsSave;

    DepartmentService(
            EmployeeRepository employeeRepository,
            DepartmentRepository departmentRepository,
            List<DepartmentSaveValidation> validationsSave
    ) {
        this.departmentRepository = departmentRepository;
        this.validationsSave = validationsSave;
    }

    public Department getById(Long id) {
        return departmentRepository.findByIdAndActiveTrue(id).orElseThrow();
    }

    @Transactional
    public Department create(DepartmentSaveDTO departmentSaveDTO) {
        validationsSave.forEach(validation -> validation.validate(departmentSaveDTO));

        Department department = new Department(departmentSaveDTO);
        List<Position> positions = departmentSaveDTO.positions().stream().map(Position::new).toList();
        Employee manager = employeeRepository.findByIdAndActiveTrue(departmentSaveDTO.manager()).orElseThrow();
        department.setName(departmentSaveDTO.name());
        department.setManager(manager);
        department.setPositionList(positions);

        return departmentRepository.save(department);
    }

    @Transactional
    public Department update(Long id, DepartmentSaveDTO departmentData) {
        Department department = getById(id);
        validationsSave.forEach(validation -> validation.validate(departmentData));

        Employee manager = employeeRepository.findByIdAndActiveTrue(departmentData.manager()).orElseThrow();
        List<Position> positions = departmentData.positions();
        department.setName(departmentData.name());
        department.setManager(manager);
        department.setPositionList(positions);

        return departmentRepository.save(department);
    }
}
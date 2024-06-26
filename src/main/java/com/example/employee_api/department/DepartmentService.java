package com.example.employee_api.department;

import com.example.employee_api.employee.Employee;
import com.example.employee_api.employee.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }


    public List<Department> getAll() {
        return this.departmentRepository.findAllByActiveTrue();
    }

    @Transactional
    public DepartmentItemDTO create(DepartmentSaveDTO departmentSaveDTO) {
        Department department = new Department();
        department.setName(departmentSaveDTO.name());
        Employee employee = employeeRepository.getReferenceById(departmentSaveDTO.idManager());
        department.setManager(employee);

        List<Position> positions = departmentSaveDTO.positions().stream().map(p -> {
            Position position = new Position();
            position.setName(p.name());
            position.setDepartment(department);
            position.setActive(true);

            return position;
        }).toList();
        department.setPositionList(positions);
        department.setActive(true);

        Department departmentSaved = departmentRepository.save(department);

        return new DepartmentItemDTO(departmentSaved);
    }

    public Department getById(Long id) {
        return departmentRepository.findByIdAndActiveTrue(id).orElseThrow();
    }

    @Transactional
    public void delete(Long id) {
        Department department = getById(id);
        department.delete();
    }

    @Transactional
    public DepartmentItemDTO update(Long id, DepartmentSaveDTO departmentSaveDTO) {
        Department department = getById(id);
        department.update(departmentSaveDTO);

        if (departmentSaveDTO.idManager() != null && !Objects.equals(department.getManager().getId(), departmentSaveDTO.idManager())) {
            Employee employee = employeeRepository.getReferenceById(departmentSaveDTO.idManager());
            department.setManager(employee);
        }

        departmentRepository.save(department);

        return new DepartmentItemDTO(getById(department.getId()));
    }

}

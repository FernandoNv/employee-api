package com.example.employee_api.department;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {
    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<DepartmentItemListDTO>> getAll() {
        List<Department> departmentList = this.departmentRepository.findAllByActiveTrue();

        return ResponseEntity.ok(departmentList.stream().map(DepartmentItemListDTO::new).toList());
    }
}

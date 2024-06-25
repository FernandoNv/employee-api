package com.example.employee_api.department;


import jakarta.validation.Valid;
import jakarta.validation.Transactional;
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

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<DepartmentItemListDTO> create(
        @RequestBody @Valid DepartmentSaveDTO newDepartment,
         UriComponentsBuilder uriComponentsBuilder
         ) {
        DepartmentItemDTO departmentDTO = departmentService.create(newDepartment);

        URI uri = uriComponentsBuilder
                .path("/departments/{id}")
                .buildAndExpand(department.id())
                .toUri();
       
        return ResponseEntity.created(uri).body(departmentDTO);
    }
    
    GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<DepartmentItemDTO> getById(@PathVariable Long id) {
        Department department = departmentRepository.findByIdAndActiveTrue(id).orElseThrow();

        return ResponseEntity.ok(new DepartmentItemDTO(department));
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DepartmentItemDTO> update(
            @PathVariable Long id,
            @RequestBody @Valid DepartmentSaveDTO departmentData
    ) {
        DepartmentItemDTO departmentDTO = departmentService.update(id, departmentData);

        return ResponseEntity.ok(departmentDTO);
    }

    @Transactional
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Department department = departmentRepository.findByIdAndActiveTrue(id).orElseThrow();
        department.delete();

        return ResponseEntity.noContent().build();
    }

}

package com.example.employee_api.department;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<DepartmentItemListDTO>> getAll() {
        List<Department> departmentList = departmentService.getAll();

        return ResponseEntity.ok(departmentList.stream().map(DepartmentItemListDTO::new).toList());
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<DepartmentItemDTO> create(
            @RequestBody @Valid DepartmentSaveDTO departmentSaveDTO,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        DepartmentItemDTO departmentDTO = this.departmentService.create(departmentSaveDTO);

        URI uri = uriComponentsBuilder
                .path("/departments/{id}")
                .buildAndExpand(departmentDTO.id())
                .toUri();

        return ResponseEntity.created(uri).body(departmentDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        departmentService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DepartmentItemDTO> update(
            @PathVariable Long id,
            @RequestBody @Valid DepartmentSaveDTO departmentSaveDTO
    ) {
        DepartmentItemDTO departmentDTO = departmentService.update(id, departmentSaveDTO);

        return ResponseEntity.ok(departmentDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentItemDTO> getById(@PathVariable Long id) {
        DepartmentItemDTO departmentDTO = new DepartmentItemDTO(departmentService.getById(id));

        return ResponseEntity.ok(departmentDTO);
    }
}

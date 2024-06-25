package com.example.employee_api.employee;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Page<EmployeeListITemDTO>> getAll(
            @PageableDefault(size = 30, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<EmployeeListITemDTO> page = employeeService.getAllEmployee(pageable);

        return ResponseEntity.ok(page);
    }

    @GetMapping(value = "/managers", produces = "application/json")
    public ResponseEntity<Page<EmployeeListITemDTO>> getAllManagers(
            @PageableDefault(size = 30, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<EmployeeListITemDTO> page = employeeService.getAllManager(pageable);

        return ResponseEntity.ok(page);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<EmployeeItemDTO> getById(@PathVariable Long id) {
        Employee employee = employeeService.getById(id);

        return ResponseEntity.ok(new EmployeeItemDTO(employee));
    }

    @Transactional
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Employee employee = employeeService.getById(id);
        employee.delete();

        return ResponseEntity.noContent().build();
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<EmployeeItemDTO> create(
            @RequestBody @Valid EmployeeSaveDTO newEmployee,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        EmployeeItemDTO employeeDTO = employeeService.create(newEmployee);

        URI uri = uriComponentsBuilder
                .path("/employees/{id}")
                .buildAndExpand(employeeDTO.id())
                .toUri();

        return ResponseEntity.created(uri).body(employeeDTO);
    }

    @PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<EmployeeItemDTO> update(
            @PathVariable Long id,
            @RequestBody @Valid EmployeeSaveDTO employeeData
    ) {
        EmployeeItemDTO employeeDTO = employeeService.update(id, employeeData);

        return ResponseEntity.ok().body(employeeDTO);
    }
}

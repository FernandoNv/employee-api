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
    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Page<EmployeeListITemDTO>> getAll(
            @PageableDefault(size = 30, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<EmployeeListITemDTO> page = employeeRepository.findAllByActiveTrue(pageable).map(EmployeeListITemDTO::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<EmployeeItemDTO> getById(@PathVariable Long id) {
        Employee employee = employeeRepository.findByIdAndActiveTrue(id).orElseThrow();

        return ResponseEntity.ok(new EmployeeItemDTO(employee));
    }

    @Transactional
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Employee employee = employeeRepository.findByIdAndActiveTrue(id).orElseThrow();
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
                .path("/medicos/{id}")
                .buildAndExpand(employeeDTO.id())
                .toUri();

        return ResponseEntity.created(uri).body(employeeDTO);
    }

    @PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<EmployeeItemDTO> create(
            @PathVariable Long id,
            @RequestBody @Valid EmployeeSaveDTO employeeData
    ) {
        EmployeeItemDTO employeeDTO = employeeService.update(id, employeeData);

        return ResponseEntity.ok().body(employeeDTO);
    }
}

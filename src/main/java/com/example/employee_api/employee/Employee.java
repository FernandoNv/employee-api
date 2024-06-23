package com.example.employee_api.employee;

import com.example.employee_api.address.Address;
import com.example.employee_api.department.Department;
import com.example.employee_api.department.Position;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "Employee")
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cpf;
    private String phone;
    private String email;
    private LocalDate birthDate;
    private BigDecimal salary;
    private Boolean active;

    @Enumerated(EnumType.STRING)
    @ColumnDefault(value = "EMPLOYEE")
    private TypeEmployee typeEmployee;

    @Enumerated(EnumType.STRING)
    private Seniority seniority;

    @Embedded
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private Position position;

    public Employee(EmployeeSaveDTO employeeSaveDTO) {
        this.name = employeeSaveDTO.name();
        this.cpf = employeeSaveDTO.cpf();
        this.phone = employeeSaveDTO.phone();
        this.email = employeeSaveDTO.email();
        this.birthDate = employeeSaveDTO.birthDate();
        this.salary = employeeSaveDTO.salary();
        this.active = true;
        this.seniority = employeeSaveDTO.seniority();
        this.address = new Address(employeeSaveDTO.address());
    }

    public void delete() {
        this.active = false;
    }

    public void updateValues(EmployeeSaveDTO employeeSaveDTO) {
        if (employeeSaveDTO.name() != null) {
            this.name = employeeSaveDTO.name();
        }
        if (employeeSaveDTO.cpf() != null) {
            this.cpf = employeeSaveDTO.cpf();
        }
        if (employeeSaveDTO.phone() != null) {
            this.phone = employeeSaveDTO.phone();
        }
        if (employeeSaveDTO.email() != null) {
            this.email = employeeSaveDTO.email();
        }
        if (employeeSaveDTO.birthDate() != null) {
            this.birthDate = employeeSaveDTO.birthDate();
        }
        if (employeeSaveDTO.salary() != null) {
            this.salary = employeeSaveDTO.salary();
        }
        if (employeeSaveDTO.seniority() != null) {
            this.seniority = employeeSaveDTO.seniority();
        }
        if (employeeSaveDTO.address() != null) {
            this.address = new Address(employeeSaveDTO.address());
        }
        if (employeeSaveDTO.typeEmployee() != null) {
            this.typeEmployee = employeeSaveDTO.typeEmployee();
        }
    }
}

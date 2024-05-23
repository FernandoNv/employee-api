package com.example.employee_api.employee;

import com.example.employee_api.address.Address;
import com.example.employee_api.department.Department;
import com.example.employee_api.department.Position;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "Employee")
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
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
    private Seniority seniority;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
}

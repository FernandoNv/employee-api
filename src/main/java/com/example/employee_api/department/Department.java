package com.example.employee_api.department;

import com.example.employee_api.employee.Employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity(name = "Department")
@Table(name = "departments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean active;

    @OneToMany(mappedBy = "department")
    private List<Employee> employeeList;
    @OneToMany(mappedBy = "department")
    private List<Position> positionList;
    @OneToOne
    private Employee manager;
}

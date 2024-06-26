package com.example.employee_api.department;

import com.example.employee_api.employee.Employee;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Department")
@Table(name = "departments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean active;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employeeList;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Position> positionList;
    @OneToOne
    private Employee manager;

    public void delete() {
        active = false;
    }

    public void update(DepartmentSaveDTO departmentSaveDTO) {
        if (departmentSaveDTO.name() != null) {
            this.name = departmentSaveDTO.name();
        }
    }
}

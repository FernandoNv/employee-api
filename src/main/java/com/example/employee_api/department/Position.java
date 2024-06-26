package com.example.employee_api.department;

import com.example.employee_api.employee.Employee;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Position")
@Table(name = "positions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @OneToMany(mappedBy = "position")
    private List<Employee> employeeList;
}

package com.example.employee_api.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findAllByActiveTrue();

    @Query(value = """
                SELECT p FROM Department d
                JOIN d.positionList p
                WHERE p.id = :positionId AND d.id = :departmentId
            """)
    Optional<Position> getPositionByIdAndDepartmentById(Long positionId, Long departmentId);

    Optional<Department> findByIdAndActiveTrue(Long id);
}

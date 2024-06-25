package com.example.employee_api.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.nio.channels.FileChannel;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("""
                SELECT e FROM Employee e WHERE e.active = true AND e.typeEmployee = 'EMPLOYEE'
            """)
    Page<Employee> findAllByActiveTrueAndTypeEmployeeEmployee(Pageable pageable);

    Optional<Employee> findByIdAndActiveTrue(Long id);

    Optional<Employee> findByEmailAndActiveTrue(String id);

    @Query("""
                SELECT e FROM Employee e
                WHERE e.active = true
                    AND e.typeEmployee = 'MANAGER'
            """)
    Page<Employee> findAllByActiveTrueAndTypeEmployeeManager(Pageable pageable);
}

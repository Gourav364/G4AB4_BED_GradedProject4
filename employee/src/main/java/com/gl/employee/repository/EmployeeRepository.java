package com.gl.employee.repository;

import com.gl.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByFirstName(String firstname);

    List<Employee> findAllByOrderByFirstNameDesc();

    List<Employee> findAllByOrderByFirstNameAsc();
}

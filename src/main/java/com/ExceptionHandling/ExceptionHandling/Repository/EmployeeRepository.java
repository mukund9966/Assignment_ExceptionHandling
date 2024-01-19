package com.ExceptionHandling.ExceptionHandling.Repository;

import com.ExceptionHandling.ExceptionHandling.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

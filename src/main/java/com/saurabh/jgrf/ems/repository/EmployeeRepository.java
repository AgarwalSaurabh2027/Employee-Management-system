package com.saurabh.jgrf.ems.repository;

import com.saurabh.jgrf.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}

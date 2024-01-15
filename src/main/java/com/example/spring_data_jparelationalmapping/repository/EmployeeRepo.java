package com.example.spring_data_jparelationalmapping.repository;

import com.example.spring_data_jparelationalmapping.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}

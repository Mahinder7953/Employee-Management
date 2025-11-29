package com.example.employees.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employees.management.entity.employee;

@Repository
public interface employeeRepository extends JpaRepository<employee,Long>{

}

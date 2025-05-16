package com.example.employees.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employees.management.entity.employee;
import com.example.employees.management.repository.employeeRepository;

@Service
public class employeeService {
    @Autowired
    private employeeRepository employeeRepo;

    public List<employee> getEmployees() {
        return employeeRepo.findAll();
    }

    public void addEmployee(employee newEmployee) {
        employeeRepo.save(newEmployee);
    }

    public employee updateForm(Long id) {
        return employeeRepo.findById(id).get();
    }

    public void updateEmployee(employee updateData, Long id) {
        employee emp = employeeRepo.findById(id).get();
        emp.setName(updateData.getName());
        emp.setRole(updateData.getRole());
        emp.setSalary(updateData.getSalary());
        employeeRepo.save(emp);
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

}

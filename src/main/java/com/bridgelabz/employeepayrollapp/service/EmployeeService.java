package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    // Retrieve all employees
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // Retrieve employee by ID
    public Employee getEmployeeById(int id) {
        Optional<Employee> employeeOptional = repository.findById(id);
        return employeeOptional.orElse(null);
    }

    // Create a new employee
    public Employee createEmployee(EmployeeDTO dto) {
        Employee emp = new Employee();
        emp.setName(dto.getName());       // Manual getter used here
        emp.setSalary(dto.getSalary());
        return repository.save(emp);
    }

    // Update an existing employee
    public Employee updateEmployee(int id, EmployeeDTO dto) {
        Optional<Employee> employeeOptional = repository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee emp = employeeOptional.get();
            emp.setName(dto.getName());   // Manual getter used here
            emp.setSalary(dto.getSalary());
            return repository.save(emp);
        }
        return null;
    }

    // Delete an employee
    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }
}
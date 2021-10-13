package com.example.springboot.service.impl;

import com.example.springboot.model.Employee;
import com.example.springboot.repository.IEmployeeRepository;
import com.example.springboot.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        //Employee savedEmployee = employeeRepository.save(employee);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public String deleteEmployee(Integer id) {
       String status = null;
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            employeeRepository.delete(employee.get());
            status = "Employee deleted successfully";
        }
        else {
            status ="Employee not exist";
        }
        return status;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}

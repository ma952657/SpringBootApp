package com.example.springboot.service;

import com.example.springboot.model.Employee;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {

    Employee addEmployee(Employee emp);
    Employee updateEmployee(Employee emp);
    Employee getEmployeeById(Integer id);
    String deleteEmployee(Integer id);
    List<Employee> getAllEmployees();

}

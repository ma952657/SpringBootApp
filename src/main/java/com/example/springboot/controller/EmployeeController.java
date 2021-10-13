package com.example.springboot.controller;

import com.example.springboot.service.IEmployeeService;
import com.example.springboot.model.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(
        value = "/api/v1",
        protocols = "http",
        tags = "employee"
)
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/employee/{id}")
    @ApiOperation(value = "Get an Emp Detail")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);

    }

   @PostMapping("/employee")
   @ApiOperation(value = "Create a new Employee ")
   public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
       return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);

   }

    @PutMapping("/employee")
    @ApiOperation(value = "Update an existing Employee ")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);

    }

    @DeleteMapping("/employee")
    @ApiOperation(value = "delete an Employee")
    public ResponseEntity<String> deleteEmployee(@RequestParam Integer id){
        return new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatus.OK);
    }

    @GetMapping("/employees")
    @ApiOperation(value = "Get All Employees")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
    }

}

package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.EmployeeService;
import com.example.bo.Employee;
import com.example.bo.EmployeeDTO;


@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping()
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping()
    public boolean updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping()
    public boolean deleteEmployee(@RequestParam("id") int id) {
        return employeeService.deleteEmployee(id);
    }

    @GetMapping()
    public List<EmployeeDTO> getAllEmployee() {
        return employeeService.getAllEMployee();
    }

    @GetMapping("/getEmployeeById")
    public EmployeeDTO getEmployeeById(@RequestParam("id") int id) {
        return employeeService.getById(id);
    }

}

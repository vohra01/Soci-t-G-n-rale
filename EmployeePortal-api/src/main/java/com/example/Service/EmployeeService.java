package com.example.Service;

import com.example.bo.Employee;
import com.example.bo.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<EmployeeDTO> getAllEMployee();

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(int id);

    EmployeeDTO getById(int id);
}

package com.example.Service;

import com.example.bo.Employee;
import com.example.bo.EmployeeDTO;
import com.example.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEMployee() {
        List<Employee> emp = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        for (Employee e : emp) {
            employeeDTOs.add(getEmployeeDTO(e));
        }
        return employeeDTOs;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        Employee emp = employeeRepository.save(employee);
        return true;
    }

    @Override
    public boolean deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        return true;
    }

    @Override
    public EmployeeDTO getById(int id) {
        Employee e = employeeRepository.findById(id).get();
        return getEmployeeDTO(e);
    }

    public EmployeeDTO getEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setFname(employee.getFname());
        employeeDTO.setLname(employee.getLname());
        employeeDTO.setDepartment(employee.getDepartment());
        employeeDTO.setGender(employee.getGender());

        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
        employeeDTO.setDob(formatter.format(employee.getDob()));

        return employeeDTO;
    }
}

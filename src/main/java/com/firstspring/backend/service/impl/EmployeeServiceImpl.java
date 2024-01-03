package com.firstspring.backend.service.impl;

import com.firstspring.backend.exception.ResourceNotFoundException;
import com.firstspring.backend.mapper.EmployeeMapper;
import com.firstspring.backend.dto.EmployeeDTO;
import com.firstspring.backend.entity.Employee;
import com.firstspring.backend.repository.EmployeeRepository;
import com.firstspring.backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployee(Long employeeID) {
        Employee employee = employeeRepository.findById(employeeID)
                .orElseThrow(() -> new ResourceNotFoundException("Doesn't exist an employee with the given ID: " + employeeID));
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDTO(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Long employeeID, EmployeeDTO updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeID)
                .orElseThrow(() -> new ResourceNotFoundException("Doesn't exist an employee with the given ID: " + employeeID));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmp = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDTO(updatedEmp);
    }

    @Override
    public void deleteEmployee(Long employeeID) {
        getEmployee(employeeID);

        employeeRepository.deleteById(employeeID);
    }


}

package com.firstspring.backend.service;

import com.firstspring.backend.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployee(Long employeeID);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployee(Long employeeID, EmployeeDTO updatedEmployee);

    void deleteEmployee(Long employeeID);
}

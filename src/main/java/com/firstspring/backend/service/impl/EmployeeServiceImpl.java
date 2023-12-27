package com.firstspring.backend.service.impl;

import com.firstspring.backend.mapper.EmployeeMapper;
import com.firstspring.backend.dto.EmployeeDTO;
import com.firstspring.backend.entity.Employee;
import com.firstspring.backend.repository.EmployeeRepository;
import com.firstspring.backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}

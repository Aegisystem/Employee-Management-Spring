package com.firstspring.backend.controller;

import com.firstspring.backend.dto.EmployeeDTO;
import com.firstspring.backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO>  getEmployeeByID(@PathVariable("id") Long employeeID) {
        EmployeeDTO foundEmployee = employeeService.getEmployee(employeeID);
        return ResponseEntity.ok(foundEmployee);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long employeeID,
                                                      @RequestBody EmployeeDTO updatedEmployee) {
        EmployeeDTO employee = employeeService.updateEmployee(employeeID, updatedEmployee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeID) {
        employeeService.deleteEmployee(employeeID);
        return ResponseEntity.ok("Employee deleted succesfully");
    }
}


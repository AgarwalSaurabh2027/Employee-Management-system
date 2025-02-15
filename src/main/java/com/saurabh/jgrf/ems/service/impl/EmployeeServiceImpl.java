package com.saurabh.jgrf.ems.service.impl;

import com.saurabh.jgrf.ems.dto.EmployeeDto;
import com.saurabh.jgrf.ems.entity.Employee;
import com.saurabh.jgrf.ems.exception.ResourceNotFoundException;
import com.saurabh.jgrf.ems.mapper.EmployeeMapper;
import com.saurabh.jgrf.ems.repository.EmployeeRepository;
import com.saurabh.jgrf.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployeee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployeee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee doesn't exist with given id : " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((emp) -> EmployeeMapper.mapToEmployeeDto(emp)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () ->
                        new ResourceNotFoundException("Employee Id doesn't exist : " + employeeId)
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);

    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee =employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException(" Unable to find employee "+employeeId)
        );
        employeeRepository.delete(employee);
    }
}

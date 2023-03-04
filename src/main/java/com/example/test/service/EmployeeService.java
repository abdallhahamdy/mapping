package com.example.test.service;

import com.example.test.dao.EmployeeRepository;
import com.example.test.dto.EmployeeDto;
import com.example.test.entity.Employee;
import com.example.test.entity.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeDto saveEmployee(EmployeeDto employeeDto){

        Employee employee = employeeMapper.dtoToEntity(employeeDto);

        EmployeeDto dto = employeeMapper.entityToDto(employeeRepository.save(employee));

        return dto;

    }

    public List<EmployeeDto> findEmployee() {

        List<EmployeeDto> employeeDto = employeeMapper.entityToDto(employeeRepository.findAll());

        return employeeDto;
    }

    public EmployeeDto findEmployeeId(Long id) {
        EmployeeDto dto = employeeMapper.entityToDto(employeeRepository.findById(id).orElseThrow());

        return dto;
    }

    public Employee findById (Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee save (Employee employee) {
        return employeeRepository.save(employee);
    }
}

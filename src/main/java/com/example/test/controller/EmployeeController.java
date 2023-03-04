package com.example.test.controller;

import com.example.test.dao.EmployeeRepository;
import com.example.test.dto.EmployeeDto;
import com.example.test.entity.Employee;
import com.example.test.entity.mapper.EmployeeMapper;
import com.example.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/insert")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){

        return ResponseEntity.ok(employeeService.saveEmployee(employeeDto));

    }

    @GetMapping("")
    public ResponseEntity<List<EmployeeDto>> findAllEmployee() {

        return ResponseEntity.ok(employeeService.findEmployee());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> findByIdEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findEmployeeId(id));
    }

    @PutMapping("/edit")
    public ResponseEntity<EmployeeDto> update (@RequestBody EmployeeDto employeeDto) {

        Employee employee = employeeService.findById(employeeDto.getId());

        Employee mappedEmployee = employeeMapper.entityToUpdate(employeeDto, employee);

        EmployeeDto employeeDto1 = employeeMapper.entityToDto(employeeService.save(mappedEmployee));

        return new ResponseEntity<EmployeeDto> ( employeeDto1, HttpStatus.OK);

    }

}

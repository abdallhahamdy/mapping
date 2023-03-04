package com.example.test.entity.mapper;

import com.example.test.dto.EmployeeDto;
import com.example.test.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(source = "employeeEntity.name", target = "employeeName", defaultValue = "employeeName")
    EmployeeDto entityToDto (Employee employeeEntity);

    List<EmployeeDto> entityToDto (List<Employee> employeeEntity);

    @Mapping(source = "employeeDto.employeeName", target = "name", defaultValue = "employeeName")
    Employee dtoToEntity (EmployeeDto employeeDto);

    @Mapping(source = "employeeDto.employeeName", target = "name")
    Employee entityToUpdate (EmployeeDto employeeDto, @MappingTarget Employee employee);

}

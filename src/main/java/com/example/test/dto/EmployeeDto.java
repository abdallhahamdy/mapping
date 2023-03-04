package com.example.test.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Setter
@Getter
public class EmployeeDto {

    @Id
    private Long id;

    private String employeeName;

    private Long salary;

}

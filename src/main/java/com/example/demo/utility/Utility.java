package com.example.demo.utility;

import com.example.demo.DTO.RequestDto;
import com.example.demo.repository.EmployeeDetails;
import org.springframework.stereotype.Component;

@Component
public class Utility {

    public EmployeeDetails mapDtoToEntity(RequestDto requestDto) {
        EmployeeDetails EmployeeDetailsEntity = new EmployeeDetails();
        EmployeeDetailsEntity.setId(requestDto.getEmployeeId());
        EmployeeDetailsEntity.setEmployeeName(requestDto.getName());
        EmployeeDetailsEntity.setPod(requestDto.getPod());
        EmployeeDetailsEntity.setUnit(requestDto.getUnit());
        EmployeeDetailsEntity.setEmployeeLocation(requestDto.getLocation());
        return EmployeeDetailsEntity;
    }
}
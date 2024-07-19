package com.example.demo.service;

import com.example.demo.DTO.RequestDto;
import com.example.demo.DTO.ResponseDto;

import com.example.demo.repository.EmployeeDetails;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;



    @Autowired
    private Utility utility;

    public ResponseDto employeeService(Map<String, Object> requestMap) {
        String operation = (String) requestMap.get("operation");
        RequestDto requestDto = (RequestDto) requestMap.get("RequestDto");
        ResponseDto responseDto = new ResponseDto();

        switch (operation.toUpperCase()) {
            case "ADD" -> {
                EmployeeDetails employeeDetailsEntity = utility.mapDtoToEntity(requestDto);
                employeeRepository.save(employeeDetailsEntity);
            }
            default -> throw new IllegalArgumentException("Unsupported operation: " + operation);
        }

        responseDto.setMessage("Successfully Added the record");
        responseDto.setCode("success");
        return responseDto;
    }
}
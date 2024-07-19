package com.example.demo.controller;

import com.example.demo.DTO.RequestDto;
import com.example.demo.DTO.ResponseDto;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("v1")
public class Controller {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> controllerClass(@RequestBody RequestDto requestDto){
        Map<String,Object>requestMap=new HashMap<String,Object>();
        requestMap.put("operation","add");
        requestMap.put("RequestDto",requestDto);

        ResponseDto responseDto =employeeService.employeeService(requestMap);
        return ResponseEntity.ok(responseDto);

    }

}

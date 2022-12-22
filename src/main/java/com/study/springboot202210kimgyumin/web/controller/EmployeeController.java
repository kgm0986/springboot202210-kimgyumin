package com.study.springboot202210kimgyumin.web.controller;

import com.study.springboot202210kimgyumin.service.EmployeeService;
import com.study.springboot202210kimgyumin.service.OptionService;
import com.study.springboot202210kimgyumin.web.dto.CMRespDto;
import com.study.springboot202210kimgyumin.web.dto.CategoryDto;
import com.study.springboot202210kimgyumin.web.dto.EmpDto;
import com.study.springboot202210kimgyumin.web.dto.UserDto;
import com.study.springboot202210kimgyumin.web.exception.CustomTestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

    @RestController
    @RequestMapping("/api")
public class EmployeeController {

        @Autowired
        private EmployeeService employeeService;

    @PostMapping("/emp")
    public ResponseEntity<?> addEmployee(@RequestBody EmpDto empDto) {

        if(empDto.getEmpName().isBlank()) {
            Map<String,String> errorMap = new HashMap<>();
            errorMap.put("username","아이디를 입력하세요");

            throw  new CustomTestException("유효성검사실패",errorMap);
        }
        empDto.setEmpId(201);
        return ResponseEntity.created(null).body(new CMRespDto<>("직원등록완료",employeeService.addEmployee(empDto)));
    }
}

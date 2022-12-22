package com.study.springboot202210kimgyumin.service;

import com.study.springboot202210kimgyumin.repository.EmployeeRepository;
import com.study.springboot202210kimgyumin.web.dto.CategoryDto;
import com.study.springboot202210kimgyumin.web.dto.EmpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public int addEmployee(EmpDto empDto) {

        //System.out.println("데이터베이스에 insert전: " + categoryDto);
        employeeRepository.saveEmployee(empDto);
       // System.out.println("데이터베이스에 insert후: " + categoryDto);
        return employeeRepository.saveEmployee(empDto) > 0 ? empDto.getEmpId() : 0;
    }

}

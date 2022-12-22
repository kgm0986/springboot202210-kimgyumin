package com.study.springboot202210kimgyumin.repository;

import com.study.springboot202210kimgyumin.web.dto.EmpDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EmployeeRepository {
    public int saveEmployee(EmpDto empDto);
}

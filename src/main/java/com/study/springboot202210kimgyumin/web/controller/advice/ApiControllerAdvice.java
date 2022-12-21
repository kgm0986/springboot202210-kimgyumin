package com.study.springboot202210kimgyumin.web.controller.advice;


import com.study.springboot202210kimgyumin.web.dto.CMRespDto;
import com.study.springboot202210kimgyumin.web.exception.CustomTestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {
    @ExceptionHandler(CustomTestException.class)
    public ResponseEntity<?> testExcption(CustomTestException e) {
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(),e.getErrorMap()));
    }
}

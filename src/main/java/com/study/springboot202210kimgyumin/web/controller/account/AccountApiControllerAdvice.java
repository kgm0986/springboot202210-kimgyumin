package com.study.springboot202210kimgyumin.web.controller.account;

import com.study.springboot202210kimgyumin.web.dto.CMRespDto;
import com.study.springboot202210kimgyumin.web.exception.CustomDuplicateUsernameException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AccountApiControllerAdvice {

    @ExceptionHandler(CustomDuplicateUsernameException.class)
    public ResponseEntity<?> duplicateError(CustomDuplicateUsernameException e ){
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), e.getErrorMap()));
    }
}

package com.study.springboot202210kimgyumin.web.controller;

import com.study.springboot202210kimgyumin.web.dto.UserDto;
import com.study.springboot202210kimgyumin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/db/test")
public class DBTestController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        int userId = userService.addUser(userDto);
       // return new ResponseEntity<>("응답할 데이터", HttpStatus.OK);
       // return ResponseEntity.created(null).body(userService.addUser(userDto));
        return  ResponseEntity.created(URI.create("/api/db/test/user/"+userId)).body(userDto);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUser(@PathVariable int userId) {
        UserDto userDto = userService.getUser(userId);
        return ResponseEntity.ok().body(userDto);
    }
}

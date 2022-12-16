package com.study.springboot202210kimgyumin.web.controller;

import com.study.springboot202210kimgyumin.web.dto.UserDto;
import com.study.springboot202210kimgyumin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/db/test")
public class DBTestController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
        return ResponseEntity.created(null).body(true);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUser(@PathVariable int userId) {
        UserDto userDto = userService.getUser(userId);
        return ResponseEntity.ok().body(null);
    }
}

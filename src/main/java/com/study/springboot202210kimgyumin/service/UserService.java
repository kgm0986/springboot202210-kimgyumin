package com.study.springboot202210kimgyumin.service;

import com.study.springboot202210kimgyumin.web.dto.UserDto;
import com.study.springboot202210kimgyumin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public int addUser(UserDto userDto) {
        int userId=0;
        System.out.println("데이터베이스에 insert전: " + userDto);
        userRepository.saveUser(userDto);
        System.out.println("데이터베이스에 insert후: " + userDto);

        return userDto.getUserId();
    }

    public UserDto getUser(int userId) {
        UserDto userDto = null;
        userDto = userRepository.findUserByUserId(userId);
        return userDto;
    }
}

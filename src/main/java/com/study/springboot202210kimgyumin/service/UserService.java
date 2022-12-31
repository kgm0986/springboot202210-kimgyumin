package com.study.springboot202210kimgyumin.service;

import com.study.springboot202210kimgyumin.web.dto.UserDto;
import com.study.springboot202210kimgyumin.repository.UserRepository;
import com.study.springboot202210kimgyumin.web.exception.CustomDuplicateUsernameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    public void duplicateUsername(String username) {
        UserDto userDto = userRepository.findUserByUsername(username);
        if(userDto != null) {
            Map<String,String> errorMap = new HashMap<>();
            errorMap.put("duplicate", "이미존재하는 사용자 이름입니다");
            throw new CustomDuplicateUsernameException("Duplicate username!!!",errorMap);
        }
    }
}

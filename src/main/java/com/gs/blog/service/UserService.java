package com.gs.blog.service;

import com.gs.blog.dto.UserDTO;
import com.gs.blog.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    public boolean login(UserDTO userDTO){

        boolean loginResult = false;

        try {

            String inputPassword = userDTO.getPassword();
            String encodePassword = userMapper.login(userDTO);

            loginResult =  passwordEncoder.matches(inputPassword, encodePassword);

        } catch (Exception e){

        }

        return loginResult;
    }

    public void register(UserDTO userDTO) {

        try {

            String notEncodePassword = userDTO.getPassword();
            String encodePassword = passwordEncoder.encode(notEncodePassword);

            userDTO.setPassword(encodePassword);

            userMapper.register(userDTO);

        } catch (Exception e){

        }
    }
}

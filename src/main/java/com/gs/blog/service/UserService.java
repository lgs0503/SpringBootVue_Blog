package com.gs.blog.service;

import com.gs.blog.dto.UserDTO;
import com.gs.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final String PASSWORD_NULL_CHK = "";
    private static final int ID_CHECK_FLAG = 0;
    private static final boolean ID_CHECK_RESULT_OK = true;
    private static final boolean ID_CHECK_RESULT_FAIL = false;

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
            System.out.println(e.getMessage());
        }

        return loginResult;
    }

    public void register(UserDTO userDTO) {

        try {

            userPasswordEncoder(userDTO);

            userMapper.register(userDTO);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public boolean idCheck(UserDTO userDTO) {
        boolean idCheckResult = ID_CHECK_RESULT_OK;

        try {

            int idCheck = userMapper.idCheck(userDTO);

            if (idCheck > ID_CHECK_FLAG) idCheckResult = ID_CHECK_RESULT_FAIL;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return idCheckResult;
    }

    public void updateUser(UserDTO userDTO) {
        try {
            userPasswordEncoder(userDTO);

            userMapper.updateUser(userDTO);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteUser(UserDTO userDTO) {
        try {
            userMapper.deleteUser(userDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<UserDTO> getUser(UserDTO userDTO) {

        List<UserDTO> result = new ArrayList<UserDTO>();

        try {
            result = userMapper.getUser(userDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public int getUserCount(UserDTO userDTO) {
        int result = 0;

        try {
            result = userMapper.getUserCount(userDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    private void userPasswordEncoder(UserDTO userDTO) {

        String notEncodePassword = userDTO.getPassword() != null ?
                userDTO.getPassword() : PASSWORD_NULL_CHK;

        if(notEncodePassword.equals(PASSWORD_NULL_CHK)) return;

        String encodePassword = passwordEncoder.encode(notEncodePassword);

        userDTO.setPassword(encodePassword);
    }
}

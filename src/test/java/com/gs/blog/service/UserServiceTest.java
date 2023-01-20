package com.gs.blog.service;

import com.gs.blog.dto.UserDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    @DisplayName("로그인")
    void login() {

        UserDTO loginUser = new UserDTO();

        loginUser.setId("admin123");
        loginUser.setPassword("123123");

        boolean loginResult = userService.login(loginUser);

        System.out.println("loginResult : " + loginResult);

        assertEquals(loginResult, true);

    }

    @Test
    @DisplayName("회원가입")
    void register() {


        UserDTO regiUser = new UserDTO();

        regiUser.setId("admin123");
        regiUser.setPassword("123123");
        regiUser.setName("어드민");
        regiUser.setNickName("어드민");
        regiUser.setBirthday("19950531");
        regiUser.setGender("1");
        regiUser.setEmail("test@gmail.com");
        regiUser.setAddress("테스트주소");
        regiUser.setAddressDetail("테스트주소상세");
        regiUser.setPhoneNum("01012345678");
        //regiUser.setImageFileNo(0);
        regiUser.setCreateUser("admin");
        regiUser.setCreateDate(LocalDate.now().toString());
        regiUser.setUpdateUser("admin");
        regiUser.setUpdateDate(LocalDate.now().toString());

        userService.register(regiUser);

    }
}
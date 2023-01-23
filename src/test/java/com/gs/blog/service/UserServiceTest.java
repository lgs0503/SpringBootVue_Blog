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
        loginUser.setPassword("123123123");

        boolean loginResult = userService.login(loginUser);

        System.out.println("loginResult : " + loginResult);

        assertEquals(loginResult, true);

    }

    @Test
    @DisplayName("회원가입")
    void register() {

        UserDTO regiUser = new UserDTO();

        regiUser.setId("deleteTest");
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

    @Test
    @DisplayName("계정 중복체크")
    void idCheck() {
        /** 중복 계정 없음 **/
        UserDTO userDTOOk = new UserDTO();
        userDTOOk.setId("admin123123");

        boolean resultOk = userService.idCheck(userDTOOk);

        System.out.println("resultOk : " +  resultOk);

        assertEquals(resultOk, true);

        /** 중복 계정 있음 **/
        UserDTO userDTOFail = new UserDTO();
        userDTOFail.setId("admin123");

        boolean resultFail = userService.idCheck(userDTOFail);

        System.out.println("resultFail : " +  resultFail);
        assertEquals(resultFail, false);
    }

    @Test
    @DisplayName("유저정보 업데이트")
    void updateUser() {
        UserDTO userDTO = new UserDTO();

        userDTO.setId("admin123");

        userDTO.setPassword("123123123");
        userDTO.setName("어드민22");
        userDTO.setNickName("어드민33");
        userDTO.setBirthday("19950531");
        userDTO.setGender("1");
        userDTO.setEmail("test@gmail.com");
        userDTO.setAddress("테스트주소");
        userDTO.setAddressDetail("테스트주소상세");
        userDTO.setPhoneNum("01012345678");
        userDTO.setUpdateUser("admin");
        userDTO.setUpdateDate(LocalDate.now().toString());

        userService.updateUser(userDTO);
    }

    @Test
    @DisplayName("유저정보 삭제")
    void deleteUser() {

        /** 삭제할 테스트 데이터 추가 **/
        System.out.println("1.삭제할 테스트 데이터 추가");
        UserDTO regiUser = new UserDTO();

        regiUser.setId("delete123");
        regiUser.setPassword("123123");
        regiUser.setName("어드민");
        regiUser.setNickName("어드민");
        regiUser.setBirthday("19950531");
        regiUser.setGender("1");
        regiUser.setEmail("test@gmail.com");
        regiUser.setAddress("테스트주소");
        regiUser.setAddressDetail("테스트주소상세");
        regiUser.setPhoneNum("01012345678");
        regiUser.setCreateUser("admin");
        regiUser.setCreateDate(LocalDate.now().toString());
        regiUser.setUpdateUser("admin");
        regiUser.setUpdateDate(LocalDate.now().toString());

        userService.register(regiUser);

        /** 삭제할 데이터 추가되었는지 확인 **/
        System.out.println("2. 삭제할 데이터 추가되었는지 확인");
        UserDTO loginUser = new UserDTO();

        loginUser.setId("delete123");
        loginUser.setPassword("123123");

        userService.login(loginUser);

        /** 삭제할 테스트 데이터 삭제 **/
        System.out.println("3. 삭제할 테스트 데이터 삭제 ");
        UserDTO userDTO = new UserDTO();
        userDTO.setId("delete123");

        userService.deleteUser(userDTO);
        
        /** 데이터가 잘 삭제되었는지 확인 **/
        System.out.println("4. 데이터가 잘 삭제되었는지 확인 ");
        loginUser.setId("delete123");
        loginUser.setPassword("123123");

        userService.login(loginUser);
    }
}
package com.gs.blog.controller;

import com.gs.blog.common.ResponseMessage;
import com.gs.blog.dto.UserDTO;
import com.gs.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public ResponseEntity login(@RequestParam String id, @RequestParam String password){
        ResponseMessage responseMessage = new ResponseMessage();

        responseMessage.getMessage().setMessage("login Success");

        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setPassword(password);

        responseMessage.getMessage().setData(userService.login(userDTO));

        return responseMessage.getResponse();
    }

    @PostMapping
    public ResponseEntity register(@RequestBody UserDTO userDTO){
        ResponseMessage responseMessage = new ResponseMessage();

        userService.register(userDTO);

        responseMessage.getMessage().setMessage("register Success");

        return responseMessage.getResponse();
    }
}

package com.gs.blog.controller;

import com.gs.blog.common.ResponseMessage;
import com.gs.blog.dto.UserDTO;
import com.gs.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/signIn")
    public ResponseEntity login(@RequestParam String id, @RequestParam String password){
        ResponseMessage responseMessage = new ResponseMessage();

        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setPassword(password);

        responseMessage.getMessage().setData(userService.login(userDTO));
        responseMessage.getMessage().setMessage("login Success");

        return responseMessage.getResponse();
    }

    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody UserDTO userDTO){
        ResponseMessage responseMessage = new ResponseMessage();

        userService.register(userDTO);

        responseMessage.getMessage().setMessage("register Success");

        return responseMessage.getResponse();
    }

    @GetMapping("/duplicateCheck")
    public ResponseEntity duplicateCheck(@RequestParam String id) {
        ResponseMessage responseMessage = new ResponseMessage();

        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);

        responseMessage.getMessage().setData(userService.idCheck(userDTO));
        responseMessage.getMessage().setMessage("duplicateCheck Success");

        return responseMessage.getResponse();
    }

    @PatchMapping
    public ResponseEntity updateUser(@RequestBody UserDTO userDTO) {
        ResponseMessage responseMessage = new ResponseMessage();

        userService.updateUser(userDTO);

        responseMessage.getMessage().setMessage("updateUser Success");

        return responseMessage.getResponse();
    }

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestBody UserDTO userDTO) {
        ResponseMessage responseMessage = new ResponseMessage();

        userService.deleteUser(userDTO);

        responseMessage.getMessage().setMessage("deleteUser Success");

        return responseMessage.getResponse();
    }
}

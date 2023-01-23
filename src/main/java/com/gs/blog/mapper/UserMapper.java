package com.gs.blog.mapper;

import com.gs.blog.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    String login(UserDTO userDTO);

    void register(UserDTO userDTO);

    int idCheck(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUser(UserDTO userDTO);
}

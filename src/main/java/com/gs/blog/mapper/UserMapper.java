package com.gs.blog.mapper;

import com.gs.blog.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    String login(UserDTO userDTO);

    void register(UserDTO userDTO);

    int idCheck(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUser(UserDTO userDTO);

    List<UserDTO> getUser(UserDTO userDTO);

    int getUserCount(UserDTO userDTO);
}

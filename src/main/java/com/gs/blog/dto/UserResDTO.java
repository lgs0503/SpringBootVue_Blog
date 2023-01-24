package com.gs.blog.dto;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class UserResDTO {

    private Map<String, Object> resultUser = new HashMap<String, Object>();

    public UserResDTO(List<UserDTO> list, int count){
        resultUser.put("list", list);
        resultUser.put("count", count);
    }
}

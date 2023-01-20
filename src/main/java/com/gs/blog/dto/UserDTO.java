package com.gs.blog.dto;

import com.gs.blog.common.CommonDTO;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO extends CommonDTO {
    private int idx;
    private String id;
    private String password;
    private String name;
    private String nickName;
    private String birthday;
    private String gender;
    private String email;
    private String address;
    private String addressDetail;
    private String phoneNum;
    private int imageFileNo;
}

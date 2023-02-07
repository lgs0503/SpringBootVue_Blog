package com.gs.blog.common;

import com.gs.blog.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Message {

    private StatusEnum status;
    private String message;
    private Object data;

    public Message() {
        this.status = StatusEnum.BAD_REQUEST;
        this.data = null;
        this.message = null;
    }
}
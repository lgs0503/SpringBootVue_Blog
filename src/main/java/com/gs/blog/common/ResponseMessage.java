package com.gs.blog.common;

import com.gs.blog.enums.StatusEnum;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.nio.charset.Charset;

@Getter
public class ResponseMessage {

    private HttpHeaders headers= new HttpHeaders();

    Message message = new Message();

    public ResponseMessage(){

        message.setStatus(StatusEnum.OK);
        message.setMessage("Success");

        headers.setContentType(
                new MediaType(
                        "application",
                        "json",
                        Charset.forName("UTF-8")
                )
        );
    }

    public ResponseEntity<Message> getResponse(){
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }
}

package com.gs.blog.controller;

import com.gs.blog.common.ResponseMessage;
import com.gs.blog.dto.PostDTO;
import com.gs.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public ResponseEntity createPost(@RequestBody PostDTO postDTO){
        ResponseMessage responseMessage = new ResponseMessage();

        postService.createPost(postDTO);

        responseMessage.getMessage().setMessage("createPost Success");

        return responseMessage.getResponse();
    }

    @GetMapping
    public ResponseEntity getPostList(@RequestParam String title, @RequestParam String createUser) {
        ResponseMessage responseMessage = new ResponseMessage();

        PostDTO postDTO = new PostDTO();
        postDTO.setTitle(title);
        postDTO.setCreateUser(createUser);

        List<PostDTO> postList = postService.getPostList(postDTO);

        responseMessage.getMessage().setData(postList);
        responseMessage.getMessage().setMessage("getPostList Success");

        return responseMessage.getResponse();
    }

    @PatchMapping
    public ResponseEntity updatePost(@RequestBody PostDTO postDTO) {
        ResponseMessage responseMessage = new ResponseMessage();

        postService.updatePost(postDTO);

        responseMessage.getMessage().setMessage("updatePost Success");

        return responseMessage.getResponse();
    }

    @DeleteMapping
    public ResponseEntity deletePost(@RequestBody PostDTO postDTO) {
        ResponseMessage responseMessage = new ResponseMessage();

        postService.deletePost(postDTO);

        responseMessage.getMessage().setMessage("deletePost Success");

        return null;
    }
}

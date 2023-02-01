package com.gs.blog.controller;

import com.gs.blog.common.ResponseMessage;
import com.gs.blog.dto.PostDTO;
import com.gs.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity getPostList(
            @RequestParam String title,
            @RequestParam String createUser,
            @RequestParam(defaultValue = "1") int currentPage,
            @RequestParam(defaultValue = "10") int rangePage) {
        ResponseMessage responseMessage = new ResponseMessage();

        PostDTO postDTO = new PostDTO();
        postDTO.setTitle(title);
        postDTO.setCreateUser(createUser);

        List<PostDTO> postList = postService.getPostList(postDTO, currentPage, rangePage);
        int postListCount = postService.getPostListCount(postDTO);

        Map<String, Object> resultMap = new HashMap<String, Object>();

        resultMap.put("list", postList);
        resultMap.put("count", postListCount);

        responseMessage.getMessage().setData(resultMap);
        responseMessage.getMessage().setMessage("getPostList Success");

        return responseMessage.getResponse();
    }

    @GetMapping(value = "/{postIdx}")
    public ResponseEntity getPost(@PathVariable("postIdx") int postIdx) {
        ResponseMessage responseMessage = new ResponseMessage();

        PostDTO postDTO = new PostDTO();
        postDTO.setPostIdx(postIdx);

        PostDTO post = postService.getPost(postDTO);

        responseMessage.getMessage().setData(post);
        responseMessage.getMessage().setMessage("getPost Success");

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

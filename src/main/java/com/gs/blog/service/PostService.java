package com.gs.blog.service;

import com.gs.blog.dto.PostDTO;
import com.gs.blog.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PostService {

    @Autowired
    private PostMapper postMapper;

    public void createPost(PostDTO postDTO){
        try {
            postMapper.createPost(postDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public List<PostDTO> getPostList(PostDTO postDTO, int currentPage, int rangePage) {

        List<PostDTO> result = new ArrayList<PostDTO>();

        try {

            int startIndex = rangePage * (currentPage - 1);
            int endIndex = startIndex + rangePage;

            postDTO.setStartIndex(startIndex);
            postDTO.setEndIndex(endIndex);

            result = postMapper.getPostList(postDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public int getPostListCount(PostDTO postDTO) {

        int result = 0;

        try {
            result = postMapper.getPostListCount(postDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public PostDTO getPost(PostDTO postDTO) {

        PostDTO result = new PostDTO();

        try {
            result = postMapper.getPost(postDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public void updatePost(PostDTO postDTO){
        try {
            postMapper.updatePost(postDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deletePost(PostDTO postDTO){
        try {
            postMapper.deletePost(postDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

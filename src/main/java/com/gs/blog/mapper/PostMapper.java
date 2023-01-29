package com.gs.blog.mapper;

import com.gs.blog.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    void createPost(PostDTO postDTO);

    List<PostDTO> getPostList(PostDTO postDTO);

    void updatePost(PostDTO postDTO);

    void deletePost(PostDTO postDTO);
}

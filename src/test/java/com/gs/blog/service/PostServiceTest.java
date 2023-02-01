package com.gs.blog.service;

import com.gs.blog.dto.PostDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {

    @Autowired
    PostService postService;

    @Test
    @DisplayName("게시글 추가")
    void createPost() {

        for(int i = 0 ; i < 50 ; i++) {
            PostDTO post = new PostDTO();

            post.setBoardIdx(1);
            post.setTitle("testTitle" + i);
            post.setContent("testContent" + i);
            post.setViewCnt(0);
            post.setDeleted("N");
            post.setCreateUser("admin");
            post.setCreateDate(LocalDate.now().toString());
            post.setUpdateUser("admin");
            post.setUpdateDate(LocalDate.now().toString());

            postService.createPost(post);
        }

    }

    @Test
    @DisplayName("게시글 조회")
    void getPostList() {

        PostDTO post = new PostDTO();

        //post.setTitle("정다은");
        //post.setCreateUser("searchTest");

        int currentPage = 3;
        int rangePage = 15;

        postService.getPostList(post, currentPage, rangePage);
    }

    @Test
    @DisplayName("게시글 수정")
    void updatePost() {
        PostDTO post = new PostDTO();
        post.setPostIdx(53);
        post.setTitle("게이조이고");
        post.setContent("게이는문화다");
        post.setUpdateUser("정다은조이고");

        postService.updatePost(post);
    }

    @Test
    @DisplayName("게시글 삭제")
    void deletePost() {
        PostDTO post = new PostDTO();
        post.setPostIdx(52);

        postService.deletePost(post);
    }
}
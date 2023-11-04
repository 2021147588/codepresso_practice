package com.msa.service;

import com.msa.post.repository.PostRepository;
import com.msa.post.service.PostService;
import com.msa.post.service.PostServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PostServiceTests {

    private PostService postService;

    @Mock
    private PostRepository postRepository;

    @BeforeEach
    public void init() {
        postService = new PostServiceImpl(postRepository);
    }

    @Test
    @DisplayName("add 시 repository 가 호출되는 지 확인")
    public void test_post_add() {
        postService.addPost("test title", "test content");
        verify(postRepository, atLeastOnce()).save(any());
    }

    @Test
    public void test_get_post_by_id() {
        postService.getPost(1L);
        verify(postRepository, atLeastOnce()).findById(any());
    }

    @Test
    public void test_delete_post_by_id() {
        postService.deletePost(1L);
        verify(postRepository, atLeastOnce()).deleteById(any());
    }

}

package com.msa.repository;

import com.msa.comment.domain.Comment;
import com.msa.post.domain.Post;
import com.msa.post.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class PostRepositoryTests {

    @Autowired
    private PostRepository postRepository;


    @Test
    public void test_add_comment() {

        Comment c = new Comment("content");
        Set<Comment> comments = Set.of(c);
        Post post = new Post("title", "content", comments);

        postRepository.saveAndFlush(post);

        Optional<Post> optPost = postRepository.findById(1L);
        assertTrue(optPost.isPresent());
        assertFalse(optPost.get().getComments().isEmpty());
    }



}

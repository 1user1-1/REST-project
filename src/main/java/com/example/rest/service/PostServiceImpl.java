package com.example.rest.service;

import com.example.rest.model.Post;
import com.example.rest.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public Post create(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> readAll() {
        return postRepository.findAll();
    }

    @Override
    public Post read(int id) {
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()) {
            return post.get();
        }else {
            throw new RuntimeException("Post not found");
        }



    }

    @Override
    public Post update(Post post, int id) {
        Post existingPost = postRepository.findById(id).orElseThrow(
                ()-> new RuntimeException()
        );
        existingPost.setName(post.getName());
        existingPost.setContent(post.getContent());

        postRepository.save(existingPost);
        return existingPost;
    }

    @Override
    public void delete(int id) {
        postRepository.findById(id).orElseThrow(() -> new RuntimeException());
        postRepository.deleteById(id);
    }

    @Override
    public void bulkDelete(){
        postRepository.deleteAll();
    }


}

package com.example.rest.service;

import com.example.rest.model.Post;

import java.util.List;

public interface PostService {
    Post create(Post post);

    List<Post> readAll();

    Post read(int id);

    Post update(Post post, int id);

    void delete(int id);

    void bulkDelete();
}

package com.example.rest.service;

import com.example.rest.model.Post;

import java.util.List;

public interface PostService {
    void create(Post post);

    List<Post> readAll();

    Post read(int id);

    boolean update(Post post, int id);

    boolean delete(int id);

    boolean bulkDelete();
}

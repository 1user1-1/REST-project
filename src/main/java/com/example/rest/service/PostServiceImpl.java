package com.example.rest.service;

import com.example.rest.model.Post;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class PostServiceImpl implements PostService {
    private static final Map<Integer, Post> POST_REPOSITORY_MAP = new HashMap<>();

    private static final AtomicInteger POST_ID = new AtomicInteger();

    @Override
    public void create(Post post) {
        final int postId = POST_ID.getAndIncrement();
        post.setId(postId);
        POST_REPOSITORY_MAP.put(postId, post);
    }

    @Override
    public List<Post> readAll() {
        return new ArrayList<>(POST_REPOSITORY_MAP.values());
    }

    @Override
    public Post read(int id) {
        return POST_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Post post, int id) {
        if (POST_REPOSITORY_MAP.containsKey(id)) {
            post.setId(id);
            Post exPost = POST_REPOSITORY_MAP.get(id);
            post.setCreationDate(exPost.getCreationDate());
            POST_REPOSITORY_MAP.put(id, post);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (POST_REPOSITORY_MAP.containsKey(id)) {
            POST_REPOSITORY_MAP.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean bulkDelete(){
        if(POST_REPOSITORY_MAP.isEmpty()){
            return false;
        }
        POST_REPOSITORY_MAP.clear();
        return true;
    }


}

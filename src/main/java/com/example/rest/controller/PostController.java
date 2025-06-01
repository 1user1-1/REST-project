package com.example.rest.controller;



import com.example.rest.model.Post;
import com.example.rest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(value = "/posts")
    public ResponseEntity<?> create(@RequestBody Post post) {
        postService.create(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/posts")
    public ResponseEntity<List<Post>> read() {
        final List<Post> posts = postService.readAll();

        return posts != null &&  !posts.isEmpty()
                ? new ResponseEntity<>(posts, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/posts/{id}")
    public ResponseEntity<Post> read(@PathVariable(name = "id") int id) {
        final Post post = postService.read(id);

        return post != null
                ? new ResponseEntity<>(post, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/posts/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Post post) {
        final boolean updated = postService.update(post, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/posts/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = postService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/posts")
    public ResponseEntity<?> bulkDelete() {
        final boolean deleted = postService.bulkDelete();

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}


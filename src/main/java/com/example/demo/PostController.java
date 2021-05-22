package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Post;
import com.example.demo.services.PostService;;

@RestController
public class PostController {

    private final PostService postService;

    PostController(PostService postService) {
        this.postService = postService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/posts")
    public List<Post> posts() {
        return this.postService.getPosts();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable String id) {
        return this.postService.getPost(id);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/postsByUser/{id}")
    public List<Post> posts(@PathVariable String id) {
        return this.postService.getPostsByUserId(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post) {
        return this.postService.addPost(post);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/posts/{id}")
    public Post addPost(@RequestBody Post post, @PathVariable String id) {
        return this.postService.updatePost(id, post);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/posts/{id}")
    public Post deletePost(@PathVariable String id) {
        return this.postService.removePost(id);
    }
}
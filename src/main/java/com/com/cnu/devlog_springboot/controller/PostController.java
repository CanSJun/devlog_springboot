package com.com.cnu.devlog_springboot.controller;

import com.com.cnu.devlog_springboot.model.Post;
import com.com.cnu.devlog_springboot.model.request.PostRequest;
import com.com.cnu.devlog_springboot.service.PostService;
import com.com.cnu.devlog_springboot.type.Tag;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;


    @GetMapping
    public ResponseEntity<List<Post>> getPosts(@RequestParam("tag") @Nullable Tag tag){
        return ResponseEntity.ok(postService.getPostbyTag(tag));
    }
    //get /posts/{post id}



    @GetMapping("{postId}")
    public ResponseEntity<Post> getPost(@PathVariable("postId")Integer postId){
        return ResponseEntity.ok(postService.getPost(postId));
    }


    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostRequest postRequest){
        return ResponseEntity.ok(postService.createPost(postRequest));
    }

    // /post/*
    //put /post/{post_id}
    @PutMapping("{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable("postId")Integer postId,
                                           @RequestBody PostRequest postRequest){
        return ResponseEntity.ok(postService.updatePost(postId, postRequest));
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable("postId")Integer postId){
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }


}

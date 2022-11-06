package com.dazna.forum.forum.controller;

import com.dazna.forum.forum.dto.*;
import com.dazna.forum.forum.service.ForumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ForumController{

    final ForumService forumService;
    @PostMapping("/forum/post/{author}")
    public PostDto addPost(@PathVariable String author,@RequestBody PostAddDto postAddDto) {
        return forumService.addPost(author,postAddDto);
    }

    @GetMapping("/forum/post/{id}")
    public PostDto findPostById(@PathVariable String id) {
        return forumService.findPostById(id);
    }

    @PutMapping("/forum/post/{id}/like")
    public Boolean addLike(@PathVariable String id) {
        return forumService.addLike(id);
    }

    @GetMapping("/forum/posts/author/{author}")
    public List<PostDto> findPostsByAuthor(@PathVariable String author) {
        return forumService.findPostsByAuthor(author);
    }

    @PutMapping("/forum/post/{postId}/comment/{author}")
    public PostDto addComment(@PathVariable String postId,@PathVariable String author,
                              @RequestBody CommentAddDto commentAddDto) {
        return forumService.addComment(postId,author,commentAddDto);
    }

    @DeleteMapping("/forum/post/{id}")
    public PostDto deletePost(@PathVariable String id) {
        return forumService.deletePost(id);
    }

    @PostMapping("/forum/posts/tags")
    public List<PostDto> findPostsByTags(@RequestBody List<String> tags) {
        return forumService.findPostsByTags(tags);
    }

    @PostMapping("/forum/posts/period")
    public List<PostDto> findPostsByPeriod(@RequestBody PeriodDto periodDto) {
        return forumService.findPostsByPeriod(periodDto);
    }

    @PutMapping("/forum/post/{id}")
    public PostDto updatePost(@PathVariable String id,@RequestBody PostUpdateDto postUpdateDto) {
        return forumService.updatePost(id,postUpdateDto);
    }
}

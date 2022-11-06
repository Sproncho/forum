package com.dazna.forum.forum.service;

import com.dazna.forum.forum.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ForumService {
     PostDto addPost(String author, PostAddDto postAddDto);
     PostDto findPostById(String id);
     Boolean addLike(String id);
     List<PostDto> findPostsByAuthor(String author);
     PostDto addComment(String postId,String author,CommentAddDto commentAddDto);
     PostDto deletePost(String id);
     List<PostDto>findPostsByTags(List<String> tags);
     List<PostDto>findPostsByPeriod(PeriodDto periodDto);
     PostDto updatePost(String id, PostUpdateDto postUpdateDto);
}

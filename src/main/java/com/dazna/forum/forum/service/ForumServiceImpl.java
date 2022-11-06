package com.dazna.forum.forum.service;

import com.dazna.forum.forum.dao.ForumRepository;
import com.dazna.forum.forum.dto.*;
import com.dazna.forum.forum.model.Comment;
import com.dazna.forum.forum.model.Post;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ForumServiceImpl implements ForumService {
    final ForumRepository forumRepository;
    final ModelMapper modelMapper;
    @Override
    public PostDto addPost(String author, PostAddDto postAddDto) {
        Post post = modelMapper.map(postAddDto, Post.class);
        post.setAuthor(author);
        //post.setDateCreated(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"))); выдает ошибку. не понял как работают LocalDateTime и ModuleMapper
        forumRepository.save(post);
        return modelMapper.map(post,PostDto.class);
    }

    @Override
    public PostDto findPostById(String id) {
        Post post = forumRepository.findById(id).orElse(null);
        if (post == null)
            return null;
        return modelMapper.map(post,PostDto.class);
    }

    @Override
    public Boolean addLike(String id) {
        Post post  = forumRepository.findById(id).orElse(null);
        if (post == null)
            return false;
        post.addLike();
        forumRepository.save(post);
        return true;
    }

    @Override
    public List<PostDto> findPostsByAuthor(String author) {
        return forumRepository.findByAuthorIgnoreCase(author)
                .map(p -> modelMapper.map(p,PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto addComment(String postId, String author, CommentAddDto commentAddDto) {
        Post post = forumRepository.findById(postId).orElse(null);
        if (post == null)
            return null;
        Comment comment = Comment.builder()
                .user(author)
                .message(commentAddDto.getMessage())
                .dateCreated(LocalDateTime.now())
                .likes(0)
                .build();
        post.addComment(comment);
        forumRepository.save(post);
        return modelMapper.map(post,PostDto.class);
    }

    @Override
    public PostDto deletePost(String id) {
        Post post = forumRepository.findById(id).orElse(null);
        if (post == null)
            return null;
        forumRepository.deleteById(id);
        return modelMapper.map(post,PostDto.class);
    }

    @Override
    public List<PostDto> findPostsByTags(List<String> tags) {
        return forumRepository.findAllByTagsIn(tags)
                .map(p -> modelMapper.map(p,PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findPostsByPeriod(PeriodDto periodDto) {
        return null;
    }

    @Override
    public PostDto updatePost(String id, PostUpdateDto postUpdateDto) {
        Post post = forumRepository.findById(id).orElse(null);
        if (post == null)
            return null;
        post.setTitle(postUpdateDto.getTitle());
        postUpdateDto.getTags().forEach(t -> post.addTag(t));
        forumRepository.save(post);
        return modelMapper.map(post,PostDto.class);
    }
}

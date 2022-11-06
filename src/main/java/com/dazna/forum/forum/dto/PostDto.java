package com.dazna.forum.forum.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    String id;
    String title;
    String content;
    String author;
    String dateCreated;
    List<String> tags;
    Integer likes;
    List<CommentDto> comments;
}

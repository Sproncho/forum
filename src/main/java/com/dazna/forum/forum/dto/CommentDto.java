package com.dazna.forum.forum.dto;

import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class CommentDto {
    String user;
    String message;
    LocalDateTime dateCreated;
    Integer likes;
}

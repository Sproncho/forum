package com.dazna.forum.forum.model;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    String user;
    String message;
    LocalDateTime dateCreated;
    Integer likes = 0;
}

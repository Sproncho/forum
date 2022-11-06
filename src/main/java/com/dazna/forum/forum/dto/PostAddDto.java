package com.dazna.forum.forum.dto;

import lombok.Getter;

import java.util.List;
@Getter
public class PostAddDto {
    String title;
    String content;
    List<String> tags;
}

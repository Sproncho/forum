package com.dazna.forum.forum.dto;

import lombok.Getter;

import java.util.List;
@Getter
public class PostUpdateDto {
    String title;
    List<String> tags;
}

package com.dazna.forum.forum.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Post {
    @Id
    String id;
    @Setter
    String title;
    @Setter
    String content;
    @Setter
    String author;
    @Setter
    LocalDateTime dateCreated;
    //String dateCreated;
    List<String> tags;
    @Setter
    int likes = 0;
    List<Comment> comments = new ArrayList<>();

    public Post( String title, String content, List<String> tags) {
        this.title = title;
        this.content = content;
        this.tags = tags;
    }
    public void addLike(){
        likes++;
    }
    public void addComment(Comment comment){
        comments.add(comment);
    }
    public void addTag(String tag){
        tags.add(tag);
    }
}

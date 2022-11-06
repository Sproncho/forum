package com.dazna.forum.forum.dao;

import com.dazna.forum.forum.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Stream;

public interface ForumRepository extends CrudRepository<Post,String> {
    Stream<Post> findByAuthorIgnoreCase(String author);
    Stream<Post> findAllByTagsIn(List<String> tags);
}

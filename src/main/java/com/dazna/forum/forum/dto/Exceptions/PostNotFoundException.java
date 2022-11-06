package com.dazna.forum.forum.dto.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PostNotFoundException extends RuntimeException{
    private static final long serialVersionUID = -2898404505161550864L;
    public PostNotFoundException(int id){
        super("post with id " + id + " not found");
    }
}

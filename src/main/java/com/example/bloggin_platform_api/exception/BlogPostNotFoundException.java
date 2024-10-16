package com.example.bloggin_platform_api.exception;

import org.springframework.http.HttpStatus;

public class BlogPostNotFoundException extends GlobalBlogginPlatformException {

    public BlogPostNotFoundException() {
        super(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), "Blog post not found");
    }

}

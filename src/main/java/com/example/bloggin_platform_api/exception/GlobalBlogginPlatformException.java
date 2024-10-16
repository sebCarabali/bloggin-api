package com.example.bloggin_platform_api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class GlobalBlogginPlatformException extends RuntimeException {

    private int status;
    private String statusText;
    private String message;
}

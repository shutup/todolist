package com.shutup.exception;

/**
 * Created by shutup on 2016/12/4.
 */
public class AuthorizeFailException extends RuntimeException {

    public AuthorizeFailException(String message) {
        super(message);
    }
}

package com.shutup.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by shutup on 2016/12/4.
 */
public class CustomException extends RuntimeException {
    private String msg;
    private boolean status;
    private HttpStatus httpStatus;

    public CustomException(String msg, boolean status, HttpStatus httpStatus) {
        this.msg = msg;
        this.status = status;
        this.httpStatus = httpStatus;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}

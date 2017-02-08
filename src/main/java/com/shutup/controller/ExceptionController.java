package com.shutup.controller;

import com.shutup.exception.AuthorizeFailException;
import com.shutup.exception.CustomException;
import com.shutup.model.response.RestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shutup on 2016/12/4.
 */

@ControllerAdvice
@RestController
public class ExceptionController {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @ResponseStatus
    @ExceptionHandler(value = AuthorizeFailException.class)
    public RestInfo HandleAuthorizeFailException(Exception ex) {
        return new RestInfo(ex.getLocalizedMessage(),false, HttpStatus.UNAUTHORIZED.value());
    }

    @ResponseStatus
    @ExceptionHandler(value = CustomException.class)
    public RestInfo HandleCustomException(CustomException ex) {
        return new RestInfo(ex.getMsg(), ex.isStatus(), ex.getHttpStatus().value());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public RestInfo HandleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        StringBuilder stringBuilder = new StringBuilder();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            stringBuilder.append(error.getDefaultMessage() + ", ");
        }
        String finalMsg = stringBuilder.toString().substring(0, stringBuilder.toString().length() - 2);
        log.info("验证错误", finalMsg);
        return new RestInfo(finalMsg,false,HttpStatus.BAD_REQUEST.value());
    }

    //@ExceptionHandler(value = Exception.class)
    public RestInfo HandleException(Exception ex) {
        return new RestInfo("INTERNAL_SERVER_Exception",false, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    //@ExceptionHandler(value = Error.class)
    public RestInfo HandleError(Error ex) {
        return new RestInfo("INTERNAL_SERVER_Error",false, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

}

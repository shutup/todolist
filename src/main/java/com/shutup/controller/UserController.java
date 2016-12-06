package com.shutup.controller;

import com.shutup.model.persist.User;
import com.shutup.model.request.UserLoginRequest;
import com.shutup.model.request.UserRegisterRequest;
import com.shutup.model.response.UserLoginResponse;
import com.shutup.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by shutup on 2016/12/3.
 */
@Api(value = "User API")
@RestController
@RequestMapping(path = {"/user"})
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(path = {"/register"},method = RequestMethod.POST)
    public ResponseEntity<User> register(@Valid @RequestBody UserRegisterRequest userRegisterRequest){
        User user = userService.Register(userRegisterRequest);
        if (user != null) {
            return ResponseEntity.ok(user);
        }else {
            return null;
        }
    }

    @RequestMapping(path = {"/login"},method = RequestMethod.POST)
    public ResponseEntity<UserLoginResponse> login(@Valid @RequestBody UserLoginRequest userLoginRequest) {
        UserLoginResponse userLoginResponse = userService.Login(userLoginRequest);
        if (userLoginResponse != null) {
            return ResponseEntity.ok(userLoginResponse);
        }else {
            return null;
        }
    }
}

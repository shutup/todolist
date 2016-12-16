package com.shutup.controller;

import com.shutup.model.persist.User;
import com.shutup.model.request.UserLoginRequest;
import com.shutup.model.request.UserRegisterRequest;
import com.shutup.model.response.RestInfo;
import com.shutup.model.response.UserLoginResponse;
import com.shutup.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<RestInfo> register(@Valid @RequestBody UserRegisterRequest userRegisterRequest){
        User user = userService.Register(userRegisterRequest);
        RestInfo restInfo;
        if (user != null) {
            restInfo = new RestInfo("user create success", true, HttpStatus.CREATED.value());
            return ResponseEntity.ok(restInfo);
        }else {
            restInfo = new RestInfo("user create failed", false, HttpStatus.SERVICE_UNAVAILABLE.value());
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(restInfo);
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

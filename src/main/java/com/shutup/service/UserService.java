package com.shutup.service;

import com.shutup.exception.CustomException;
import com.shutup.model.persist.User;
import com.shutup.model.persist.UserStatus;
import com.shutup.model.request.UserLoginRequest;
import com.shutup.model.request.UserRegisterRequest;
import com.shutup.model.response.UserLoginResponse;
import com.shutup.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Created by shutup on 2016/12/3.
 */
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserStatusService userStatusService;

    public UserLoginResponse Login(UserLoginRequest userLoginModel) {
        String username = userLoginModel.getUsername();
        String password = userLoginModel.getPassword();
        User user = userRepo.findByUsernameAndPassword(username,password);
        if (user != null) {
            UserStatus userStatus = userStatusService.CreateOrUpdateToken(user);
            UserLoginResponse userLoginResponse = new UserLoginResponse(user.getId(),userStatus.getToken());
            return userLoginResponse;
        }else {
            throw  new CustomException("用户不存在", false, HttpStatus.NOT_FOUND);
        }
    }

    public User Register(UserRegisterRequest userRegisterModel){
        User user = userRepo.findByUsername(userRegisterModel.getUsername());
        if (user==null){
            user = new User(userRegisterModel.getUsername(),userRegisterModel.getPassword());
            User newUser = userRepo.save(user);
            return newUser;
        }else {
            throw  new CustomException("用户已存在", false, HttpStatus.CONFLICT);
        }
    }
}

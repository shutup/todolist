package com.shutup.model.request;

import javax.validation.constraints.NotNull;

/**
 * Created by shutup on 2016/12/3.
 */
public class UserRegisterRequest {
    @NotNull(message = "用户名不能为空")
    private String username;
    @NotNull(message = "密码不能为空")
    private String password;

    protected UserRegisterRequest() {
    }

    public UserRegisterRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

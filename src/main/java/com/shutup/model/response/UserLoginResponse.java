package com.shutup.model.response;

/**
 * Created by shutup on 2016/12/3.
 */
public class UserLoginResponse {
    private Long id;
    private String token;

    protected UserLoginResponse() {

    }

    public UserLoginResponse(Long id, String token) {
        this.id = id;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

package com.github.mvmcgrath.server.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private final String username;
    private final long userId;

    public JwtResponse(String jwttoken, UserDAO user) {
        this.jwttoken = jwttoken;
        this.username = user.getUsername();
        this.userId = user.getUserId();
    }

    public String getUsername() {
        return username;
    }

    public long getUserId() {
        return userId;
    }

    public String getToken() {
        return this.jwttoken;
    }
}

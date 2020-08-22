package com.bubble.athena.net.user;

import com.bubble.athena.server.user.IUserManager;
import com.bubble.net.response.Response;

@FunctionalInterface
public interface IUserRequest {
    Response apply(IUserManager manager);
}
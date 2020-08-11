package com.bubble.util.resource;

import com.bubble.athena.server.arena.UserSave;

public interface IResourceManager {
    UserSave getSave(String user);
}
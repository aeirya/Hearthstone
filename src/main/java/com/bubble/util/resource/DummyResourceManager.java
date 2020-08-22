package com.bubble.util.resource;

import com.bubble.athena.server.arena.UserSave;

public class DummyResourceManager implements IResourceManager {

    @Override
    public UserSave getSave(String user) {
        return new UserSave();
    }
    
}
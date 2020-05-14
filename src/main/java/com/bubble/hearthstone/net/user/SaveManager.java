package com.bubble.hearthstone.net.user;

import com.bubble.hearthstone.util.log.MyFileWriter;
import com.bubble.hearthstone.util.serialize.GsonSerializer;
import com.bubble.hearthstone.util.serialize.UserSerializer;
import com.bubble.hearthstone.util.services.ServiceLocator;
import java.io.File;

public class SaveManager {
    
    private SaveManager() { }

    public static UserSave loadSave(User user) {
        if (! new File(getSavePath(user)).exists()) {
            createSaveFile(user);
        }
        return ServiceLocator.getResources().loadSave(user);
    }

    public static void createSaveFile(User user) {
        new MyFileWriter(
            getSavePath(user)
            ).write(
                new GsonSerializer().serialize(new UserSave(user), UserSave.class)
            );
    }
            
    private static String getSavePath(User user) {
        final String saveDir = ServiceLocator.getResources().getResource("save");
        return saveDir + user.getUsername() + ".save";
    }
            
    public static void createUserFile(User user) {
        new MyFileWriter(user.getFilePath()).write(new UserSerializer().serialize(user));
    }
}
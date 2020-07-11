package com.bubble.hearthstone.util.log;

import com.bubble.hearthstone.module.service.ServiceLocator;

public class Log {
    
    private Log() { }
    
    public static void msg(String text) {
        ServiceLocator.getLogger().log(text);
    }
}
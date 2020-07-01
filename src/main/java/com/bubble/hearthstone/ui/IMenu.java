package com.bubble.hearthstone.ui;

import com.bubble.hearthstone.net.event.IEventCaller;
import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.util.services.ServiceLocator;

public interface IMenu extends IEventCaller {
    
    void launch(IGameGraphics graphics);
    
    default void sendEvent(IGameEvent event) {
        //hotfix
        ServiceLocator.getNetworkService().push(event);
    }
}
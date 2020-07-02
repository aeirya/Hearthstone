package com.bubble.hearthstone.module.input.mouse;

import com.bubble.hearthstone.module.event.EventSystem;
import com.bubble.hearthstone.module.event.IEvent;

public class MouseInput {
    
    

    private void dispatch(IEvent event) {
        EventSystem.dispatch(event);
    }
}
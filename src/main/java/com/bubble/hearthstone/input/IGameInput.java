package com.bubble.hearthstone.input;

import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.ui.gui.components.Frame;

public interface IGameInput extends IInput {
    void triggerEvent(IGameEvent event);
    MouseInput getMouseInput();
    void bind(Frame frame);
}
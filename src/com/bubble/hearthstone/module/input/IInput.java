package com.bubble.hearthstone.module.input;

import com.bubble.hearthstone.module.IFramework;
import com.bubble.hearthstone.module.gui.components.IFrame;
import com.bubble.hearthstone.module.input.mouse.IMouseInput;

public interface IInput extends IFramework {
    IMouseInput getMouseInput();
    void bind(IFrame frame);
}
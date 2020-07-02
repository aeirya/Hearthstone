package com.bubble.hearthstone.module.input.mouse;

import com.bubble.hearthstone.module.gui.components.IFrame;

public interface IMouseInput extends IMouseListener {
    void bind(IFrame frame);
}
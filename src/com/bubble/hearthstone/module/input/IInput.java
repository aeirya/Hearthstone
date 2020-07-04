package com.bubble.hearthstone.module.input;

import com.bubble.hearthstone.module.gui.components.IFrame;

public interface IInput {
    void bind(IFrame frame);
    void unbind();
}
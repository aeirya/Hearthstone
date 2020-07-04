package com.bubble.hearthstone.module.input.keyboard;

import com.bubble.hearthstone.module.gui.components.IFrame;

public interface IKeyboardInput extends IKeyListener {
    void bind(IFrame frame);
}
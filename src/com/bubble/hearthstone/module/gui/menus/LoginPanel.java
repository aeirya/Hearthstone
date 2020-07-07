package com.bubble.hearthstone.module.gui.menus;

import com.bubble.hearthstone.module.gui.components.IButton;
import com.bubble.hearthstone.module.gui.components.IPanel;
import com.bubble.hearthstone.module.gui.components.ITextField;
import com.bubble.hearthstone.module.gui.components.layout.Box;
import com.bubble.hearthstone.module.gui.components.layout.VerticalBox;

public class LoginPanel {

    IPanel centerPanel;
    IButton loginButton;
    IButton quitButton;
    ITextField usernameField;
    ITextField passwordField;

    public LoginPanel() {
        Box box1 = VerticalBox.create(usernameField, passwordField);
        Box box2 = VerticalBox.create(loginButton, quitButton);
        centerPanel.addComponents(box1, box2);
    }
}
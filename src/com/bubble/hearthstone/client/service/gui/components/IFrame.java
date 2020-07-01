package com.bubble.hearthstone.client.service.gui.components;

import com.bubble.hearthstone.stl.Dimension;

public interface IFrame {

    void setTitle(String string);

    void setSize(Dimension size);
    Dimension getSize();

    boolean checkForClose();

}
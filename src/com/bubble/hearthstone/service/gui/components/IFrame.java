package com.bubble.hearthstone.service.gui.components;

import com.bubble.hearthstone.stl.Dimension;

public interface IFrame {

    void setTitle(String string);

    void setSize(Dimension size);
    Dimension getSize();

    boolean checkForClose();

}
package com.bubble.hearthstone.input;

import com.bubble.hearthstone.stl.Point;
import com.bubble.hearthstone.ui.gui.components.Frame;

public class MouseInput {
    
    private MouseListener listener;
    private MouseInputEventHandler eventHandler;

    private Point mouseLocation;

    public MouseInput() {
        listener = new MouseListener();
        eventHandler = new MouseInputEventHandler(this, listener);
    }

    public void bind(Frame frame) {
        frame.addMouseListener(listener);
    }

    public Point getMouseLocation() {
        return mouseLocation;
    }

    public void setMouseLocation(Point point) {
        mouseLocation = point;
    }
}
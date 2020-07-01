package com.bubble.hearthstone.input;

import java.awt.event.MouseEvent;
import java.util.List;

import com.bubble.hearthstone.stl.Point;

public class MouseInputEventHandler {

    private final MouseInput input;

    MouseInputEventHandler(MouseInput input, MouseListener listener) {
        this.input = input;
        addEvents(listener);
    }

    private void addEvents(MouseListener listener) {
        listener.addEvents(
            List.of(
                MouseEventType.MOUSE_MOVED,
                MouseEventType.MOUSE_CLICKED,
                MouseEventType.MOUSE_DRAGGED,
                MouseEventType.MOUSE_RELEASED
            ),
            this::onMove,
            this::onClick,
            this::onDrag,
            this::onRelease
            );
    }

    private void onMove(MouseEvent e) {
        input.setMouseLocation(
            new Point(e.getPoint())
        );
    }

    private void onClick(MouseEvent e) {
        //
    }

    private void onDrag(MouseEvent e) {
        System.out.println("drag: " + e.getPoint());
    }

    private void onRelease(MouseEvent e) {
        System.out.println("released on: " + e.getPoint());
    }
}
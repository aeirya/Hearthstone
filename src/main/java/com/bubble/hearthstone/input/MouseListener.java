package com.bubble.hearthstone.input;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

import com.bubble.hearthstone.ui.gui.components.Frame;

public class MouseListener extends MouseAdapter {

    private final Map<MouseEventType, MouseEventAction> events;

    public MouseListener() {
        events = new EnumMap<>(MouseEventType.class);
    }

    public void addEvent(MouseEventType type, MouseEventAction action) {
        events.put(type, action);
    }

    public void addEvents(List<MouseEventType> names, MouseEventAction... events) {
        final List<MouseEventAction> eventsList = Arrays.asList(events);
        final Iterator<MouseEventType> name = names.iterator();
        this.events.putAll(
            eventsList.stream().collect(
                Collectors.toMap(
                    event -> name.next(), Function.identity()
                    )));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        callEvent(MouseEventType.MOUSE_CLICKED, e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        callEvent(MouseEventType.MOUSE_PRESSED, e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        callEvent(MouseEventType.MOUSE_RELEASED, e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        callEvent(MouseEventType.MOUSE_ENTERED, e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        callEvent(MouseEventType.MOUSE_EXITED, e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        callEvent(MouseEventType.MOUSE_DRAGGED, e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        callEvent(MouseEventType.MOUSE_MOVED, e);
    }

    private MouseEventAction getEvent(MouseEventType type) {
        return events.getOrDefault(type, e -> {});
    }

    private void callEvent(MouseEventType type, MouseEvent e) {
        getEvent(type).accept(e);
    }

    @FunctionalInterface
    interface MouseEventAction extends Consumer<MouseEvent> { }

    public static void main(String[] args) {

        MouseInput input = new MouseInput();

        JFrame frame = new JFrame();
        frame.setSize(
            new java.awt.Dimension(400,400)
        );
        frame.setFocusable(true);
        frame.setVisible(true);
        Frame f = new Frame(frame);
        input.bind(f);
        frame.requestFocus();
    }
}
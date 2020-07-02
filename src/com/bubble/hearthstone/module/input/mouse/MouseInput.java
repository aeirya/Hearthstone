package com.bubble.hearthstone.module.input.mouse;

import com.bubble.hearthstone.module.event.EventSystem;
import com.bubble.hearthstone.module.event.IEvent;
import com.bubble.hearthstone.module.gui.components.IFrame;
import com.bubble.hearthstone.module.input.mouse.glfw.GlfwMouseInput;

public class MouseInput implements IMouseInput {

    private IMouseInput input;

    public MouseInput() {
        input = new GlfwMouseInput(this);
    }

    private void dispatch(IEvent event) {
        EventSystem.dispatch(event);
    }

    @Override
    public void onMouseMove(MouseState mouse) {
        System.out.println(mouse.location);
    }

    @Override
    public void onMouseClick(MouseState mouse) {
        // TODO Auto-generated method stub
    }

    @Override
    public void bind(IFrame frame) {
        input.bind(frame);
    }
}
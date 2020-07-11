package com.bubble.hearthstone.module.gui.components;

import java.util.ArrayList;
import java.util.List;

import com.bubble.hearthstone.module.render.GuiElement;
import com.bubble.hearthstone.module.render.GuiElement.GuiElementType;
import com.bubble.hearthstone.stl.Color;
import com.bubble.hearthstone.stl.Dimension;
import com.bubble.hearthstone.stl.Point;

public class Panel implements IPanel {

    private final List<IComponent> children;
    private Color bgColor;
    private Point location;
    private Dimension size;

    public Panel() {
        children = new ArrayList<>();
        bgColor = new Color(0.8f, 0.8f, 0.8f);
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    // color
    public void setBackgroundColor(Color color) {
        this.bgColor = color;
    }

    public void setBackgroundColor(float r, float g, float b) {
        setBackgroundColor(new Color(r, g, b));
    }

    // components
    @Override
    public void addComponent(IComponent component) {
        children.add(component);
    }

    @Override
    public void addComponents(IComponent... components) {
        for (IComponent comp : components) {
            addComponent(comp);
        }
    }

    @Override
    public void add(IComponent... components) {
        addComponents(components);
    }

    public GuiElement toGuiElement() {
        return new GuiElement(
            location, size, bgColor, GuiElementType.PANEL
        );
    }
}
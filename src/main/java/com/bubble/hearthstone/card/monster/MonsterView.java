package com.bubble.hearthstone.card.monster;

import java.awt.Graphics;

import com.bubble.hearthstone.interfaces.Drawable;
import com.bubble.hearthstone.stl.Dimension;
import com.bubble.hearthstone.stl.Point;
import com.bubble.hearthstone.ui.gui.GuiComponent;
import com.bubble.hearthstone.ui.gui.IGuiComponent;

public class MonsterView implements IGuiComponent, Drawable {

    private final Monster monster;
    private final MonsterDrawer drawer;
    final GuiComponent guiComponent;

    public MonsterView(Monster monster) {
        this.guiComponent = new GuiComponent();
        this.monster = monster;
        this.drawer = new MonsterDrawer(this);
    }

    public void draw(Graphics g) {
        drawer.draw(g);
    }

    public void setSize(Dimension size) {
        this.guiComponent.setSize(size);
    }

    public void setLocation(Point location) {
        this.guiComponent.setLocation(location);
    }
}
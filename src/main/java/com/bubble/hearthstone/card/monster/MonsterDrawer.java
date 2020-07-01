package com.bubble.hearthstone.card.monster;

import java.awt.Graphics;

import com.bubble.hearthstone.stl.Dimension;
import com.bubble.hearthstone.stl.Point;
import com.bubble.hearthstone.ui.gui.GuiComponent;

public class MonsterDrawer {

    private final MonsterView monsterView;

    public MonsterDrawer(MonsterView monsterView) {
        this.monsterView = monsterView;
    }

    public void draw(Graphics g) {
        System.out.println("monster drawing :p");
        final GuiComponent guiComp = monsterView.guiComponent;
        final Point loc = guiComp.getLocation();
        final Dimension size = guiComp.getSize();
        drawRect(g, loc, size);
    }

    private void drawRect(Graphics g, Point loc, Dimension size) {
        g.fillRect(
            loc.x, loc.y, size.width , size.height);
    }
}
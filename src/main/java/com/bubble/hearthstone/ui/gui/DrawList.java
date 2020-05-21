package com.bubble.hearthstone.ui.gui;

import com.bubble.hearthstone.interfaces.Drawable;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


public class DrawList implements Drawable {

    private List<Drawable> list;

    public DrawList() {
        list = new ArrayList<>();
    }

    public void draw(Graphics g) {
        list.forEach(d -> d.draw(g));
    }   

    public DrawList add(Drawable drawable) {
        list.add(drawable);
        return this;
    }
}
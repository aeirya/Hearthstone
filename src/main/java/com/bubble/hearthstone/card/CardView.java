package com.bubble.hearthstone.card;

import com.bubble.hearthstone.interfaces.ResizableDrawable;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class CardView implements ResizableDrawable {

    private final CardLayout layout;
    private Dimension size;
    private Point location;

    CardView(Dimension size, Point location, String cardname) {
        this.size = size;
        this.location = location;
        this.layout = new CardLayout(cardname);
    }

    CardView() {
        this(new Dimension(), new Point(), null);
    }

    public CardView(String cardname) {
        this(
            new Dimension(300,400),
            new Point(0,0),
            cardname
        );
    }

    @Override
    public void setSize(Dimension size) {
        this.size = size;
    }

    @Override
    public void setLocation(int x, int y) {
        this.location = new Point(x,y);
    }

    @Override
    public void draw(Graphics g) {
        layout.setSettings(size, location).draw(g);
    }
}
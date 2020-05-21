package com.bubble.hearthstone.card;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import com.bubble.hearthstone.interfaces.Drawable;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class CardView implements Drawable {

    private final Dimension size;
    private final Point location;
    private final String cardname;
    private  Image image;

    CardView(Dimension size, Point location, String cardname) {
        this.size = size;
        this.location = location;
        this.cardname = cardname;
    }

    CardView() {
        this(new Dimension(), new Point(), null);
    }

    public CardView(String cardname) {
        this(
            new Dimension(400,400),
            new Point(100,100),
            cardname
        );
    }

    @Override
    public void draw(Graphics g) {
        final Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(getImage(), location.x, location.y, size.width, size.height, null);
    }

    private Image getImage() {
        if (image == null) {
            image = ServiceLocator.getResources().getImage(
                getFilename(cardname));
        }
        return image;
    }

    private String getFilename(String cardname) {
        return cardname.replace(" ", "_").toLowerCase();
    }
}
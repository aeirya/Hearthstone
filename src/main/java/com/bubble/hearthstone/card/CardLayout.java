package com.bubble.hearthstone.card;

import com.bubble.hearthstone.card.registry.CardRecord;
import com.bubble.hearthstone.interfaces.Drawable;
import com.bubble.hearthstone.util.services.ServiceLocator;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Map;

public class CardLayout implements Drawable {

    private final String name;
    private final CardStylo stylo;
    private Dimension size;
    private Point location;
    private Image image;
    //values are normalized between 1 - 10
    private final Map<String, Point> coordinates = Map.of(
        "name", new Point(5,5),
        "description" , new Point(5, 7)
    );

    public CardLayout(String name, CardRecord record) {
        this.name = name;
        this.stylo = new CardStylo(record, coordinates, this);
    }

    public CardLayout setSettings(Dimension size, Point location) {
        this.size = size;
        this.location = location;
        return this;
    }

    @Override
    public void draw(Graphics g) {
        drawImage(g);
        drawTexts(g);
    }

    private void drawImage(Graphics g) {
        g.drawImage(getImage(), location.x, location.y, size.width, size.height, null);
    }

    private Image getImage() {
        if (image == null) {
            image = ServiceLocator.getResources().getImage(
                getFilename(name));
        }
        return image;
    }

    private String getFilename(String cardname) {
        return cardname.replace(" ", "_").toLowerCase();
    }

    private void drawTexts(Graphics g) {
        stylo.drawTexts(g);
    }

    public Dimension getSize() {
        return this.size;
    }

    public Point getLocation() {
        return this.location;
    }
}
package com.bubble.hearthstone.card;

import com.bubble.hearthstone.interfaces.Drawable;
import com.bubble.hearthstone.util.services.ServiceLocator;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Point;

public class CardLayout implements Drawable {

    private final String name;
    private Dimension size;
    private Point location;
    private Image image;

    public CardLayout(String name) {
        this.name = name;
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
        final Font font = new Font("SansSerif", Font.BOLD, 36);
        g.setFont(
            font
        );
        final String text = "O";
        drawTextAt(g, location.x, location.y, font, text);
    }
    
    private void drawTextAt(Graphics g, int x, int y, Font font, String text) {
        final FontMetrics metric = g.getFontMetrics(font);
        g.drawString(
            text, x - metric.stringWidth(text) / 2 , 
            y - metric.getHeight() / 2 + metric.getAscent()
        );
    }

    private Dimension getCenter() {
        return new Dimension(size.width / 2, size.height / 2);
    }
}
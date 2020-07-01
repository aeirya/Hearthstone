package com.bubble.hearthstone.card;

import com.bubble.hearthstone.card.registry.CardRecord;
import com.bubble.hearthstone.util.services.ServiceLocator;

import java.util.Arrays;
import java.util.List;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

public class CardStylo {
    
    private static final String DEFAULT_KEY = "default";
    private final Map<String, Font> styles;

    //todo: replace strings with num
    // private final List<CardField> fields = List.of(CardField.values())
    private final List<String> fields = Arrays.asList("name", "mana", "type", "heroClass", "rarity", "description");
    private final Map<String, Point> coordinates;
    private final CardRecord record;
    private final CardLayout layout;

    public CardStylo(CardRecord record, CardLayoutConfig config, CardLayout layout) {
        this.record = record; //replace this with an udpate method
        this.layout = layout;
        this.coordinates = config.getCoordinates();
        this.styles = config.getStyles();
    }

    private Font getFont(String key) {
        return styles.getOrDefault(
            key, 
            styles.get(DEFAULT_KEY)
        );
    }

    public void drawTexts(Graphics g) {
        fields.forEach(
            field -> {
                if (coordinates.containsKey(field)) {
                    final Point location = getPropertyAbsoluteLocaiton(field);
                    final String text = record.getProperty(field);
                    final Font font = getFont(field);
                    if (text != null) 
                        drawTextAt(g, location.x, location.y, font, text);
                    else
                        ServiceLocator.getLogger().warning(
                            "trying to get the non-existing card record field: " + field);
                }
            }
        );
    }

    private Point getPropertyAbsoluteLocaiton(String field) {
        final Point base = layout.getLocation();
        final Point relative = getPropertyRelativeLocation(field);
        return new Point(
            base.x + relative.x, base.y + relative.y
        );
    }

    private Point getPropertyRelativeLocation(String field) {
        return convertNonScaled(
            coordinates.get(field));
    }

    private Point convertNonScaled(Point point) {
        final Dimension size = layout.getSize();
        return new Point(
            (int) (point.getX() / 10  * size.width),
            (int) (point.getY() / 10 * size.height)
        );
    }
    
    private void drawTextAt(Graphics g, int x, int y, Font font, String text) {
        final FontMetrics metric = g.getFontMetrics(font);
        g.setFont(font);
        g.drawString(
            text, x - metric.stringWidth(text) / 2 , 
            y - metric.getHeight() / 2 + metric.getAscent()
        );
    }

    private Dimension getCenter() {
        final Dimension size = layout.getSize();
        return new Dimension(size.width / 2, size.height / 2);
    }
}
package com.bubble.hearthstone.card;

import java.util.Map;

import java.awt.Point;
import java.awt.Font;

public class CardLayoutConfig {
    
    //values are normalized between 1 - 10
    private final Map<String, Point> coordinates;
    private final Map<String, Font> styles;

    public CardLayoutConfig(Map<String, Point> coordinates, Map<String, Font> styles) {
        this.coordinates = coordinates;
        this.styles = styles;
    }

    public Map<String, Point> getCoordinates() {
        return coordinates;
    }

    public Map<String, Font> getStyles() {
        return styles;
    }
}
package com.bubble.hearthstone.module.render.opengl;

/**
 * used in text renderer
 */
public class TextMessage {

    /**
     * to add: color and theme
     */
    private final String text;

    public TextMessage(String text) {
        this.text = text;
    }

    public String toString() {
        return text;
    }

    public String getText() {
        return text;
    }

    public char[] getChars() {
        return text.toCharArray();
    }
}
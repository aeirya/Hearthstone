package com.bubble.hearthstone.stl;

public class Dimension {
    
    public final int width;
    public final int height;

    public Dimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Dimension scaled(double ratio) {
        return new Dimension(
            (int) (ratio * width), (int) (ratio * height));
    }
}
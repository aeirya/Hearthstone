package com.bubble.hearthstone.stl;

public class Point {
    
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point sum(Point a, Point b) {
        return new Point(
            a.x + b.x, a.y + b.y
        );
    }

    public java.awt.Point toPoint() {
        return new java.awt.Point(x, y);
    }
}
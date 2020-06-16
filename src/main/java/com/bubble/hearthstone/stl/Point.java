package com.bubble.hearthstone.stl;

public class Point {
    
    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(java.awt.Point point) {
        this.x = (int) point.getX();
        this.y = (int) point.getY();
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
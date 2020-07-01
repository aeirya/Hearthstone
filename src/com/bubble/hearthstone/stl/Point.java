package com.bubble.hearthstone.stl;

public class Point {
    
    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point sum(Point other) {
        return new Point(
            this.x + other.x, this.y + other.y
        );
    }

    public static Point sum(Point a, Point b) {
        return new Point(
            a.x + b.x, a.y + b.y
        );
    }
}
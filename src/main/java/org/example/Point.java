package org.example;

import java.util.Objects;

public class Point implements Cloneable {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distanceTo(Point other) {
        int deltaX = other.x - this.x;
        int deltaY = other.y - this.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public static double distanceBetween(Point point1, Point point2) {
        if (point1 == null || point2 == null) {
            return 0.0;
        }
        int x1 = point1.getX();
        int y1 = point1.getY();
        int x2 = point2.getX();
        int y2 = point2.getY();
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point other = (Point) obj;
            return this.x == other.x && this.y == other.y;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
    }

    public Point copy() {
        return new Point(this.x, this.y);
    }
}
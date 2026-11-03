package com.company;

public class Rectangle extends Shape {
    private double x;
    private double y;
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height, String color) {
        super(color);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public String getShapeType() {
        return "rectangle";
    }

    @Override
    public String toCliString() {
        return String.format("rectangle %.0f %.0f %.0f %.0f %s", x, y, width, height, color);
    }

    @Override
    public String toSvgTag() {
        return String.format("<rect x=\"%.0f\" y=\"%.0f\" width=\"%.0f\" height=\"%.0f\" fill=\"%s\" />",
                x, y, width, height, color);
    }

    @Override
    public void translate(double horizontal, double vertical) {
        this.x += horizontal;
        this.y += vertical;
    }

    @Override
    public boolean isWithinRectangle(double rx, double ry, double rw, double rh) {
        return (this.x >= rx) &&
                (this.y >= ry) &&
                (this.x + this.width <= rx + rw) &&
                (this.y + this.height <= ry + rh);
    }

    @Override
    public boolean isWithinCircle(double cx, double cy, double cr) {
        return isPointInCircle(x, y, cx, cy, cr) &&
                isPointInCircle(x + width, y, cx, cy, cr) &&
                isPointInCircle(x, y + height, cx, cy, cr) &&
                isPointInCircle(x + width, y + height, cx, cy, cr);
    }

    private boolean
isPointInCircle(double px, double py, double cx, double cy, double cr) {
    double distSq = (px - cx) *
            (px - cx) + (py - cy) * (py - cy);
    return distSq <= cr * cr;
    }
}
package com.company;

public abstract class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract String getShapeType();

    public abstract String toCliString();

    public abstract String toSvgTag();

    public abstract void translate(double horizontal, double vertical);

    public abstract boolean isWithinRectangle(double rx, double ry, double rw, double rh);

    public abstract boolean isWithinCircle(double cx, double cy, double cr);
}
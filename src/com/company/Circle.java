package com.company;

public class Circle extends Shape {
    private double cx;
    private double cy;
    private double r;

    public Circle(double cx, double cy, double r, String color) {
        super(color);
        this.cx = cx;
        this.cy = cy;
        this.r = r;
    }

    @Override
    public String getShapeType() {
        return "circle";
    }

    @Override
    public String toCliString() {
        return String.format("circle %.0f %.0f %.0f %s", cx, cy, r, color);
    }

    @Override
    public String toSvgTag() {
        return String.format("<circle cx=\"%.0f\" cy=\"%.0f\" r=\"%.0f\" fill=\"%s\" />",
                cx, cy, r, color);
    }

    @Override
    public void translate(double horizontal, double vertical) {
        this.cx += horizontal;
        this.cy += vertical;
    }

    @Override
    public boolean isWithinRectangle(double rx, double ry, double rw, double rh) {
        return (this.cx - this.r >= rx) &&
                (this.cy - this.r >= ry) &&
                (this.cx + this.r <= rx + rw) &&
                (this.cy + this.r <= ry + rh);
    }

    @Override
    public boolean isWithinCircle(double cx, double cy, double cr) {

        double dx = this.cx - cx;
        double dy = this.cy - cy;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return (distance + this.r) <= cr;
    }
}
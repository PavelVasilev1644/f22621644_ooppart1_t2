
package com.company;

public class Line extends Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public Line(double x1, double y1, double x2, double y2, String color) {
        super(color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public String getShapeType() {
        return "line";
    }

    @Override
    public String toCliString() {
        return String.format("line %.0f %.0f %.0f %.0f %s", x1, y1, x2, y2, color);
    }

    @Override
    public String toSvgTag() {
        return String.format("<line x1=\"%.0f\" y1=\"%.0f\" x2=\"%.0f\" y2=\"%.0f\" stroke=\"%s\" />",
                x1, y1, x2, y2, color);
    }

    @Override
    public void translate(double horizontal, double vertical) {
        this.x1 += horizontal;
        this.x2 += horizontal;
        this.y1 += vertical;
        this.y2 += vertical;
    }

    @Override
    public boolean isWithinRectangle(double rx, double ry, double rw, double rh) {
        boolean p1Inside = (x1 >= rx && x1 <= rx + rw && y1 >= ry && y1 <= ry + rh);
        boolean p2Inside = (x2 >= rx && x2 <= rx + rw && y2 >= ry && y2 <= ry + rh);
        return p1Inside && p2Inside;
    }

    @Override
    public boolean isWithinCircle(double cx, double cy, double cr) {
        double d1Sq = (x1 - cx) * (x1 - cx) + (y1 - cy) * (y1 - cy);
        double d2Sq = (x2 - cx) * (x2 - cx) + (y2 - cy) * (y2 - cy);
        return (d1Sq <= cr * cr) && (d2Sq <= cr * cr);
    }
}
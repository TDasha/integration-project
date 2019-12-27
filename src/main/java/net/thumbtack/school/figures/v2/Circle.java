package net.thumbtack.school.figures.v2;

import static java.lang.Math.pow;

public class Circle extends Figure {
    private Point2D center;
    private int radius;

    public Circle(Point2D center, int radius, int color) {
        this.center = center;
        this.radius = radius;
        this.setColor(color);
    }

    public Circle(int cordXCenter, int cordYCenter, int radius, int color) {
        this.center = new Point2D(cordXCenter, cordYCenter);
        this.radius = radius;
        this.setColor(color);
    }

    public Circle(int radius, int color) {
        this.center = new Point2D();
        this.radius = radius;
        this.setColor(color);
    }

    public Circle(int color) {
        this.center = new Point2D();
        this.radius = 1;
        this.setColor(color);
    }

    public Point2D getCenter() {
        return this.center;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setCenter(Point2D center) {
        this.center = center;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void moveRel(int dx, int dy) {
        this.center.setX(this.center.getX() + dx);
        this.center.setY(this.center.getY() + dy);
    }

    public void enlarge(int num) {
        this.radius = num * radius;
    }

    public double getArea() {
        return Math.PI * pow(radius, 2);
    }

    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    public boolean isInside(int cordX, int cordY) {
        return pow(cordX - center.getX(), 2) + pow(cordY - center.getY(), 2) <= pow(radius, 2);
    }

    public boolean isInside(Point2D point) {
        return pow(point.getX() - center.getX(), 2) + pow(point.getY() - center.getY(), 2) <= pow(radius, 2);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }

        Circle circle = (Circle) obj;

        if (radius != circle.radius) {
            return false;
        }
        return center != null ? center.equals(circle.center) : circle.center == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (center != null ? center.hashCode() : 0);
        result = 31 * result + radius;
        return result;
    }
}

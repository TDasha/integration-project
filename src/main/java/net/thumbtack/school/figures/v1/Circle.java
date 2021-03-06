package net.thumbtack.school.figures.v1;

import static java.lang.Math.pow;

public class Circle {

    private Point2D center;
    private int radius;

    public Circle(Point2D center, int raduis) {
        this.center = center;
        this.radius = raduis;
    }

    public Circle(int cordXCenter, int cordYCenter, int radius) {
        this.center = new Point2D(cordXCenter, cordYCenter);
        this.radius = radius;
    }

    public Circle(int radius) {
        this.center = new Point2D();
        this.radius = radius;
    }

    public Circle() {
        this.center = new Point2D();
        this.radius = 1;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
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
        int result = center != null ? center.hashCode() : 0;
        result = 31 * result + radius;
        return result;
    }

    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    public boolean isInside(int cordX, int cordY) {
        return pow(cordX - center.getX(), 2) + pow(cordY - center.getY(), 2) <= pow(radius, 2);
    }

    public boolean isInside(Point2D point) {
        return pow(point.getX() - center.getX(), 2) + pow(point.getY() - center.getY(), 2) <= pow(
            radius, 2);
    }
}

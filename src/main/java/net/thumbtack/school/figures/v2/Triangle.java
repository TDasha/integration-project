package net.thumbtack.school.figures.v2;

import static java.lang.Math.pow;

public class Triangle extends Figure {
    private Point2D point1, point2, point3;


    public Triangle(Point2D point1, Point2D point2, Point2D point3, int color) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.setColor(color);
    }

    public Point2D getPoint1() {
        return this.point1;
    }

    public Point2D getPoint2() {
        return this.point2;
    }

    public Point2D getPoint3() {
        return this.point3;
    }

    public void setPoint1(Point2D point) {
        this.point1 = point;
    }

    public void setPoint2(Point2D point) {
        this.point2 = point;
    }

    public void setPoint3(Point2D point) {
        this.point3 = point;
    }

    public double getSide12() {
        return pow(pow((point1.getX() - point2.getX()), 2) + pow((point1.getY() - point2.getY()), 2), (double) 1 / 2);
    }

    public double getSide13() {
        return pow(pow((point1.getX() - point3.getX()), 2) + pow((point1.getY() - point3.getY()), 2), (double) 1 / 2);
    }

    public double getSide23() {
        return pow(pow((point2.getX() - point3.getX()), 2) + pow((point2.getY() - point3.getY()), 2), (double) 1 / 2);
    }

    public void moveRel(int dx, int dy) {
        this.point1.setX(this.point1.getX() + dx);
        this.point2.setX(this.point2.getX() + dx);
        this.point3.setX(this.point3.getX() + dx);
        this.point1.setY(this.point1.getY() + dy);
        this.point2.setY(this.point2.getY() + dy);
        this.point3.setY(this.point3.getY() + dy);
    }

    public double getPerimeter() {
        return this.getSide12() + this.getSide13() + this.getSide23();
    }

    public double getArea() {
        double p = this.getPerimeter() / 2;
        return pow(p * (p - this.getSide12()) * (p - this.getSide13()) * (p - this.getSide23()), (double) 1 / 2);
    }

    public boolean isInside(int x, int y) {
        int signA = (this.point1.getX() - x) * (this.point2.getY() - this.point1.getY()) -
                (this.point2.getX() - this.point1.getX()) * (this.point1.getY() - y);
        int signB = (this.point2.getX() - x) * (this.point3.getY() - this.point2.getY()) -
                (this.point3.getX() - this.point2.getX()) * (this.point2.getY() - y);
        int signC = (this.point3.getX() - x) * (this.point1.getY() - this.point3.getY()) -
                (this.point1.getX() - this.point3.getX()) * (this.point3.getY() - y);
        return (signA >= 0 && signB >= 0 && signC >= 0) || (signA <= 0 && signB <= 0 && signC <= 0);
    }

    public boolean isInside(Point2D point) {
        int signA = (this.point1.getX() - point.getX()) * (this.point2.getY() - this.point1.getY()) -
                (this.point2.getX() - this.point1.getX()) * (this.point1.getY() - point.getY());
        int signB = (this.point2.getX() - point.getX()) * (this.point3.getY() - this.point2.getY()) -
                (this.point3.getX() - this.point2.getX()) * (this.point2.getY() - point.getY());
        int signC = (this.point3.getX() - point.getX()) * (this.point1.getY() - this.point3.getY()) -
                (this.point1.getX() - this.point3.getX()) * (this.point3.getY() - point.getY());
        return (signA >= 0 && signB >= 0 && signC >= 0) || (signA <= 0 && signB <= 0 && signC <= 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Triangle triangle = (Triangle) o;

        if (point1 != null ? !point1.equals(triangle.point1) : triangle.point1 != null) return false;
        if (point2 != null ? !point2.equals(triangle.point2) : triangle.point2 != null) return false;
        return point3 != null ? point3.equals(triangle.point3) : triangle.point3 == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (point1 != null ? point1.hashCode() : 0);
        result = 31 * result + (point2 != null ? point2.hashCode() : 0);
        result = 31 * result + (point3 != null ? point3.hashCode() : 0);
        return result;
    }
}

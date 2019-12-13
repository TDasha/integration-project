package net.thumbtack.school.figures.v1;

public class Rectangle3D extends Rectangle {
    private int h;

    public Rectangle3D(Point2D leftTop, Point2D rightBottom, int height) {
        super(leftTop, rightBottom);
        this.h = height;
    }

    public Rectangle3D(int xLeft, int yTop, int xRight, int yBottom, int height) {
        super(xLeft, yTop, xRight, yBottom);
        this.h = height;
    }

    public Rectangle3D(int length, int width, int height) {
        super(length, width);
        this.h = height;
    }

    public Rectangle3D() {
        super();
        this.h = 1;
    }

    public int getHeight() {
        return this.h;
    }

    public void setHeight(int height) {
        this.h = height;
    }

    public double getVolume() {
        return this.getArea() * h;
    }

    public boolean isInside(int x, int y, int z) {
        return this.isInside(x, y) && (z >= 0 && z <= this.getHeight());
    }

    public boolean isInside(Point3D point) {
        return this.isInside(point.getX(), point.getY(), point.getZ());
    }

    public boolean isIntersects(Rectangle3D rectangle) {
        return this.isIntersects((Rectangle) rectangle) && (this.h >= rectangle.h || this.h <= rectangle.h);
    }

    public boolean isInside(Rectangle3D rectangle) {
        return this.isInside((Rectangle) rectangle) && this.h >= rectangle.h;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Rectangle3D that = (Rectangle3D) o;

        return h == that.h;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + h;
        return result;
    }
}

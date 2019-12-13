package net.thumbtack.school.figures.v2;

public class Cylinder extends Circle {
    private int h;

    public Cylinder(Point2D center, int radius, int height, int color) {
        super(center, radius, color);
        this.h = height;
    }

    public Cylinder(int xCenter, int yCenter, int radius, int height, int color) {
        super(xCenter, yCenter, radius, color);
        this.h = height;
    }

    public Cylinder(int radius, int height, int color) {
        super(radius, color);
        this.h = height;
    }

    public Cylinder(int color) {
        super(color);
        this.h = 1;
    }

    public int getHeight() {
        return this.h;
    }

    public void setHeight(int height) {
        this.h = height;
    }

    public double getVolume() {
        return this.getArea() * this.getHeight();
    }

    public boolean isInside(int x, int y, int z) {
        return this.isInside(x, y) && (z >= 0 && z <= this.getHeight());
    }

    public boolean isInside(Point3D point) {
        return this.isInside(point.getX(), point.getY(), point.getZ());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cylinder cylinder = (Cylinder) o;

        return h == cylinder.h;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + h;
        return result;
    }
}

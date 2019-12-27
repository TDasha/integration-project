package net.thumbtack.school.figures.v2;

public class Cylinder extends Circle {
    private int height;

    public Cylinder(Point2D center, int radius, int height, int color) {
        super(center, radius, color);
        this.height = height;
    }

    public Cylinder(int cordXCenter, int cordYCenter, int radius, int height, int color) {
        super(cordXCenter, cordYCenter, radius, color);
        this.height = height;
    }

    public Cylinder(int radius, int height, int color) {
        super(radius, color);
        this.height = height;
    }

    public Cylinder(int color) {
        super(color);
        this.height = 1;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getVolume() {
        return this.getArea() * this.getHeight();
    }

    public boolean isInside(int cordX, int cordY, int cordZ) {
        return this.isInside(cordX, cordY) && cordZ >= 0 && cordZ <= this.getHeight();
    }

    public boolean isInside(Point3D point) {
        return this.isInside(point.getX(), point.getY(), point.getCordZ());
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

        Cylinder cylinder = (Cylinder) obj;

        return height == cylinder.height;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + height;
        return result;
    }
}

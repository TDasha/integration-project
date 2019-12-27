package net.thumbtack.school.figures.v1;

public class Cylinder extends Circle {

    private int hight;

    public Cylinder(Point2D center, int radius, int height) {
        super(center, radius);
        this.hight = height;
    }

    public Cylinder(int cordXCenter, int cordYCenter, int radius, int height) {
        super(cordXCenter, cordYCenter, radius);
        this.hight = height;
    }

    public Cylinder(int radius, int height) {
        super(radius);
        this.hight = height;
    }

    public Cylinder() {
        super();
        this.hight = 1;
    }

    public int getHeight() {
        return this.hight;
    }

    public void setHeight(int height) {
        this.hight = height;
    }

    public double getVolume() {
        return this.getArea() * this.getHeight();
    }

    public boolean isInside(int cordX, int cordY, int cordZ) {
        return this.isInside(cordX, cordY) && cordZ >= 0 && cordZ <= this.getHeight();
    }

    public boolean isInside(Point3D point) {
        return this.isInside(point.getX(), point.getY(), point.getZ());
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

        return hight == cylinder.hight;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + hight;
        return result;
    }
}

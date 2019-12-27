package net.thumbtack.school.figures.v1;

public class Rectangle3D extends Rectangle {

    private int height;

    public Rectangle3D(Point2D leftTop, Point2D rightBottom, int height) {
        super(leftTop, rightBottom);
        this.height = height;
    }

    public Rectangle3D(int cordXLeft, int cordYTop, int cordXRight, int cordYBottom, int height) {
        super(cordXLeft, cordYTop, cordXRight, cordYBottom);
        this.height = height;
    }

    public Rectangle3D(int length, int width, int height) {
        super(length, width);
        this.height = height;
    }

    public Rectangle3D() {
        super();
        this.height = 1;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getVolume() {
        return this.getArea() * height;
    }

    public boolean isInside(int cordX, int cordY, int cordZ) {
        return this.isInside(cordX, cordY) && cordZ >= 0 && cordZ <= this.getHeight();
    }

    public boolean isInside(Point3D point) {
        return this.isInside(point.getX(), point.getY(), point.getZ());
    }

    public boolean isInside(Rectangle3D rectangle) {
        return this.isInside((Rectangle) rectangle) && this.height >= rectangle.height;
    }

    public boolean isIntersects(Rectangle3D rectangle) {
        return this.isIntersects((Rectangle) rectangle) && (this.height >= rectangle.height
            || this.height <= rectangle.height);
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

        Rectangle3D that = (Rectangle3D) obj;

        return height == that.height;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + height;
        return result;
    }
}

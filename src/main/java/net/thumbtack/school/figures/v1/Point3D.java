package net.thumbtack.school.figures.v1;

public class Point3D extends Point2D {

    private int cordZ;

    public Point3D(int cordX, int cordY, int cordZ) {
        super(cordX, cordY);
        this.cordZ = cordZ;
    }

    public Point3D(int cordZ) {
        super();
        this.cordZ = cordZ;
    }

    public Point3D() {
        super();
        cordZ = 0;
    }

    public int getZ() {
        return cordZ;
    }

    public void setZ(int cordZ) {
        this.cordZ = cordZ;
    }

    public void move(int dx, int dy, int dz) {
        super.moveRel(dx, dy);
        cordZ += dz;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + cordZ;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Point3D other = (Point3D) obj;
        if (cordZ != other.cordZ) {
            return false;
        }
        return true;
    }

}
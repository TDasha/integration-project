package net.thumbtack.school.figures.v1;

public class Point2D {

    private int cordX;
    private int cordY;

    public Point2D(int cordX, int cordY) {
        this.cordX = cordX;
        this.cordY = cordY;
    }

    public Point2D() {
        this(0, 0);
    }

    public int getX() {
        return cordX;
    }

    public void setX(int cordX) {
        this.cordX = cordX;
    }

    public int getY() {
        return cordY;
    }

    public void setY(int cordY) {
        this.cordY = cordY;
    }

    public void moveTo(int newX, int newY) {
        cordX = newX;
        cordY = newY;
    }

    public void moveRel(int dx, int dy) {
        cordX += dx;
        cordY += dy;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cordX;
        result = prime * result + cordY;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Point2D other = (Point2D) obj;
        if (cordX != other.cordX) {
            return false;
        }
        return cordY == other.cordY;
    }
}
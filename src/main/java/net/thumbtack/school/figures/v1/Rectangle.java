package net.thumbtack.school.figures.v1;

public class Rectangle {
    private Point2D leftTop;
    private Point2D rightBottom;

    public Rectangle(Point2D leftTop, Point2D rightBottom) {
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
    }

    public Rectangle(int cordXLeft, int cordYTop, int cordXRight, int cordYBottom) {
        this.leftTop = new Point2D(cordXLeft, cordYTop);
        this.rightBottom = new Point2D(cordXRight, cordYBottom);
    }

    public Rectangle(int length, int width) {
        this.leftTop = new Point2D(0, -width);
        this.rightBottom = new Point2D(length, 0);
    }

    public Rectangle() {
        this.leftTop = new Point2D(0, -1);
        this.rightBottom = new Point2D(1, 0);
    }

    public Point2D getTopLeft() {
        return leftTop;
    }

    public Point2D getBottomRight() {
        return rightBottom;
    }

    public void setTopLeft(Point2D topLeft) {
        this.leftTop = topLeft;
    }

    public void setBottomRight(Point2D bottomRight) {
        this.rightBottom = bottomRight;
    }

    public int getLength() {
        return rightBottom.getX() - leftTop.getX();
    }

    public int getWidth() {
        return rightBottom.getY() - leftTop.getY();
    }

    public void moveRel(int dx, int dy) {
        this.rightBottom.setX(this.rightBottom.getX() + dx);
        this.rightBottom.setY(this.rightBottom.getY() + dy);
        this.leftTop.setX(this.leftTop.getX() + dx);
        this.leftTop.setY(this.leftTop.getY() + dy);
    }

    public void enlarge(int nx, int ny) {
        int newX = this.getLength() * nx + this.leftTop.getX();
        int newY = this.getWidth() * ny + this.leftTop.getY();
        this.rightBottom.setX(newX);
        this.rightBottom.setY(newY);
    }

    public double getArea() {
        return this.getLength() * this.getWidth();
    }

    public double getPerimeter() {
        return (this.getLength() + this.getWidth()) * 2;
    }

    public boolean isInside(int cordX, int cordY) {
        return this.leftTop.getX() <= cordX && cordX <= this.rightBottom.getX()
                && this.leftTop.getY() <= cordY && cordY <= this.rightBottom.getY();
    }

    public boolean isInside(Rectangle rectangle) {
        return this.isInside(rectangle.rightBottom) && this.isInside(rectangle.leftTop);
    }

    public boolean isInside(Point2D point) {
        return this.leftTop.getX() <= point.getX()
                && point.getX() <= this.rightBottom.getX()
                && this.leftTop.getY() <= point.getY()
                && point.getY() <= this.rightBottom.getY();
    }

    public boolean isIntersects(Rectangle rectangle) {
        return this.isInside(rectangle.rightBottom)
                || this.isInside(rectangle.leftTop)
                || this.isInside(rectangle.leftTop.getX() + rectangle.getLength(), rectangle.leftTop.getY())
                || this.isInside(rectangle.leftTop.getX(), rectangle.leftTop.getY() + rectangle.getWidth())
                || rectangle.isInside(this.rightBottom)
                || rectangle.isInside(this.leftTop)
                || rectangle.isInside(this.leftTop.getX() + this.getLength(), this.leftTop.getY())
                || rectangle.isInside(this.leftTop.getX(), this.leftTop.getY() + this.getWidth());
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) obj;

        if (leftTop != null ? !leftTop.equals(rectangle.leftTop) : rectangle.leftTop != null) {
            return false;
        }
        return rightBottom != null ? rightBottom.equals(rectangle.rightBottom) : rectangle.rightBottom == null;
    }

    @Override
    public int hashCode() {
        int result = leftTop != null ? leftTop.hashCode() : 0;
        result = 31 * result + (rightBottom != null ? rightBottom.hashCode() : 0);
        return result;
    }
}
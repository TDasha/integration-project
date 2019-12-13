package net.thumbtack.school.figures.v2;

abstract public class Figure implements Colored {
    public int color;

    abstract public double getPerimeter();

    abstract public double getArea();

    abstract public boolean isInside(int x, int y);

    abstract public boolean isInside(Point2D point);

    abstract public void moveRel(int dx, int dy);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Figure figure = (Figure) o;

        return color == figure.color;
    }

    @Override
    public int hashCode() {
        return color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }
}

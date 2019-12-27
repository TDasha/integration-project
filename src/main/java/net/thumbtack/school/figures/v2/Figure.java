package net.thumbtack.school.figures.v2;

public abstract class Figure implements Colored {
    public int color;

    public abstract double getPerimeter();

    public abstract double getArea();

    public abstract boolean isInside(int cordX, int cordY);

    public abstract boolean isInside(Point2D point);

    public abstract void moveRel(int dx, int dy);

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Figure figure = (Figure) obj;

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

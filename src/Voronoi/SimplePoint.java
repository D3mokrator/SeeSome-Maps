package Voronoi;

public class SimplePoint {
    private Integer y;
    private Integer x;

    public SimplePoint() {
        x = 0;
        y = 0;
    }

    public SimplePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        if (other == this) return true;
        return y.equals(((SimplePoint) other).y) && x.equals(((SimplePoint) other).x);
    }
}

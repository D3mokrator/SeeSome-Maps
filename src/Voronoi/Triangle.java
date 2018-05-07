package Voronoi;

public class Triangle {

    Triangle(SimplePoint A, SimplePoint B, SimplePoint C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }
    static public int calcTriArea (SimplePoint p1, SimplePoint p2, SimplePoint p3)
    {
        return (p1.getX() - p3.getX()) * (p2.getY() - p3.getY()) - (p2.getX() - p3.getX()) * (p1.getY() - p3.getY());
    }

    public boolean containsEdge(SimplePoint p1, SimplePoint p2) {
        if (p1.equals(A) && (p2.equals(B) || p2.equals(C)))
            return true;
        if (p1.equals(B) && (p2.equals(A) || p2.equals(C)))
            return true;
        return p1.equals(C) && (p2.equals(A) || p2.equals(B));

    }


    public boolean  containsPoint (SimplePoint pt) {
        boolean b1, b2, b3;
        b1 = Triangle.calcTriArea(pt, A, B) < 0;
        b2 = Triangle.calcTriArea(pt, B, C) < 0;
        b3 = Triangle.calcTriArea(pt, C,A) < 0;
        return ((b1 == b2) && (b2 == b3));
    }

    public SimplePoint A;
    public SimplePoint B;
    public SimplePoint C;
}

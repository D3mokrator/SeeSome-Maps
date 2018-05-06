package Voronoi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Voronoi {

    private int MIN_VAL = 0;
    private int MAX_VAL = 1000;

    public List<Triangle> triangleList = new ArrayList<Triangle>();

    Voronoi(List<Point> listPoints) {

        Triangle superTriangle = new Triangle(new Point(MIN_VAL, MIN_VAL), new Point(MAX_VAL, MIN_VAL), new Point(MAX_VAL, MIN_VAL));
        triangleList.add(superTriangle);

        for (Point point : listPoints) {
            List<Triangle> badTriangles = new ArrayList<Triangle>();
            for ( Triangle triangle : triangleList)
                if(superTriangle.containsPoint(point)) badTriangles.add(triangle);

            List<Point> polygon = new ArrayList<Point>();

            for (Triangle tri1 : badTriangles) {
                boolean shared = false;

                for (Triangle tri2 : badTriangles) {
                    if (tri1 != tri2 && tri2.containsEdge(tri1.A, tri1.B)) {
                        shared = true;
                        break;

                    }
                }
                if (shared) {
                    polygon.add(tri1.A);
                    polygon.add(tri1.B);
                    shared = false;
                }
                for (Triangle tri2 : badTriangles) {
                    if (tri1 != tri2 && tri2.containsEdge(tri1.A, tri1.C)) {
                        shared = true;
                        break;
                    }
                }
                if(shared) {
                    polygon.add(tri1.A);
                    polygon.add(tri1.C);
                    shared = false;
                }

                for (Triangle tri2 : badTriangles) {
                    if (tri1 != tri2 && tri2.containsEdge(tri1.C, tri1.B)) {
                        shared = true;
                        break;

                    }
                }
                if(shared) {
                    polygon.add(tri1.C);
                    polygon.add(tri1.B);
                }
            }
            for (Triangle tri : badTriangles) {
                triangleList.remove(tri);
            }

            for(int i = 0; i < polygon.size(); i += 2) {
                triangleList.add(new Triangle(point, polygon.get(i), polygon.get(i+1)));
            }
        }
    }
}



package Voronoi;

/*
    Abstract class Event for implementing sweeping queue and events in Forunne's Algorithm.
*/

public abstract class Event implements Comparable <Event> {
    /*
        point: point of Event
    */

    public final Point point;

    Event(Point point) {
        this.point =  point;
    }

    public abstract void handle(/* to fill */);

    @Override
    public int compareTo(Event other) {
        return Integer.compare(other.point.getY(), point.getY());
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        if (other == this) return true;
        return point.equals(((Event) other).point);
    }
}

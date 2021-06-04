package com.elsys;

public class Coordinates implements Comparable<Coordinates> {
    int x;
    int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int get_x() {
        return this.x;
    }
    public int get_y() {
        return this.y;
    }
    public void set_x(int x) {
        this.x = x;
    }
    public void set_y(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compareTo(Coordinates o) {
        if (this.x < o.x) return -1;
        if (this.x > o.x) return +1;

        return Integer.compare(this.y, o.y);
    }
}

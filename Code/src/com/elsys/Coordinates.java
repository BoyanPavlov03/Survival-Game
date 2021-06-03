package com.elsys;

public class Coordinates {
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
}

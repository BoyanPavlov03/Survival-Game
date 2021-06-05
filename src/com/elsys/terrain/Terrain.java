package com.elsys.terrain;

import com.elsys.Coordinates;

import java.awt.*;

public interface Terrain {
    String type();
    void paint(Graphics2D g, Coordinates coordinates);
}

package com.elsys.terrain;

import com.elsys.Coordinates;

import java.awt.*;

public class Stone implements Terrain {
    @Override
    public String type() {
        return null;
    }

    @Override
    public void paint(Graphics2D g, Coordinates coordinates) {
        g.setColor(Color.gray);
        g.fillRect(coordinates.get_x() * 25, coordinates.get_y() * 25, 25, 25);
    }
}

package com.elsys.terrain;

import com.elsys.Coordinates;
import com.elsys.LoadImages;

import java.awt.*;

public class Grass implements Terrain{
    @Override
    public String type() {
        return "grass";
    }

    @Override
    public void paint(Graphics2D g, Coordinates coordinates) {
        g.drawImage(LoadImages.imgGrass,coordinates.get_x() * 25, coordinates.get_y() * 25, null, null);
    }
}

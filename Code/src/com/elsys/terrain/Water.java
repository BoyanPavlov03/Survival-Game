package com.elsys.terrain;

import com.elsys.Coordinates;
import com.elsys.LoadImages;

import java.awt.*;

public class Water implements Terrain{
    @Override
    public String type() {
        return "water";
    }

    @Override
    public void paint(Graphics2D g, Coordinates coordinates) {
        g.drawImage(LoadImages.imgWater,coordinates.get_x() * 25, coordinates.get_y() * 25, null, null);
    }
}

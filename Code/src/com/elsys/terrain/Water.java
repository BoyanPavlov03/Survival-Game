package com.elsys.terrain;

import com.elsys.Coordinates;
import com.elsys.LoadImages;
import com.elsys.Main;

import java.awt.*;

public class Water implements Terrain{
    @Override
    public String type() {
        return "water";
    }

    @Override
    public void paint(Graphics2D g, Coordinates coordinates) {
        g.drawImage(LoadImages.imgWater,coordinates.get_x() * Main.pixel_size, coordinates.get_y() * Main.pixel_size, null, null);
    }
}

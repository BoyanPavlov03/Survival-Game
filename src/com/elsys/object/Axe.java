package com.elsys.object;

import com.elsys.Coordinates;
import com.elsys.Main;

import java.awt.*;

public class Axe extends Item{
    @Override
    public void paint(Graphics2D g, Coordinates coordinates) {
        g.drawImage(Main.loadImages.imgAxe,coordinates.get_x() * Main.pixel_size, coordinates.get_y() * Main.pixel_size, null, null);
    }

    @Override
    public String type() {
        return "axe";
    }
}

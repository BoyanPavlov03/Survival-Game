package com.elsys.object;

import com.elsys.Coordinates;
import com.elsys.LoadImages;
import com.elsys.Main;

import java.awt.*;

public class Stick extends Item implements Stackable {
    @Override
    public void paint(Graphics2D g, Coordinates coordinates) {
        g.drawImage(LoadImages.imgStick,coordinates.get_x() * Main.pixel_size, coordinates.get_y() * Main.pixel_size, null, null);
    }

    @Override
    public String type() {
        return "stick";
    }
}

package com.elsys.object;

import com.elsys.Coordinates;
import com.elsys.Main;

import java.awt.*;

public class BottleOfWater extends Item implements Drinkable{
    public boolean full;

    public BottleOfWater() {
        this.full = true;
    }

    @Override
    public void paint(Graphics2D g, Coordinates coordinates) {
        if(full) {
            g.drawImage(Main.loadImages.imgFull,coordinates.get_x() * Main.pixel_size, coordinates.get_y() * Main.pixel_size, null, null);
        }
        else {
            g.drawImage(Main.loadImages.imgEmpty,coordinates.get_x() * Main.pixel_size, coordinates.get_y() * Main.pixel_size, null, null);
        }
    }

    @Override
    public String type() {
        return "bottle of water";
    }

    @Override
    public int drink() {
        if (full) {
            full = false;
            return 15;
        }
        else {
            return 0;
        }
    }
}

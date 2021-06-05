package com.elsys.object;

import com.elsys.Coordinates;

import java.awt.*;

public class Stick extends Item implements Stackable {
    @Override
    public void paint(Graphics2D g, Coordinates coordinates) {

    }

    @Override
    public String type() {
        return "stick";
    }
}

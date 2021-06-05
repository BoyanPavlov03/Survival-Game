package com.elsys.object;

import com.elsys.Coordinates;

import java.awt.*;

public class EmptyObject implements GameObject {
    @Override
    public void paint(Graphics2D g, Coordinates coordinates) {

    }

    @Override
    public String type() {
        return null;
    }
}

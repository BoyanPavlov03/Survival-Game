package com.elsys.object;

import com.elsys.Coordinates;

import java.awt.*;

public interface GameObject {
    void paint(Graphics2D g, Coordinates coordinates);
    String type();
}

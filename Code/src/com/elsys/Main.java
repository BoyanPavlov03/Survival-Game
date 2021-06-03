package com.elsys;

import com.elsys.object.Player;

import java.awt.*;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        TreeMap<Coordinates, Combination> map;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        Player player = new Player(100,100, 100, new Coordinates(100, 100));
        new Display("Survival-Game", 1000, 700, player);
    }
}

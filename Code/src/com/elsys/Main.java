package com.elsys;

import com.elsys.object.Player;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

public class Main {

    public static Display display;

    public static void main(String[] args) {
        Player player = new Player(100,100, 100, 12, 12);

        display = new Display("Survival-Game", 625, 625, player);
        display.addObject(player);

        Timer timer = new Timer();
        timer.schedule(new TimerTask(){

            @Override
            public void run() {
                display.getCanvas().repaint();
            }
        }, 0,100);
    }
}

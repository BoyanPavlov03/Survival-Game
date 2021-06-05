package com.elsys;

import com.elsys.object.Player;

import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static int pixel_size = 30;

    public static Display display;

    public static LoadImages loadImages;

    public static void main(String[] args) {
        Player player = new Player(100,100, 100, 12, 12);

        Map map = new Map(player);

        loadImages = new LoadImages();

        display = new Display("Survival-Game", pixel_size*pixel_size, pixel_size*pixel_size, map);

        display.getCanvas().repaint();

        Timer timer = new Timer();
        timer.schedule(new TimerTask(){

            @Override
            public void run() {
                if (player.getMove_tracker() == 1){
                    display.getCanvas().repaint();
                    player.setMove_tracker(0);
                }
            }
        }, 0,50);
    }
}

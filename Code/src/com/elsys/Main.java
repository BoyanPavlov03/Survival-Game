package com.elsys;

import com.elsys.object.Player;

import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static Display display;

    public static void main(String[] args) {
        Player player = new Player(100,100, 100, 12, 12);

        display = new Display("Survival-Game", 625, 625, player);
        display.addObject(player);

        new LoadImages();

        display.getCanvas().repaint();

        Timer timer = new Timer();
        timer.schedule(new TimerTask(){

            @Override
            public void run() {
                if (player.getMove_tracker() == 1){
                    display.getCanvas().repaint();
                    player.setMove_tracker();
                }
            }
        }, 0,50);
    }
}

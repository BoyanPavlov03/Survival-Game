package com.elsys;

import com.elsys.object.Player;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static int rakias_drank = 0;

    public static int pixel_size = 70;
    public static int visible_board_blocks_count = 11;

    public static Display display;

    public static LoadImages loadImages;

    public static void main(String[] args) {
        Player player = new Player(100,100, 100, 25, 25, 10);

        Map map = new Map(player);

        loadImages = new LoadImages();

        display = new Display("Survival-Game", 1200, 1200, map);

        display.getCanvas().repaint();

        Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            int epoch = 1;

            @Override
            public void run() {
                if (player.getMove_tracker() == 1){
                    display.getCanvas().repaint();
                    player.setMove_tracker(0);
                }
                if (epoch % 50 == 0) {
                    player.getHungry(1);
                    player.getThirsty(1);
                    player.setMove_tracker(1);
                }
                if (epoch % 100 == 0) {
                    player.getThirsty(1);
                    epoch = 1;
                }
                epoch++;

                if (player.isDead()) {
                    display.getCanvas().repaint();
                    timer.cancel();
                }
                if (rakias_drank == 5) {
                    display.getCanvas().repaint();
                    timer.cancel();
                }
            }
        }, 0,50);
    }
}

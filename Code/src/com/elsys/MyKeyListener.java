package com.elsys;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    Map map;

    public MyKeyListener(Map map) {
        this.map = map;
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 37 -> {
                map.getPlayer().setMove_tracker(1);
                map.moveLeft();
            }
            case 38 -> {
                map.getPlayer().setMove_tracker(1);
                map.moveUp();
            }
            case 39 -> {
                map.getPlayer().setMove_tracker(1);
                map.moveRight();
            }
            case 40 -> {
                map.getPlayer().setMove_tracker(1);
                map.moveDown();
            }
            default -> System.out.println(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }
}

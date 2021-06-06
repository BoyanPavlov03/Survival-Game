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
            case KeyEvent.VK_LEFT -> {
                map.getPlayer().setMove_tracker(1);
                map.moveLeft();
            }
            case KeyEvent.VK_UP -> {
                map.getPlayer().setMove_tracker(1);
                map.moveUp();
            }
            case KeyEvent.VK_RIGHT -> {
                map.getPlayer().setMove_tracker(1);
                map.moveRight();
            }
            case KeyEvent.VK_DOWN -> {
                map.getPlayer().setMove_tracker(1);
                map.moveDown();
            }
            case KeyEvent.VK_W -> {
                map.hit(new Coordinates(map.getPlayer().getCoordinates().get_x(), map.getPlayer().getCoordinates().get_y() - 1));
            }
            case KeyEvent.VK_A -> {
                map.hit(new Coordinates(map.getPlayer().getCoordinates().get_x() - 1, map.getPlayer().getCoordinates().get_y()));
            }
            case KeyEvent.VK_S -> {
                map.hit(new Coordinates(map.getPlayer().getCoordinates().get_x(), map.getPlayer().getCoordinates().get_y() + 1));
            }
            case KeyEvent.VK_D -> {
                map.hit(new Coordinates(map.getPlayer().getCoordinates().get_x() + 1, map.getPlayer().getCoordinates().get_y()));
            }
            default -> System.out.println(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }
}

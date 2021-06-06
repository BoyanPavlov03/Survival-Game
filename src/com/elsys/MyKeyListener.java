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
                map.moveLeft();
            }
            case KeyEvent.VK_UP -> {
                map.moveUp();
            }
            case KeyEvent.VK_RIGHT -> {
                map.moveRight();
            }
            case KeyEvent.VK_DOWN -> {
                map.moveDown();
            }
            case KeyEvent.VK_W -> {
                map.hit(new Coordinates(map.getPlayer().getCoordinates().get_x(), map.getPlayer().getCoordinates().get_y() - 1));
                return;
            }
            case KeyEvent.VK_A -> {
                map.hit(new Coordinates(map.getPlayer().getCoordinates().get_x() - 1, map.getPlayer().getCoordinates().get_y()));
                return;
            }
            case KeyEvent.VK_S -> {
                map.hit(new Coordinates(map.getPlayer().getCoordinates().get_x(), map.getPlayer().getCoordinates().get_y() + 1));
                return;
            }
            case KeyEvent.VK_D -> {
                map.hit(new Coordinates(map.getPlayer().getCoordinates().get_x() + 1, map.getPlayer().getCoordinates().get_y()));
                return;
            }
            case KeyEvent.VK_0 -> {
                map.getPlayer().inventory.setSelected(0);
            }
            case KeyEvent.VK_1 -> {
                map.getPlayer().inventory.setSelected(1);
            }
            case KeyEvent.VK_2 -> {
                map.getPlayer().inventory.setSelected(2);
            }
            case KeyEvent.VK_3 -> {
                map.getPlayer().inventory.setSelected(3);
            }
            case KeyEvent.VK_4 -> {
                map.getPlayer().inventory.setSelected(4);
                map.getPlayer().setMove_tracker(1);
            }
            case KeyEvent.VK_5 -> {
                map.getPlayer().inventory.setSelected(5);
                map.getPlayer().setMove_tracker(1);
            }
            case KeyEvent.VK_6 -> {
                map.getPlayer().inventory.setSelected(6);
            }
            case KeyEvent.VK_7 -> {
                map.getPlayer().inventory.setSelected(7);
            }
            case KeyEvent.VK_8 -> {
                map.getPlayer().inventory.setSelected(8);
            }
            case KeyEvent.VK_9 -> {
                map.getPlayer().inventory.setSelected(9);
            }
            case KeyEvent.VK_E -> {
                map.getPlayer().eat();
            }
            case KeyEvent.VK_F -> {
                map.getWater();
                map.getPlayer().setMove_tracker(1);
            }
            case KeyEvent.VK_G -> {
                map.getPlayer().gainThirst();
            }
            case KeyEvent.VK_T -> {
                map.getPlayer().craftAxe();
            }
            case KeyEvent.VK_R -> {
                map.getPlayer().craftRakia();
            }

            default -> System.out.println(e.getKeyCode());
        }

        map.getPlayer().setMove_tracker(1);
    }

    @Override
    public void keyReleased(KeyEvent e) { }
}

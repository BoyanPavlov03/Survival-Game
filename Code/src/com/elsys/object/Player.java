package com.elsys.object;

import com.elsys.Coordinates;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements GameObject, KeyListener{
    int curr_hp;
    int max_hp;
    int curr_hunger;
    int max_hunger;
    int curr_thirst;
    int max_thirst;
    Coordinates coords;

    public Player(int max_hp, int max_hunger, int max_thirst, Coordinates coords) {
        this.curr_hp = max_hp;
        this.max_hp = max_hp;
        this.curr_hunger = max_hunger;
        this.max_hunger = max_hunger;
        this.curr_thirst = max_thirst;
        this.max_thirst = max_thirst;
        this.coords = coords;
    }

    private void move(int x, int y) {
        this.coords.set_x(this.coords.get_x() + x);
        this.coords.set_y(this.coords.get_y() + y);
    }

    @Override
    public String type() {
        return "player";
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 37 -> {
                move(-10, 0);
                System.out.println(coords);
            }
            case 38 -> {
                move(0, 10);
                System.out.println(coords);
            }
            case 39 -> {
                move(10, 0);
                System.out.println(coords);
            }
            case 40 -> {
                move(0, -10);
                System.out.println(coords);
            }
            default -> System.out.println(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }
}

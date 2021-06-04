package com.elsys.object;

import com.elsys.Coordinates;
import com.elsys.Display;
import com.elsys.Main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Player implements GameObject, KeyListener{
    int curr_hp;
    int max_hp;
    int curr_hunger;
    int max_hunger;
    int curr_thirst;
    int max_thirst;
    Coordinates coords;
    BufferedImage img;

    public Player(int max_hp, int max_hunger, int max_thirst, int x, int y) {
        this.curr_hp = max_hp;
        this.max_hp = max_hp;
        this.curr_hunger = max_hunger;
        this.max_hunger = max_hunger;
        this.curr_thirst = max_thirst;
        this.max_thirst = max_thirst;
        this.coords = new Coordinates(x, y);
    }

    private void moveDown(int y) {
        if(y + coords.get_y() >= Main.display.getHeight()){
            return;
        }
        else{
            this.coords.set_y(this.coords.get_y() + y);
        }
    }
    private void moveLeft(int x){
        if(coords.get_x() - x < 0){
            return;
        }
        else{
            this.coords.set_x(this.coords.get_x() - x);
        }
    }
    private void moveRight(int x){
        if(x + coords.get_x() >= Main.display.getWidth()){
            return;
        }
        else{
            this.coords.set_x(this.coords.get_x() + x);
        }
    }
    private void moveUp(int y){
        if(coords.get_y() - y < 0){
            return;
        }
        else{
            this.coords.set_y(this.coords.get_y() - y);
        }
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(Color.red);
        g.fillRect(coords.get_x(), coords.get_y(), 25, 25);
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
                moveLeft(25);
            }
            case 38 -> {
                moveUp(25);
            }
            case 39 -> {
                moveRight(25);
            }
            case 40 -> {
                moveDown(25);
            }
            default -> System.out.println(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }
}

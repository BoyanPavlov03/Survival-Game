package com.elsys.object;

import com.elsys.Coordinates;
import com.elsys.Main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
// import java.awt.image.BufferedImage;

public class Player implements GameObject, KeyListener{
    int curr_hp;
    int max_hp;
    int curr_hunger;
    int max_hunger;
    int curr_thirst;
    int max_thirst;
    Coordinates coordinates;
    // BufferedImage img;

    public Player(int max_hp, int max_hunger, int max_thirst, int x, int y) {
        this.curr_hp = max_hp;
        this.max_hp = max_hp;
        this.curr_hunger = max_hunger;
        this.max_hunger = max_hunger;
        this.curr_thirst = max_thirst;
        this.max_thirst = max_thirst;
        this.coordinates = new Coordinates(x, y);
    }

    private void moveDown() {
        if((1 + coordinates.get_y()) * 25 < Main.display.getHeight()){
            this.coordinates.set_y(this.coordinates.get_y() + 1);
        }
    }
    private void moveLeft(){
        if(coordinates.get_x() - 1 >= 0){
            this.coordinates.set_x(this.coordinates.get_x() - 1);
        }
    }
    private void moveRight(){
        if((1 + coordinates.get_x()) * 25 < Main.display.getWidth()){
            this.coordinates.set_x(this.coordinates.get_x() + 1);
        }
    }
    private void moveUp(){
        if(coordinates.get_y() - 1 >= 0){
            this.coordinates.set_y(this.coordinates.get_y() - 1);
        }
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(Color.red);
        g.fillRect(coordinates.get_x() * 25, coordinates.get_y() * 25,  25, 25);
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
            case 37 -> moveLeft();
            case 38 -> moveUp();
            case 39 -> moveRight();
            case 40 -> moveDown();
            default -> System.out.println(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }
}

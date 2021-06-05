package com.elsys.object;

import com.elsys.Coordinates;
import com.elsys.LoadImages;
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

    int move_tracker = 0;

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
    public void paint(Graphics2D g, Coordinates coords) {
        g.drawImage(LoadImages.imgPlayer,coordinates.get_x() * 25, coordinates.get_y() * 25, null, null);
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
                move_tracker = 1;
                moveLeft();
            }
            case 38 -> {
                move_tracker = 1;
                moveUp();
            }
            case 39 -> {
                move_tracker = 1;
                moveRight();
            }
            case 40 -> {
                move_tracker = 1;
                moveDown();
            }
            default -> System.out.println(e.getKeyCode());
        }
    }

    public int getMove_tracker() {
        return move_tracker;
    }

    public void setMove_tracker() {
        move_tracker = 0;
    }


    @Override
    public void keyReleased(KeyEvent e) { }
}

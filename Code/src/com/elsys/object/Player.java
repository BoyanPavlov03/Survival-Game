package com.elsys.object;

import com.elsys.Coordinates;
import com.elsys.LoadImages;
import com.elsys.Main;

import java.awt.*;

public class Player implements GameObject{
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

    @Override
    public void paint(Graphics2D g, Coordinates coords) {
        g.drawImage(LoadImages.imgPlayer,coordinates.get_x() * Main.pixel_size, coordinates.get_y() * Main.pixel_size, null, null);
    }

    @Override
    public String type() {
        return "player";
    }


    public int getMove_tracker() {
        return move_tracker;
    }

    public void setMove_tracker(int i) {
        move_tracker = i;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}

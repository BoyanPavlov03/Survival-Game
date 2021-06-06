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
    int damage;
    boolean dead = false;
    Coordinates coordinates;

    public Inventory inventory;

    int move_tracker = 0;

    public Player(int max_hp, int max_hunger, int max_thirst, int x, int y, int damage) {
        this.curr_hp = max_hp;
        this.max_hp = max_hp;
        this.curr_hunger = max_hunger;
        this.max_hunger = max_hunger;
        this.curr_thirst = max_thirst;
        this.max_thirst = max_thirst;
        this.damage = damage;
        this.coordinates = new Coordinates(x, y);
        this.inventory = new Inventory(20);
    }

    public int getDamage() {
        return damage;
    }

    public void takeDamage(int damage) {
        this.curr_hp -= damage;
        if (curr_hp < 0) {
            dead = true;
        }
    }

    public void getHungry(int hunger) {
        this.curr_hunger -= hunger;
        if (curr_hunger <= 0) {
            curr_hunger = 0;
            takeDamage(1);
        }
    }

    public void getThirsty(int thirst) {
        this.curr_thirst -= thirst;
        if (curr_thirst <= 0) {
            curr_thirst = 0;
            takeDamage(1);
        }
    }

    public boolean isDead() {
        return dead;
    }

    @Override
    public void paint(Graphics2D g, Coordinates coordinates) {
        g.clearRect(800, 0, 350, 500);
        g.setFont(new Font("TimesRoman", Font.BOLD, 25));
        g.drawString("Health: " + curr_hp + "/" + max_hp, 800, 35);
        g.drawString("Hunger: " + curr_hunger + "/" + max_hunger, 800, 70);
        g.drawString("Thirst: " + curr_thirst + "/" + max_thirst, 800, 105);
        inventory.drawInventoryItems(g);
        g.drawImage(Main.loadImages.imgPlayer, coordinates.get_x() * Main.pixel_size, coordinates.get_y() * Main.pixel_size, null, null);
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

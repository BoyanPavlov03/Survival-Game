package com.elsys.object;

import com.elsys.Coordinates;

public class Player implements GameObject{
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

    @Override
    public String type() {
        return "player";
    }
}

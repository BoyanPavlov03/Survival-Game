package com.elsys.object;

public abstract class Animal implements GameObject{
    int curr_health;
    int max_health;
    int dead_check = 0;

    public Animal(int max_health) {
        this.curr_health = max_health;
        this.max_health = max_health;
    }

    public int getDead_check() {
        return dead_check;
    }

    public boolean take_dmg(int damage){
        curr_health -= damage;
        if(curr_health < 0) return true;
        return false;
    }
}

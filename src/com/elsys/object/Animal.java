package com.elsys.object;

public abstract class Animal implements GameObject{
    int curr_health;
    int max_health;

    public Animal(int max_health) {
        this.curr_health = max_health;
        this.max_health = max_health;
    }

    public boolean take_dmg(int damage){
        curr_health -= damage;
        return curr_health < 0;
    }
}

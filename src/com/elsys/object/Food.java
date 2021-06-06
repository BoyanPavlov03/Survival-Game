package com.elsys.object;

public abstract class Food extends Item implements Stackable{
    int hunger_restore;
    int health_restore;

    public Food(int hunger_restore, int health_restore) {
        this.hunger_restore = hunger_restore;
        this.health_restore = health_restore;
    }
}

package com.elsys.object;

import com.elsys.Coordinates;

import java.awt.*;

public abstract class Food extends Item implements Stackable{
    int hunger_restore;
    int health_restore;

    public Food(int hunger_restore, int health_restore) {
        this.hunger_restore = hunger_restore;
        this.health_restore = health_restore;
    }
}

package com.elsys.recipe;

import com.elsys.object.Item;

import java.util.HashMap;

public abstract class Recipe {
    String name;
    HashMap<Item, Integer> recipe;

    public Recipe(String name) {
        this.name = name;
        this.recipe = new HashMap<>();
    }
}
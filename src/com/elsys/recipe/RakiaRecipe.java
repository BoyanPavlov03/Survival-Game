package com.elsys.recipe;

import com.elsys.object.Apple;
import com.elsys.object.BottleOfWater;
import com.elsys.object.Stick;

public class RakiaRecipe extends Recipe {
    public RakiaRecipe(String name) {
        super(name);
        this.recipe.put(new BottleOfWater(),1);
        this.recipe.put(new Stick(), 5);
        this.recipe.put(new Apple(), 5);
    }
}

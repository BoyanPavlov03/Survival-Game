package com.elsys.recipe;

import com.elsys.object.Stick;
import com.elsys.object.StoneBrick;

public class AxeRecipe extends Recipe {
    public AxeRecipe(String name) {
        super(name);
        this.recipe.put(new Stick(), 5);
        this.recipe.put(new StoneBrick(), 7);
    }
}

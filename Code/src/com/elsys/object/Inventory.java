package com.elsys.object;

import java.util.ArrayList;

public class Inventory {
    static class InventoryItem {
        Item item;
        int count;

        public InventoryItem(Item item, int count) {
            this.item = item;
            this.count = count;
        }
    }
    protected ArrayList<InventoryItem> inventory;
    int max_stack_size;

    public Inventory(int max_stack_size) {
        this.inventory = new ArrayList<>();
        this.max_stack_size = max_stack_size;
    }

    public ArrayList<InventoryItem> getInventory() {
        return inventory;
    }

    public void add_item(Item new_item) {
        if (new_item instanceof Stackable) {
            for (InventoryItem inventoryItem : inventory) {
                if (inventoryItem.item.type().equals(new_item.type()) && inventoryItem.count < max_stack_size) {
                    inventoryItem.count++;
                    return;
                }
            }
        }
        inventory.add(new InventoryItem(new_item, 1));
    }
}

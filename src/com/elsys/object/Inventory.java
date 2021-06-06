package com.elsys.object;

import com.elsys.Coordinates;
import com.elsys.Main;

import java.awt.*;
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
                    print_inventory();
                    return;
                }
            }
        }
        inventory.add(new InventoryItem(new_item, 1));
        print_inventory();
    }

    public void print_inventory() {
        for (InventoryItem inventoryItem : inventory) {
            System.out.println(inventoryItem.item.type() + ": " + inventoryItem.count);
        }
        System.out.println();
    }

    public void drawInventoryItems(Graphics g) {
        int counter = 1;
        g.drawString("Inventory :", 800 , 140);
        int x = 800;
        int y = 175;
        for (InventoryItem inventoryItem : inventory) {
            if (inventoryItem != null) {
                g.drawString(counter + ". " + inventoryItem.item.type() + ": " + inventoryItem.count, x , y);
                y += 35;
                counter++;
            }
        }

        int blocks_count = Main.visible_board_blocks_count;
        for (int i = 0; i < blocks_count; i++) {
            g.drawRect(i * Main.pixel_size, blocks_count * Main.pixel_size, Main.pixel_size, Main.pixel_size);
            if (inventory.size() > i) {
                inventory.get(i).item.paint((Graphics2D) g, new Coordinates(i, blocks_count));
                g.drawString(String.valueOf(inventory.get(i).count), i * Main.pixel_size, (blocks_count + 1) * Main.pixel_size);
            }
        }

        // Vertical Line
        g.drawLine((blocks_count) * Main.pixel_size, 0, (blocks_count) * Main.pixel_size, (blocks_count + 1) * Main.pixel_size);
    }
}

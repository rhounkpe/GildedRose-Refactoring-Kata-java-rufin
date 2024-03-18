package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItemInventory() {
        for (Item item : items) {
            InventoryItem.create(item).updateItemEveryday();
        }
    }

}

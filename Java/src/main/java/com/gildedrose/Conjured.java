package com.gildedrose;

public class Conjured extends InventoryItem {
    public Conjured(Item item) {
        super(item);
    }

    @Override
    protected void decreaseQuality() {
        item.quality = Math.max(0, item.quality - 2);
    }
}

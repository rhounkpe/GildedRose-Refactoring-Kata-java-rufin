package com.gildedrose;

public class InventoryItem {
    private Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    protected void decreaseQuality(Item item) {
        item.quality--;
    }

    protected void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    protected void handleExpire(Item item) {
        if (item.sellIn < 0) {
            if (item.name.equals("Aged Brie")) {
                increaseQuality(item);
            } else {
                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    item.quality = 0;
                } else {
                    if (item.quality > 0) {
                        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            return;
                        }
                        decreaseQuality(item);
                    }
                }
            }
        }
    }

    protected void updateItemExpiration(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        item.sellIn--;
    }

    protected void updateQuality(Item item) {
        if (item.name.equals("Aged Brie")) {
            increaseQuality(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQuality(item);

            if (item.sellIn < 11) {
                increaseQuality(item);
            }

            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        } else {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                return;
            }
            if (item.quality > 0) {
                decreaseQuality(item);
            }
        }
    }

    public void updateItemEveryday(Item item) {
        updateQuality(item);

        updateItemExpiration(item);

        handleExpire(item);
    }
}

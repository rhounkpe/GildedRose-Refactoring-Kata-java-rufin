package com.gildedrose;

public class InventoryItem {
    private Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    public static InventoryItem create(Item item) {
        return new InventoryItem(item);
    }

    protected void decreaseQuality() {
        item.quality--;
    }

    protected void increaseQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    protected void handleExpire() {
        if (item.sellIn < 0) {
            if (item.name.equals("Aged Brie")) {
                increaseQuality();
            } else {
                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    item.quality = 0;
                } else {
                    if (item.quality > 0) {
                        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            return;
                        }
                        decreaseQuality();
                    }
                }
            }
        }
    }

    protected void updateItemExpiration() {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        item.sellIn--;
    }

    protected void updateQuality() {
        if (item.name.equals("Aged Brie")) {
            increaseQuality();
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQuality();

            if (item.sellIn < 11) {
                increaseQuality();
            }

            if (item.sellIn < 6) {
                increaseQuality();
            }
        } else {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                return;
            }
            if (item.quality > 0) {
                decreaseQuality();
            }
        }
    }

    public void updateItemEveryday() {
        updateQuality();

        updateItemExpiration();

        handleExpire();
    }
}

package com.gildedrose;

public class InventoryItem {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
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
            if (item.name.equals(AGED_BRIE)) {
                increaseQuality();
            } else {
                if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                    item.quality = 0;
                } else {
                    if (item.quality > 0) {
                        if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                            return;
                        }
                        decreaseQuality();
                    }
                }
            }
        }
    }

    protected void updateItemExpiration() {
        if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            return;
        }
        item.sellIn--;
    }

    protected void updateQuality() {
        if (item.name.equals(AGED_BRIE)) {
            increaseQuality();
        } else if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
            increaseQuality();

            if (item.sellIn < 11) {
                increaseQuality();
            }

            if (item.sellIn < 6) {
                increaseQuality();
            }
        } else {
            if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
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

package com.gildedrose;

class GildedRose {
    Item[] items;

    static String backstagePasses = "Backstage passes to a TAFKAL80ETC concert";
    static String agedBrie = "Aged Brie";
    static String sulfuras = "Sulfuras, Hand of Ragnaros";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            if (!items[i].name.equals(agedBrie)
                    && !items[i].name.equals(backstagePasses)) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals(sulfuras)) {
                        this.decreaseQuality(items[i]);
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    this.increaseQuality(items[i]);

                    if (items[i].name.equals(backstagePasses)) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                this.increaseQuality(items[i]);
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                this.increaseQuality(items[i]);
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals(sulfuras)) {
                this.decreaseSellIn(items[i]);
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals(agedBrie)) {
                    if (!items[i].name.equals(backstagePasses)) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals(sulfuras)) {
                                this.decreaseQuality(items[i]);
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        this.increaseQuality(items[i]);
                    }
                }
            }
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    private void increaseQuality(Item item) {
        item.quality++;
    }

    private void decreaseQuality(Item item) {
        item.quality--;
    }
}

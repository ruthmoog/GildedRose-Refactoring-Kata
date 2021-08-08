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
            updateQualityOfItem(items[i]);
        }
    }

    private void updateQualityOfItem(Item item) {
        if (!item.name.equals(agedBrie)
                && !item.name.equals(backstagePasses)) {
            if (item.quality > 0) {
                if (!item.name.equals(sulfuras)) {
                    this.decreaseQuality(item);
                }
            }
        } else {
            if (item.quality < 50) {
                this.increaseQuality(item);

                if (item.name.equals(backstagePasses)) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            this.increaseQuality(item);
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            this.increaseQuality(item);
                        }
                    }
                }
            }
        }

        if (!item.name.equals(sulfuras)) {
            this.decreaseSellIn(item);
        }

        if (item.sellIn < 0) {
            if (!item.name.equals(agedBrie)) {
                if (!item.name.equals(backstagePasses)) {
                    if (item.quality > 0) {
                        if (!item.name.equals(sulfuras)) {
                            this.decreaseQuality(item);
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                if (item.quality < 50) {
                    this.increaseQuality(item);
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

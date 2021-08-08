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
        boolean isAgedBrie = item.name.equals(agedBrie);
        boolean isBackstagePasses = item.name.equals(backstagePasses);
        boolean isSulfuras = item.name.equals(sulfuras);

        if (!isAgedBrie && !isBackstagePasses) {
            if (item.quality > 0 && !isSulfuras) {
                this.decreaseQuality(item);
            }
        } else {
            if (item.quality < 50) {
                this.increaseQuality(item);

                if (isBackstagePasses) {
                    if (item.sellIn < 11 && item.quality < 50) {
                        this.increaseQuality(item);
                    }

                    if (item.sellIn < 6 && item.quality < 50) {
                        this.increaseQuality(item);
                    }
                }
            }
        }

        if (!isSulfuras) {
            this.decreaseSellIn(item);
        }

        if (item.sellIn < 0) {
            if (!isAgedBrie) {
                if (!isBackstagePasses) {
                    if (item.quality > 0 && !isSulfuras) {
                        this.decreaseQuality(item);
                    }
                } else {
                    item.quality = 0;
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

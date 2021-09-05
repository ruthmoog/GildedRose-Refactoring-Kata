package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateQualityOfItem(items[i]);
        }
    }

    private void updateQualityOfItem(Item item) {

        switch (item.name) {
            case "Aged Brie":
                if (item.quality < 50) {
                    this.increaseQuality(item);
                }

                this.decreaseSellIn(item);

                if (item.sellIn < 0 && item.quality < 50) {
                    this.increaseQuality(item);
                }
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                if (item.quality < 50) {
                    this.increaseQuality(item);

                    if (item.sellIn < 11 && item.quality < 50) {
                        this.increaseQuality(item);
                    }

                    if (item.sellIn < 6 && item.quality < 50) {
                        this.increaseQuality(item);
                    }
                }

                this.decreaseSellIn(item);

                if (item.sellIn < 0) {
                    item.quality = 0;
                }
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            default:
                if (item.quality > 0) {
                    this.decreaseQuality(item);
                }

                this.decreaseSellIn(item);

                if (item.sellIn < 0 && item.quality > 0) {
                    this.decreaseQuality(item);
                }
                break;
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

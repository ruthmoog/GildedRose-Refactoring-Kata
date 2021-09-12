package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    protected void updateQualityOfItem() {
        if (quality < 50) {
            quality++;
        }

        sellIn--;

        if (sellIn < 0 && quality < 50) {
            quality++;
        }
    }
}

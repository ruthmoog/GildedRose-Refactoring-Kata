package com.gildedrose;

public class BackstagePass extends Item {
    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    protected void updateQualityOfItem() {
        if (quality < 50) {
            quality++;

            if (sellIn < 11 && quality < 50) {
                quality++;
            }

            if (sellIn < 6 && quality < 50) {
                quality++;
            }
        }

        sellIn--;

        if (sellIn < 0) {
            quality = 0;
        }
    }
}

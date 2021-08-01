package com.gildedrose;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void updateQuality() {
        CombinationApprovals.verifyAllCombinations(
            this::doUpdateQuality,
            new String[] {"Blue"},
            new Integer[] {0},
            new Integer[] {0});
    }

    private String doUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        return app.items[0].toString();
    }
}

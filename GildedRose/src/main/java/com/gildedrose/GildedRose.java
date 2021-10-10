package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void addQuality(Item item){
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

    private void decreaseQuality(Item item){
        if (item.quality > 0) {
            item.quality -= 1;
        }
        if (item.sellIn < 0) {
            item.quality -= 1;
        }
    }

    private void HandleQualityIfSellin(Item item){
        if (item.sellIn < 11) {
            addQuality(item);
        }
        if (item.sellIn < 6) {
            addQuality(item);
        }
    }

    private void reinstateQualityToZero(Item item){
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void addQualityWhenExpired(Item item){
        if(item.sellIn < 0){
            addQuality(item);
        }
    }

    public void updateQuality() {
        for (Item item : items) {

            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            if(item.name.equals("Aged Brie")){
                addQuality(item);
                item.sellIn -= 1;
                addQualityWhenExpired(item);
                continue;
            }

            if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
                addQuality(item);

                HandleQualityIfSellin(item);

                item.sellIn -= 1;
                reinstateQualityToZero(item);
                continue;
            }

            if(item.name.equals("Conjured")){
                decreaseQuality(item);
                decreaseQuality(item);
                item.sellIn -= 1;
                continue;
            }

            item.sellIn -= 1;
            decreaseQuality(item);
        }
    }
}
package com.gildedrose;

class GildedRose {
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED = "Conjured";
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
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item){
        if (item.name.equals(SULFURAS)) {
            return;
        }

        if(item.name.equals(AGED)){
            addQuality(item);
            item.sellIn -= 1;
            addQualityWhenExpired(item);
            return;
        }

        if(item.name.equals(BACKSTAGE)){
            addQuality(item);
            HandleQualityIfSellin(item);
            item.sellIn -= 1;
            reinstateQualityToZero(item);
            return;
        }

        if(item.name.equals(CONJURED)){
            decreaseQuality(item);
            decreaseQuality(item);
            item.sellIn -= 1;
            return;
        }

        item.sellIn -= 1;
        decreaseQuality(item);
    }
}
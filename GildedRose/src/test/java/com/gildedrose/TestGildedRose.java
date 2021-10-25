package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
class TestGildedRose {
    @Test
    void ObjectTestAgedQualityIncrease() {
        Item item = new Item("Aged Brie", 20, 40);
        Item[] items = {item};

        GildedRose tst = new GildedRose(items);

        int itm_sl = items[0].sellIn;
        int itm_ql = items[0].quality;

        tst.updateQuality();

        assertEquals(itm_sl - 1, items[0].sellIn);
        assertEquals(itm_ql + 1, items[0].quality);

    }

    @Test
    void ObjectTestAgedAddQualityWhenExpired(){
        Item item = new Item("Aged Brie", -1, 40);
        Item[] items = {item};

        GildedRose tst = new GildedRose(items);

        int itm_ql = items[0].quality;

        tst.updateQuality();

        assertEquals(itm_ql + 2, items[0].quality);
    }

    @Test
    void ObjectTestBackstageQualityIncrease(){
        Item item2 = new Item("Backstage passes to a TAFKAL80ETC concert",10,20);
        Item item3 = new Item("Backstage passes to a TAFKAL80ETC concert",5,32);

        Item[] items = {item2,item3};

        GildedRose tst = new GildedRose(items);

        int itm2_ql = items[0].quality;
        int itm3_ql = items[1].quality;

        tst.updateQuality();

        assertEquals(itm2_ql+2,items[0].quality);
        assertEquals(itm3_ql+3,items[1].quality);

    }
    @Test
    void ObjectTestBackstageQualityMax() {
        Item item1 = new Item("Backstage passes to a TAFKAL80ETC concert",17,50);

        Item[] items = {item1};

        GildedRose tst = new GildedRose(items);

        int itm1_sl = items[0].sellIn;
        int itm1_ql = items[0].quality;

        tst.updateQuality();

        assertEquals(itm1_sl-1,items[0].sellIn);
        assertEquals(itm1_ql,items[0].quality);


    }

    @Test
    void ObjectTestBackstageQualityNull(){
        Item item4 = new Item("Backstage passes to a TAFKAL80ETC concert",0,12);
        Item[] items = {item4};

        GildedRose tst = new GildedRose(items);

        tst.updateQuality();

        assertEquals(0,items[0].quality);

    }

    @Test
    void ObjectTestSulfuras() {
        Item item = new Item("Sulfuras, Hand of Ragnaros",25,80);
        Item[] items = {item};
        GildedRose tst = new GildedRose(items);

        int itm_sl = items[0].sellIn;
        int itm_ql = items[0].quality;

        tst.updateQuality();

        assertEquals(itm_sl,items[0].sellIn);
        assertEquals(itm_ql,items[0].quality);

    }

    @Test
    void ObjectTestConjured(){
        Item item = new Item("Conjured",20,15);
        Item item1 = new Item("Conjured",-1,10);
        Item[] items = {item,item1};

        GildedRose tst = new GildedRose(items);

        int itm_sl = items[0].sellIn;
        int itm_ql = items[0].quality;

        int itm1_sl = items[1].sellIn;
        int itm1_ql = items[1].quality;

        tst.updateQuality();

        //tester la nouvelle fonctionalité DDT - Data Driven Testing

        assertEquals(itm_sl-1,items[0].sellIn);

        //quality

        assertEquals(itm_ql-2,items[0].quality);

        assertEquals(itm1_sl-1,items[1].sellIn);
        assertEquals(itm1_ql-4,items[1].quality);


    }

    @Test
    void OtherObjectTest(){
        Item item1 = new Item("itm1",10,12);
        Item item2 = new Item("itm2",0,5);
        Item[] items = {item1,item2};

        GildedRose tst = new GildedRose(items);

        int itm1_sl = items[0].sellIn;
        int itm2_sl = items[1].sellIn;

        int itm1_ql = items[0].quality;
        int itm2_ql = items[1].quality;

        tst.updateQuality();

        assertEquals(itm1_sl-1,items[0].sellIn);
        assertEquals(itm1_ql-1,items[0].quality);

        assertEquals(itm2_sl-1,items[1].sellIn);
        assertEquals(itm2_ql-2,items[1].quality);
    }

    @Test
    void ToStringTest(){
        Item item = new Item("aged",2,19);
        assertEquals("aged, 2, 19",item.toString());
    }

}

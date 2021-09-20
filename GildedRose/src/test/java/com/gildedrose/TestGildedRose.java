package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
class TestGildedRose {
    @Test
    void ObjectCreationTest(){
        Item item1 = new Item("Aged Brie",20,40);
        Item item2 = new Item("Backstage passes to a TAFKAL80ETC concert",17,50);
        Item item3 = new Item("Sulfuras, Hand of Ragnaros",25,80);
        Item item4 = new Item("Backstage passes to a TAFKAL80ETC concert",10,20);
        Item item5 = new Item("Backstage passes to a TAFKAL80ETC concert",5,32);
        Item item6 = new Item("Backstage passes to a TAFKAL80ETC concert",0,12);
        Item item7 = new Item("itm1",10,12);
        Item item8 = new Item("itm2",0,5);


        Item[] items;
        items = new Item[8];
        items[0] = item1;
        items[1] = item2;
        items[2] = item3;
        items[3] = item4;
        items[4] = item5;
        items[5] = item6;
        items[6] = item7;
        items[7] = item8;

        GildedRose tst = new GildedRose(items);

        //valeur des champs avant d'appliquer la methode update

        int itm1_sl = items[0].sellIn; //sellin pour le 1er item
        int itm2_sl = items[1].sellIn; //sellin pour le 2eme item
        int itm3_sl = items[2].sellIn; //sellin pour le 3eme item
        int itm4_sl = items[3].sellIn; //sellin pour le 4eme item
        int itm5_sl = items[4].sellIn; //sellin pour le 5eme item
        int itm6_sl = items[5].sellIn; //sellin pour le 6eme item
        int itm7_sl = items[6].sellIn; //sellin pour le 7eme item
        int itm8_sl = items[7].sellIn; //sellin pour le 8eme item

        int itm1_ql = items[0].quality; //quality pour le 1er item
        int itm2_ql = items[1].quality; //quality pour le 2eme item
        int itm3_ql = items[2].quality; //quality pour le 3eme item
        int itm4_ql = items[3].quality; //quality pour le 4eme item
        int itm5_ql = items[4].quality; //quality pour le 5eme item
        int itm6_ql = items[5].quality; //quality pour le 6eme item
        int itm7_ql = items[6].quality; //quality pour le 7eme item
        int itm8_ql = items[7].quality; //quamity pour le 8eme item


        tst.updateQuality();

        //pour tester que les valeurs qualite et sellin ne change pas pour cet item "Sulfuras, Hand of Ragnaros"
        assertEquals(itm3_sl,items[2].sellIn);
        assertEquals(itm3_ql,items[2].quality);

        // pour tester que la valeur qualiter augmente et sellin diminue pour cet item "Aged Brie"
        assertEquals(itm1_sl-1,items[0].sellIn);
        assertEquals(itm1_ql+1,items[0].quality);

        // pour tester que la valeur qualiter augmente et sellin diminue "Backstage passes to a TAFKAL80ETC concert"
        assertEquals(itm2_sl-1,items[1].sellIn);
        assertEquals(itm2_ql,items[1].quality);

        //pour tester la qualite de "Backstage passes to a TAFKAL80ETC concert"
        assertEquals(itm4_ql+1*2,items[3].quality);

        //pour tester que la qualite de "Backstage passes to a TAFKAL80ETC concert" se met à 0 apres que le sellin est inferieur à 0
        assertEquals(0,items[5].quality);

        //pour tester les autres type d'item

        assertEquals(itm7_sl-1,items[6].sellIn);
        assertEquals(itm7_ql-1,items[6].quality);

        assertEquals(itm8_sl-1,items[7].sellIn);
        assertEquals(itm8_ql-1*2,items[7].quality);
    }
}

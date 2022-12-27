package lsg;

import lsg.armor.*;
import lsg.characters.Hero;

import java.net.ServerSocket;

public class Test {
    public static void main (String[] args) {
//        Hero hero = new Hero();
//        ArmorItem armor1 = new BlackWitchVeil();
//        ArmorItem armor2 = new DragonSlayerLeggings();
//        ArmorItem armor3 = new RingedKnightArmor();
//        hero.setArmortItem( armor1, 1);
////        hero.setArmortItem( armor2, 2);
//        hero.setArmortItem( armor3, 3);
//        ArmorItem[] newTab = new ArmorItem[hero.getArmorItems().length];
//        newTab = hero.getArmorItems();
//        for(int i=0; i<hero.getArmorItems().length; i++){
//            System.out.println(newTab[i].toString() );
//        }
//        System.out.println(hero.armorToString(hero.armor));

        String a ="";
        for (int t = 0; t<12; t++) {
            if (t < 10) a = "0" + t;
            else a = "" + t;
            System.out.printf("%s\n", a);
        }
    }

}

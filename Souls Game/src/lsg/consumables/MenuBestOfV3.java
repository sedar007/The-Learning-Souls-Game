package lsg.consumables;

import lsg.consumables.drinks.*;
import lsg.consumables.food.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

public class MenuBestOfV3 extends HashSet<Consumable>{
    HashSet menu = new HashSet();

    public MenuBestOfV3() {

        menu.add(new Hamburger());
        menu.add(new Wine());
        menu.add(new Americain());
        menu.add(new Coffee());
        menu.add(new Whisky());
    }

    public String toString() {
        int i = 1;
        Iterator<Consumable> iterator = menu.iterator();
        String mot = String.format("%s : \n", this.getClass().getSimpleName());

        while(iterator.hasNext()){
            mot += String.format("%d : ", i );
            mot += iterator.next().toString() + "\n";
            i++;
        }
        return mot;
    }
    public void printStats(){
        System.out.println(this.toString());
    }

    public static void main (String[] args) {
        MenuBestOfV3 menu = new MenuBestOfV3();
        menu.printStats();



    }


}

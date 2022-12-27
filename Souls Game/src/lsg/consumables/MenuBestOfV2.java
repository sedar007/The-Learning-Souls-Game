package lsg.consumables;

import lsg.consumables.drinks.*;
import lsg.consumables.food.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

public class MenuBestOfV2 {
    public int NBR_CONSUMABLE = 0;
    static HashSet<Consumable> menu = new HashSet<Consumable>();

    public MenuBestOfV2() {
        menu = new HashSet<Consumable>();
        menu.add(new Hamburger());
        menu.add(new Wine());
        menu.add(new Americain());
        menu.add(new Coffee());
        menu.add(new Whisky());
        NBR_CONSUMABLE = 5;
    }

    public String toString() {
        Iterator<Consumable> iterator = menu.iterator();
        String mot = String.format("%s : \n", this.getClass().getSimpleName());
        int i = NBR_CONSUMABLE;
        while(iterator.hasNext()){
            mot += String.format("%d : ", ( i - NBR_CONSUMABLE + 1) );
            mot += iterator.next().toString() + "\n";
            i++;

        }
        return mot;
    }
    public void printStats(){
        System.out.println(this.toString());
    }

    public static void main (String[] args) {
        MenuBestOfV2 menu = new MenuBestOfV2();
        menu.printStats();



    }


}

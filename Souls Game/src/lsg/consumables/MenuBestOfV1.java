package lsg.consumables;

import lsg.consumables.drinks.Coffee;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;

import java.util.Locale;

public class MenuBestOfV1 {
    public int MAX_CONSUMABLE = 5;
    public static Consumable[] menu;

    public MenuBestOfV1() {
        menu = new Consumable[]{new Hamburger(), new Wine(), new Americain(), new Coffee(), new Whisky()};
    }

    public String toString() {
        String mot = String.format("%s : \n", this.getClass().getSimpleName());
        for (int i = 0; i < MAX_CONSUMABLE; i++) {
            mot += String.format("%d : ", i + 1);
            mot += menu[i].toString() + "\n";
        }
        return mot;
    }
    public void printStats(){
        System.out.println(this.toString());
    }

    public static void main (String[] args) {
        MenuBestOfV1 menu = new MenuBestOfV1();
        menu.printStats();

    }


}

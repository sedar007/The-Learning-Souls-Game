package lsg;

import lsg.armor.ArmorItem;
import lsg.armor.*;
import lsg.buffs.rings.*;
import lsg.buffs.talismans.*;
import lsg.characters.Character;
import lsg.characters.*;
import lsg.consumables.*;

import lsg.consumables.drinks.*;

import lsg.consumables.food.*;
import lsg.helpers.Dice;
import lsg.weapons.*;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import lsg.consumables.*;


public class LearningSoulsGame {
        static Hero hero = new Hero(); // initialise un hero
        static Monster  monster = new Monster(); // initialise un monstre
        static Scanner scanner = new Scanner(System.in); // methode pour l'entrer de valeur
        static public String  BULLET_POINT = "\u2219 ";


        public static void refresh(){ // Affiche les statistiques pour chaque charactere
            hero.printStats();
            System.out.print(BULLET_POINT); hero.getWeapon().printStats();
            System.out.print(BULLET_POINT); hero.getConsumable().printStats(); System.out.println();

            monster.printStats();
            System.out.println("");
        }
    public static String winner(){

        if(hero.isAlive()) return hero.getName();
        if(monster.isAlive()) return monster.getName();
        return "Personne";
    }

    public static boolean Jouer(Character character1, Character character2){
            return  ( ( character1.isAlive()  && character2.isAlive() ) && (character2.getStamina() != 0 || character1.getStamina() != 0) );
    }
    public static void attack(Character att, Character def){
        int attack = att.attack();
        int damage = def.getHitWith(attack);
        String damageString = "";
        if (damage < 10) damageString = "00" + damage;
        if (damage < 100) damageString = "0" + damage;
        else damageString = ""+damage;


        System.out.printf("!!!%s attack %s with %s (%d) !!! -> Effective DMG: %s PV\n", att.getName(),
                def.getName(), att.getWeapon().getName(), attack, damageString);

    }

    public static void fight1v1() {
            boolean partie = true;
            while (partie) {

            if(!Jouer(hero,monster)){ partie = false; break; }
            refresh();
//            System.out.print("Hit enter key for next move >");
//            scanner.nextLine();
                int action = 0;
                while (action != 1 && action !=2) {
                    System.out.print("Hero's action for next move : (1) attack | (2) consume > ");
                    action = scanner.nextInt();
                }
                if (action == 1 ) attack(hero, monster);
                if (action == 2) hero.use(hero.getConsumable());
                System.out.println();

                refresh();


            if(!Jouer(monster,hero)){ partie = false; break;}
            attack(monster, hero);
            System.out.println();
        }
        System.out.println();
        refresh();
        System.out.printf("--- %s WINS", winner());
    }


    public static void init(){ // Permet d'initialiser la partie
            Weapon sword = new Sword();
            hero.setWeapon(sword);
            hero.setConsumable(new Hamburger());
//            Weapon claw = new Claw();
//            Weapon arme = new ShotGun();
            monster.setWeapon(new Claw());
    }
    public static void title(){
            String mot = String.format("##################################\n" +
                                        "#\tTHE LEARNING SOULS GAME\t\t #\n"
                                            +"##################################");
            System.out.println(mot);
    }
    public  static void play_v1(){
            init();
            fight1v1();
    }
    public  static void play_v2(){
        init();
        hero.setArmortItem(new BlackWitchVeil(),1);
        hero.setArmortItem(new DragonSlayerLeggings(),2);

        fight1v1();
    }
    public  static void play_v3(){
        init();
        hero.setArmortItem(new BlackWitchVeil(),1);
        hero.setArmortItem(new DragonSlayerLeggings(),2);
        monster = new Lycanthrope();

        fight1v1();

    }

    public  static void play_v4(){
        init();
        hero.setArmortItem(new BlackWitchVeil(),1);
        hero.setArmortItem(new DragonSlayerLeggings(),2);
        hero.setArmortItem(new RingedKnightArmor(),3);


        hero.setRing(new RingOfSwords(),3);
        hero.setRing(new DragonSlayerRing(),1);
        hero.setRing(new RingOfDeath(),2);

        monster = new Lycanthrope();
        monster.setTalisman(new MoonStone(),1);

        fight1v1();
    }

    public static void createExhaustedHero(){

            hero.getHitWith(99);
            hero.setWeapon(new Weapon("Grosse Arme", 0, 0, 1000, 100));
            hero.attack();

            System.out.println("Create exhausted hero: ");
            hero.printStats();  System.out.println();
    }

    public static void aTable(){
        MenuBestOfV4 menu = new MenuBestOfV4();

        // Methode 1
        for (Object i: menu.linkedHashSet){
            Consumable  consumable  = (Consumable) i;
            hero.use(consumable);
            hero.printStats();
            System.out.print(String.format("Apres utilisation: "));
            consumable.printStats(); System.out.println();
        }
        hero.use(menu.cadeau);
        hero.printStats();
        System.out.print(String.format("Apres utilisation: "));
        menu.cadeau.printStats();
       hero.getWeapon().printStats();


        //Methode 2
        /*
        while(menu.iterator.hasNext()){
            Consumable  consumable  =menu.iterator.next();
            hero.use(consumable);
            hero.printStats();
            System.out.print(String.format("Apres utilisation: "));
            consumable.printStats(); System.out.println();
        }
        */


    }

    public static void main (String[] args) {
        title();
//        play_v1();


//        System.out.println("OKK");
//        play_v2();
//        play_v3();
        play_v4();
//        createExhaustedHero();
//        aTable();








    }


}

//        public static void fight1v1() {
//            while (monster.isAlive() && hero.getStamina() > 0 && hero.isAlive() && monster.getStamina() > 0) {
//                refresh();
//                System.out.print("Hit enter key for next move >");
//                scanner.nextLine();
//                int attack = hero.attack();
//                int damage = monster.getHitWith(attack);
//                System.out.printf("!!!%s attack %s with %s (%d) !!! -> Effective DMG: %d PV\n", hero.getName(),
//                        monster.getName(), hero.getWeapon().getName(), attack, damage);
//
//                if(!monster.isAlive() && hero.getStamina() <= 0 && !hero.isAlive() && monster.getStamina() <= 0){
//                    break;
//                }
//                attack = monster.attack();
//                damage = hero.getHitWith(attack);
//                System.out.printf("!!!%s attack %s with %s (%d) !!! -> Effective DMG: %d PV\n", monster.getName(),
//                        hero.getName(), monster.getWeapon().getName(), attack, damage);
//
//            }
//            System.out.println();
//            refresh();
//            System.out.printf("%s a gagne", winner());
//        }

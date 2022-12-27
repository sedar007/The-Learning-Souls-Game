package lsg.characters;

import lsg.armor.*;
import lsg.buffs.rings.*;

import lsg.helpers.Dice;

public class Hero extends Character {

    //    public Dice de = new Dice(101);
    private static int MAX_ARMOR_PIECES = 3; // Max Armoe
    private static int MAX_RING_PIECES = 2; // Max Ring

    public ArmorItem[] armor = new ArmorItem[MAX_ARMOR_PIECES]; // Tableau representant l'ensemble des armors
    public Ring[] ring = new Ring[MAX_RING_PIECES]; // Tableau representant l'ensemble des Rings

    public Hero(String name) {
        super(name, 100, 100, 50, 50);
    }

    public Hero() {
        this("Gregooninator"); // nom par defaut
    }

    //Affichage dans le console
    public void printStats() {
        System.out.println(this.toString());
    }

    public void setArmortItem(ArmorItem armorEntrer, int slot) { // Permet de stocker les armors entrer
        slot--; // diminue l'indice de 1
        if (slot >= 0 && slot < MAX_ARMOR_PIECES) { // si c inferieur a la valeur max et superieur ou egal a 0
            armor[slot] = armorEntrer;
        }
    }

    public float getTotalArmor() { // Permet de faire la somme des valeurs des armors qui sont present dans le tableau
        float som = 0.f;
        for (int i = 0, n = MAX_ARMOR_PIECES; i < n; i++) {
            if (armor[i] != null) { // Faire la somme si et seulement l'armor a ete enseigne
                som += armor[i].getArmorValue(); // Recupere sa valeur avec getArmorValue
            }
        }
        return som;
    }

    public String armorToString() { // Permet d'afficher les caracteristiques des armors present dans le tableau
        String ar = "ARMOR ";
        for (int i = 0, n = MAX_ARMOR_PIECES; i < n; i++) {
            ar += String.format("\t%d:", i+1);

            if (armor[i] != null) {
                ar += armor[i].toString();
            }
            else {
                ar += "empty";
            }
            ar += "\t";
        }
        ar += String.format("\tTOTAL: %.2f",getTotalArmor());
        return ar;
    }

    public ArmorItem[] getArmorItems(){ // Construit un autre tableu qui stocke les armors effectivent du tableau
        int j = 0;
        for(int i = 0; i< MAX_ARMOR_PIECES; i++){ // Permet de compter le nombre reel d'armor saisit
            if (armor[i] != null){
                j++;
            }
        }
        ArmorItem[] newArmor = new ArmorItem[j]; // construit un tableau qui va stocker les armors reels
        int t = 0;
        for(int i = 0; i<3; i++){
            if (armor[i] != null){ // Si c different de null, c que l'armor a ete rensseigner, Donc je peux le stocker dans mon new tableau
                newArmor[t] = armor[i];
                t++;
            }
        }
        return newArmor;
    }
    public float computeProtection(){
        return  getTotalArmor();
    } // renvoie la valeur totale de l'ensemble des armors

    public void setRing(Ring ringEntrer, int slot) {
        slot--;
        if (slot >= 0 && slot < MAX_RING_PIECES) {
            ring[slot] = ringEntrer;
            ringEntrer.setHero(this);
        }
    }



    public float getTotalRing() {
        float som = 0;
        for (int i = 0, n = MAX_RING_PIECES; i < n; i++) {
            if (ring[i] != null) {
                som += ring[i].computeBuffValue();
            }
        }
        return som;
    }



    public String RingToString() {
        String ar = "RING ";
        for (int i = 0, n = MAX_RING_PIECES; i < n; i++) {
            ar += String.format("\t%d:", i+1);

            if (ring[i] != null) {
                ar += ring[i].toString();
            } else {
                ar += "empty";
            }
            ar += "\t";
        }
        ar += String.format("\tTOTAL: %.2f",getTotalRing());
        return ar;
    }



    public Ring[] getRingItems(){
        int j = 0;
        for(int i = 0; i< MAX_RING_PIECES; i++){
            if (ring[i] != null){
                j++;
            }
        }
        Ring[] newRing = new Ring[j];
        int t = 0;
        for(int i = 0; i<3; i++){
            if (ring[i] != null){
                newRing[t] = ring[i];
                t++;
            }
        }
        return newRing;
    }



    public float computeBuff(){
        return  getTotalRing();
    }

    public static void main (String[] args) {
        Hero hero = new Hero();

        ArmorItem armor1 = new BlackWitchVeil();
        ArmorItem armor2 = new DragonSlayerLeggings();
        ArmorItem armor3 = new RingedKnightArmor();
//        hero.setArmortItem( armor1, 1);

//        hero.setArmortItem( armor2, 2);
        hero.setArmortItem( armor3, 3);
 ;
//        for(int i=0; i<hero.getArmorItems().length; i++){
//            System.out.println(hero.getArmorItems()[i].toString() );
//        }
//        System.out.println(hero.armorToString(hero.armor));
        hero.printStats();

    }
}

//    public int life = 100, maxLife = 100, stamina = 50, maxStamina = 50; // les attributs de l'objet
//    private String DEFAULT_NAME = "Gregooninator"; // nom par defaut

//    int nbr_hero = 7;
//    int nbrTabNom_Hero = 3;
//
//    String name[] = new String[nbrTabNom_Hero];
//        name[0] = "paul";
//                name[1] = "Jack";
//                name[2] = "Pierre";
//
//
//                Hero tabHero[] = new Hero[nbr_hero];
//
//                for(int i=0, nbr = nbr_hero; i<nbr; i++){
//
//        Hero h = (i < nbrTabNom_Hero) ? new Hero(name[i]) : new Hero();
//        tabHero[i] = h;
//        }
//        for(int i = 0, nbr = nbr_hero; i<nbr; i++){
//        tabHero[i].printStats();
//        }
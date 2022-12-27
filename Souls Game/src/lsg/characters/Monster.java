package lsg.characters;
import lsg.buffs.talismans.*;

import lsg.buffs.rings.Ring;

public class Monster extends Character {

    private static int INSTANCES_COUNT = 0; // Nombre totals de monstre
    private static void nouveauMonstre(){ // Augmente le nbre total de monstre
        INSTANCES_COUNT++;
    } // Augemente le nombre de monstre
    private float skinThickness = 20.f;
    private static int MAX_TALISMAN_PIECES = 1;
    public Talisman[] talisman = new Talisman[MAX_TALISMAN_PIECES];



    public float getSkinThickness(){return skinThickness;}
    public void setSkinThickness(float skinThickness){this.skinThickness = skinThickness;}


    public Monster(String name){
        super(name, 10 , 10 , 10 , 10 );
        nouveauMonstre();// Augmente le nombre de monstre
    }
    public Monster(){
        this("Monster_"+ (INSTANCES_COUNT + 1) );
        nouveauMonstre(); // Augmente le nombre de monstre
    }

    public void setTalisman(Talisman talismanEntrer, int slot) {
        slot--;
        if (slot >= 0 && slot < MAX_TALISMAN_PIECES) talisman[slot] = talismanEntrer;
    }

    public float getTotalTalisman() {
        float som = 0;
        for (int i = 0, n = MAX_TALISMAN_PIECES; i < n; i++) {
            if (talisman[i] != null) {
                som += talisman[i].computeBuffValue(); // ////////////////////////////////////
            }
        }
        return som;
    }

    public String TalismanToString() {
        String ar = "TALISMAN ";
        for (int i = 0, n = MAX_TALISMAN_PIECES; i < n; i++) {
            ar += String.format("\t%d:", i+1);

            if (talisman[i] != null) {
                ar += talisman[i].toString();
            } else {
                ar += "empty";
            }
            ar += "\t";
        }
        ar += String.format("\tTOTAL: %.2f",getTotalTalisman());
        return ar;
    }

    public Talisman[] getRingItems(){
        int j = 0;
        for(int i = 0; i< MAX_TALISMAN_PIECES; i++){
            if (talisman[i] != null){
                j++;
            }
        }
        Talisman[] newTalisman = new Talisman[j];
        int t = 0;
        for(int i = 0; i<3; i++){
            if (talisman[i] != null){
                newTalisman[t] = talisman[i];
                t++;
            }
        }
        return newTalisman;
    }

    public float computeBuff(){
        return  getTotalTalisman();
    }



    public void printStats(){
        System.out.println(this.toString());
    } //Affichage dans le console

    public float computeProtection(){
        return getSkinThickness();
    }

}

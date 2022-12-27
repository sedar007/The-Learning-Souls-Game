package lsg.weapons;

import lsg.consumables.repair.RepairKit;

public class Weapon {
    protected String name;
    protected int minDamage, maxDamage, stamCost, durability;
    public static String DURABILITY_STAT_STRING = "durability";
    public static String STAMINA_STAT_STRING = "stamina";

    public String getName() { return name; }
    public void setNAME(String name) { this.name = name; }

    public int getMaxDamage() { return maxDamage; }
    public void setMaxDamage(int maxDamage) { this.maxDamage = maxDamage; }

    public int getStamCost() { return stamCost; }
    public void setStamCost(int stamCost) { this.stamCost = stamCost; }

    public int getDurability() { return durability; }
    protected void setDurability(int durability) { this.durability = durability; }

    public int getMinDamage() { return minDamage; }
    public void setMinDamage(int minDamage) { this.minDamage = minDamage; }

    public Weapon(String name,int minDamage, int maxDamage, int stamCost, int durability ){ // renseigne les informatios
        setNAME(name);
        setMaxDamage(maxDamage);
        setStamCost(stamCost);
        setDurability(durability);
        setMinDamage(minDamage);
    }

    public void use(){this.durability--;} // diminue la durabilite
    public boolean isBroken(){ return this.durability <=0;} // Verifie si l'arme est casse ou pas

    public void printStats(){
        System.out.println(this.toString());
    } // affiche sur la console

    public String toString() {
        return String.format("%s (min: %d max: %d %s: %d %s: %d)",this.name, this.minDamage, this.maxDamage,STAMINA_STAT_STRING, this.stamCost,DURABILITY_STAT_STRING, this.durability);
    }

    public void repairWith(RepairKit kit){
        setDurability( getDurability() + kit.use());
    }



}

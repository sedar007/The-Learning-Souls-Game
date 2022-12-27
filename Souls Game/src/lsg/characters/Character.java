package lsg.characters;
import lsg.consumables.Consumable;
import lsg.consumables.drinks.Drink;
import lsg.consumables.food.Food;
import lsg.consumables.repair.RepairKit;
import lsg.helpers.Dice;
import lsg.weapons.*;
import java.lang.*;
import java.util.Locale;
import lsg.buffs.BuffItem;


abstract public class Character {
    protected String name; // le nom de mon Hero
    protected int life, maxLife , stamina , maxStamina; // les attributs de l'objet
    public static String LIFE_STAT_STRING = "life";
    public static String STAM_STAT_STRING = "stamina";
    public static String PROTECTION_STAT_STRING = "protection";
    public static String BUFF_STAT_STRING = "buff";
    protected Weapon weapon ;
    public Dice de = new Dice(101);
    private Consumable consumable;

    abstract public float computeProtection();
    abstract public float computeBuff();


    // Les getters	&	les setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getLife() {return life ;}
    public void setLife(int life){this.life = life;}

    public int getMaxLife() {return maxLife ;}
    public void setMaxLife(int maxLife){this.maxLife = maxLife;}

    public int getStamina() {return stamina ;}
    public void setStamina(int stamina){this.stamina = stamina;}

    public int getMaxStamina() {return maxStamina ;}
    public void setMaxStamina(int maxLife){this.maxStamina = maxStamina;}

    public Weapon getWeapon() { return weapon; }
    public void setWeapon(Weapon weapon) { this.weapon = weapon; }

    public Consumable getConsumable() { return consumable; }
    public void setConsumable(Consumable consumable) { this.consumable = consumable; }

    public Character(String name, int life, int maxLife , int stamina , int maxStamina){ // renseigne les informations de mes characteres
        setName(name);
        setLife(life);
        setStamina(stamina);
        setMaxLife(maxLife);
        setMaxStamina(maxStamina);
    }
    private int attackWith(Weapon weapon){

        if(weapon.isBroken()) return 0; //verifie si l'arme est casse /
        //renvoie le nb de degats fourni
        int  damage = ((de.roll() * (weapon.getMaxDamage() - weapon.getMinDamage())) / 100 ) + weapon.getMinDamage();
        if (getStamina() >= weapon.getStamCost()) {
            this.stamina = getStamina() - weapon.getStamCost();
        }
        else {
            damage = damage * getStamina() / weapon.getStamCost();
            this.stamina = 0 ;
        }

        damage = damage + (damage * Math.round(computeBuff())/100 );
        weapon.use(); // diminue la durabilite
        return  damage; // retourne le nb de degats
    }

    public int attack(){ // methode qui fait l'attaque
        return attackWith(weapon);
    }

    public int getHitWith(int value){ // metode qui renvoie le nb de	 points	 de	 vie (PV) effectivement	retirés
        value = computeProtection() >=100? 0 :  Math.round((100-computeProtection())*value / 100);
        value = getLife() - value >= 0? value : getLife();
        this.life = getLife() - value; // met a jour la vie
        return value;
    }

    public boolean isAlive(){ // Verifie si le hero est en vie
        return this.life != 0;
    } // verifie si le charactere est en vie

    public void printStats(){
        System.out.println(this.toString());
    }
    public String toString() {
        String name = this.getClass().getSimpleName(); // recupere le nom de la classe
        String vie = (isAlive()) ? "ALIVE" : "DEAD";
        return String.format(Locale.US,"[ %-7s ] %-15s %s: %-4d %s: %-4d %s: %-4.2f %s: %.2f (%s)  ",name,this.name, LIFE_STAT_STRING,
                this.life,STAM_STAT_STRING,getStamina(), PROTECTION_STAT_STRING,this.computeProtection(),BUFF_STAT_STRING,this.computeBuff(),vie);
    }

    private void drink(Consumable boisson){ // permet de faire boire un charactere
        System.out.println(String.format("%s drinks %s", getName(), boisson.toString()) );
        int stamBoisson = boisson.use(); // recupere la valeur du boisson

        if (  stamBoisson + getStamina()  <= getMaxStamina() ) setStamina( getStamina() + stamBoisson);
        else  setStamina( getMaxStamina() );


    }

    private void eat(Consumable food){ // permet de faire manger un charactere
        System.out.println(String.format("%s eats %s", getName(), food.toString()) );

        int stamFood = food.use(); // recupere la valeur de la nourriture

        if (  stamFood + getLife()  <= getMaxLife() ) setLife( getLife() + stamFood);
        else  setLife( getMaxLife() );
    }

    private void repairWeaponWith(Consumable kit){ // permet de reparer l'arme du charactere
        System.out.println(String.format("%s repairs %s with %s", getName(), weapon.toString() ,  kit.toString()) );
        weapon.repairWith((RepairKit) kit);

    }
    public void	 use(Consumable	 consumable){
        if (consumable instanceof Food ) eat(consumable);
        if (consumable instanceof Drink ) drink(consumable);
        if (consumable instanceof RepairKit) repairWeaponWith( consumable);


    }


}

package lsg.characters;

import lsg.weapons.Claw;
import lsg.weapons.Sword;

public class Lycanthrope extends Monster{
    public Lycanthrope(){
        super("Lycanthrope");
        setWeapon(new Claw());
        setSkinThickness(30);
    }

}

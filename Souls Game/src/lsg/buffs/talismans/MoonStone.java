package lsg.buffs.talismans;

import lsg.buffs.rings.Ring;
import lsg.buffs.rings.RingOfDeath;
import lsg.characters.Hero;
import lsg.characters.Monster;

public class MoonStone extends Talisman {
	
	public MoonStone() {
		super("Moon Stone", 20f, 21, 3);
	}

	public static void main(String[] args) {
		Monster monstre = new Monster() ;
		Talisman r = new MoonStone() ;
		monstre.setTalisman(r, 1);
		System.out.println(monstre.getHitWith(10)) ; // pour abaisser les PV du hero
		System.out.println(monstre);
		System.out.println(r);
//		System.out.println(hero.RingToString() );
	}

}


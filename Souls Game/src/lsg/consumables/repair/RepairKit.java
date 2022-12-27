package lsg.consumables.repair;

import lsg.consumables.Consumable;

import static lsg.weapons.Weapon.*;

public class RepairKit extends Consumable {
    public RepairKit() {
        super(" Repair Kit", 10, DURABILITY_STAT_STRING);
    }
    public int use(){
        setCapacity( getCapacity() - 1);
        return 1;
    }
}

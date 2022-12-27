package lsg.consumables;

import java.util.Locale;

public class Consumable {
    private String	name;
    private int capacity;
    private String stat;


    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getCapacity() { return capacity; }

    public void setCapacity(int capacity) { this.capacity = capacity; }

    public String getStat() { return stat; }

    public void setStat(String stat) { this.stat = stat; }

    public Consumable(String name, int capacity, String stat){
        setName(name);
        setCapacity(capacity);
        setStat(stat);
    }

    public void printStats(){
        System.out.println(this.toString());
    }
    public String toString() { return String.format(Locale.US,"%s [%d %s point(s)]",getName(),getCapacity(), getStat());}

    public int use(){
        int capacite = getCapacity();
        setCapacity(0);
        return  capacite;
    }

}

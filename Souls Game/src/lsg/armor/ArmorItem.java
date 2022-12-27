package lsg.armor;

public class ArmorItem {
    protected String name;
    protected float armorValue;
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public float getArmorValue() {return armorValue;}
    public void setArmorValue(float armorValue) {this.armorValue = armorValue;}

    public ArmorItem(String name, float armorValue){
        setArmorValue(armorValue);
        setName(name);
    }

    public String toString() {
        return String.format("%s(%.2f)",getName(),getArmorValue() );
    } //retourne les statistiques des armors
}
//    public void printStats(){
//        System.out.println(this.toString());
//    }
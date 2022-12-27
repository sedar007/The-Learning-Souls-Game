package lsg.helpers;
import java.util.Random;
public class Dice {
    private int faces;
    Random random = new Random();

    // getter et setter
    public int getFaces() { return faces; }
    public void setFaces(int faces) { this.faces = faces; }

    public Dice(int faces){this.faces = faces;} // renseigne la face

    public int roll(){
        return random.nextInt(this.faces);
    } // retourne un nombre aleatoire
    public void printStats(){
        System.out.println(this.toString());
    } // Affichage dans la console
}

    //    Dice d = new Dice(50);
//        int min = 2000;
//        int max = -1;
//    for(int i =0; i< 500; i++){
//        int t = d.roll();
//        min = (t < min) ? t : min;
//        max = (t > max) ? t : max;
//
//        System.out.println(t);
//        }
//        System.out.println("min "+ min + " max " + max);





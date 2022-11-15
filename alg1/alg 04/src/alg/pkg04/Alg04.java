//ctvrty cviceni, ulohy03
package alg.pkg04;

import java.util.Scanner;

public class Alg04 {
    
    private static final Scanner sc = new Scanner(System.in); //scanner dostupny ve vsech tridach pokud bude public
    private static final float EPS = 1E-6f;


    public static void main(String[] args) {
        //nacteni dat
        System.out.println("pozice bodu vuci kruznici"); //uloha š
        System.out.println("zadej souradnice bodu");
        float x = sc.nextFloat();
        float y = sc.nextFloat();
        System.out.println("zadej souradnice stredu kruznice");
        float kx = sc.nextFloat();
        float ky = sc.nextFloat();
        System.out.println("zadej polomer kruznice");
        float r = sc.nextFloat();
        //vzdalenost bodu od stredu
        float vzd = (float) Math.hypot(kx-x, ky-y);
        //rozhodovani a vypis
        if (vzd < r) System.out.println("uvnitr");
        if (vzd == r) System.out.println("na");
        if (vzd > r) System.out.println("vne");
        System.out.println("");
        if (vzd < r){
            System.out.println("uvnitr");
        } else {
            if (vzd == r){
                System.out.println("na");
            } else {
                System.out.println("vne");
            }
        }
        
        System.out.println("");
        if (vzd < r ) {
            System.out.println("uvnitr");
        } else if (vzd == r) {
            System.out.println("na");
        } else {
            System.out.println("vne");
        }
        
        System.out.println("");
        float eps = r * EPS;
        if (Math.abs(vzd-r) < eps) {
            System.out.println("na");
        } else if (vzd < r) {
            System.out.println("uvnitr");
        } else {
            System.out.println("vne");
        }
    }
    
}

package cv10.cizek;

import java.util.Arrays;
import java.util.Scanner;

public class NahodnaPermutace {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Zadej pocet prvku pole: ");
        int k=sc.nextInt();
        System.out.println(Arrays.toString(vytvorNahodnouPermutaci(k)));
    }
    
    
    public static int[] vytvorNahodnouPermutaci(int n) {
        int t[] = new int[n]; int i=n-1; int rnd;
        while (i>0) {
            rnd=(int) (Math.round(Math.round(Math.random()*(n-1))));
            //musi byt obaleno Math.round dvakrat, abych dostal 0 z posledniho mista vysledku
            //poprve roundne z double na float, podruhe z float na int
            if (t[rnd]==0) {
                t[rnd]=i;
                i--;
            }
        }
        return t;
    }
}

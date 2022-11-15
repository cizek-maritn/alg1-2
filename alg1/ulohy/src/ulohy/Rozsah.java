package ulohy;

import java.util.Scanner;

public class Rozsah {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int pocet; int cislo; int max = Integer.MIN_VALUE; int min=Integer.MAX_VALUE;
        while ((pocet=sc.nextInt())>0) {
            for (int i=1;i<=pocet;i++) {
                cislo=sc.nextInt();
                if (cislo>max) max=cislo;
                if (cislo<min) min=cislo;
            }
            System.out.println(min + " " + max);
            max=Integer.MIN_VALUE; min=Integer.MAX_VALUE;
        }
    }
    
}

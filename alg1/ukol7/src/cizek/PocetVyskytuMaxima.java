package cizek;

import java.util.Scanner;

public class PocetVyskytuMaxima {
    
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Zadej cisla, ukonci 0 nebo zapornym cislem");
        float y;
        float max=0.F;
        int pocet=0;
        while((y=sc.nextFloat())>0) {
            if (y>max) {
                max=y;
                pocet=1;
            } else if (y==max) {
                pocet++;
            }
        
        }
    System.out.println("Maximum je " + max);
    System.out.println("Maximum se vyskytuje " + pocet + "krat.");
    }
}
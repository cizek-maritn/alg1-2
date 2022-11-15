package cizek;

import java.util.Scanner;

public class TestAritmetickePosloupnosti {

    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Zadej pocet cisel posloupnosti.");
        int n = sc.nextInt();
        System.out.println("Zadej cisla.");
        float xOld = sc.nextFloat();
        float xNew = sc.nextFloat();
        float d=xOld-xNew;
        boolean jePosloupnost = true;
        int i = 0;
        while (jePosloupnost && i<n-2) {
            for (;i<n-2;i++) {
                xOld = xNew;
                xNew = sc.nextFloat();
                if (xOld-xNew!=d) {
                    jePosloupnost = false;
                }
            }
        }
        System.out.println( jePosloupnost ? "Posloupnost je aritmeticka." : "Posloupnost neni aritmeticka.");
    } 
}

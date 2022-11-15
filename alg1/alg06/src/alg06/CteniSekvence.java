/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alg06;

import java.util.Scanner;
/**
 *
 * @author Dell
 */
public class CteniSekvence {
    
    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //cteni posloupnosti cisel
        System.out.println("zadej pocet");
        int n = sc.nextInt();
        System.out.println("zadej cisla");
        for (int i = 0; i < n; i++) {
            float x = sc.nextFloat();
            //zpracovani x
        }
        //vysledek zpracovani cele posloupnosti
        
        //posloupnost cisel ukoncena terminatorem(0 nebo zaporna hodnota)
        System.out.println("zadej cisla, ukonci 0 nebo zapornym cislem");
        float y;
        do {
            y = sc.nextFloat();
            if (y>0) {
                //zpracovani y
            }
        } while(y>0);
        //vysledek zpracovani
        
        //druha verze
        y = sc.nextFloat();
        while(y>0) {
            //zpracovani y
        }
        //vysledek posloupnosti
    }
    
}

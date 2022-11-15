/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author martin.cizek
 */
public class KomunikaceSUzivatelem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.println("Zadej cele cislo: ");
        int celeCislo = sc.nextInt();
        System.out.print("Bylo zadano cislo: ");
        System.out.println(celeCislo);
        
        System.out.print("Zadej realne cislo: ");
        float realneCislo = sc.nextFloat();
        System.out.format(Locale.US, "Bylo zadano cislo: %1.3f%n", realneCislo);
        System.out.println("Bylo zadano cislo: " + realneCislo);
        System.out.println("");
        
        System.out.println("Zadej slovo: ");
        String slovo = sc.next();
        System.out.println("Bylo zadano slovo: " + slovo);
        System.out.println("");
        
        System.out.println("Zadej delsi text: ");
        sc.nextLine();
        String veta = sc.nextLine();
        System.out.println("na vstupu jsem obbdrzel: ");
        System.out.println("--"+veta+"--");
        
        System.out.println("");
        System.out.println("Konec programu");
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cizek;

import java.util.Scanner;
import java.util.Locale;
/**
 *
 * @author Dell
 */
public class VypocetUsekoveRychlosti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner (System.in);
        System.out.print("Zadej maximalni povolenou rychlost: ");
        int mxR = sc.nextInt();
        System.out.println("Maximalni povolena rychlost je: " + mxR);
        System.out.println("");
        
        System.out.print("Zadej delku useku v km: ");
        float delka = sc.nextFloat();
        System.out.println("Delka useku je: " + delka + " km");
        System.out.println("");
        
        System.out.print("Zadej casove udaje prujezdu vozidla ve formatu hh mm sec set: ");
        int hh = sc.nextInt();
        int mm = sc.nextInt();
        int sec = sc.nextInt();
        int set = sc.nextInt();
        float r = hh+(mm/60.0f)+(sec/3600.0f)+(set/360000.0f);
        System.out.print("Delka prujezdu vozidla v hodinach je: ");
        System.out.printf("%.3f", r);
        System.out.println("");
        
        float rych = delka/r;
        System.out.print("Prumerna rychlost vozidla v km/h je: ");
        System.out.printf("%.2f", rych);
        System.out.println("");
        
        float pr = rych-mxR;
        if (rych>mxR){
            System.out.print("Maximalni rychlost byla prekrocena o: ");
            System.out.printf("%.2f", pr);
            System.out.println("");
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alg.pkg03;

import java.util.Scanner;
/**
 *
 * @author Dell
 */
public class Alg03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("prevod z hodin a minut na sekundy");
        System.out.print("zadej hodnoty (format hh mm ss): ");
        int hh = sc.nextInt();
        int mm = sc.nextInt();
        int ss = sc.nextInt();
        int fin;
        fin = ss+(mm*60)+(hh*3600);
        
        System.out.print("pocet sekund je: " + fin);
        System.out.println("");
        System.out.print("Prevedu zpet.");
        hh = fin/3600;
        mm = (fin%3600)/60;
        ss = ((fin%3600)%60);
        System.out.format("casovy udaj: %02d:%02d:%02d%n", hh, mm, ss);
    }
    
}

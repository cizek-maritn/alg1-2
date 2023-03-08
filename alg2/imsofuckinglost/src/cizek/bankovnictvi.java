package cizek;

import java.util.InputMismatchException;
import java.util.Scanner;

public class bankovnictvi {

    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean konecProgramu;
        do {
            vypisMenu();
            int volba = nactiVolbu();
            konecProgramu = obsluzVolbu(volba);
        } while(!konecProgramu);
        System.out.println("adios");
    }
    
    private static void vypisMenu() {
        System.out.println("Hlavni menu programu");
        System.out.println("1. nacteni pracovniho adresare");
        
        System.out.println("2. dame da ne");
        System.out.println("0 - konec");
    }
    
    private static int nactiVolbu() {
        int volba;
        try {
            volba = sc.nextInt(); 
        } catch (InputMismatchException ex) {
            volba = -1;
        }
        sc.nextLine();
        return volba;
    }
    
    private static boolean obsluzVolbu(int volba) {
        switch (volba) {
                case 0: return true;
                case 1: obsluhaVolby1(); break; //rename those shits
                case 2: obsluhaVolby2(); break;
                default: 
                    System.out.println("I p");
        }
        return false;
    }

    private static void obsluhaVolby1() {
        System.out.println("");
        System.out.println("drip");
    }

    private static void obsluhaVolby2() {
        System.out.println("");
        System.out.println("bazinga");
    }
}

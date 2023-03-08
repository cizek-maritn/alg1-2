package HadaniCisla;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HraHadaniCisla {

    private static final Scanner sc = new Scanner(System.in);
    private static int horniMez=100;
    private static int dolniMez=1;
    private static final int minInt=10;
    
    public static void main(String[] args) {
        boolean konecProgramu;
        do {
            vypisMenu();
            int volba = nactiVolbu();
            konecProgramu = obsluzVolbu(volba);
        } while(!konecProgramu);
        System.out.println("Koncim.");
    }
    
    private static void vypisMenu() {
        System.out.println("Hlavni menu programu");
        System.out.println("1. Hrat hru, budu hadat");
        System.out.println("2. Hrat hru, budu si myslet cislo");
        System.out.println("3 - Zmena nastaveni");
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
                case 0 -> {
                    return true;
            }
                case 1 -> hratHracHada();
                case 2 -> hratHracMysli();
                case 3 -> zmenaNastaveni();
                default -> System.out.println("spatna volba");
        }
        return false;
    }

    private static void hratHracHada() {
        System.out.println("");
        System.out.println("to do");
        MyslimSiCislo hra = new MyslimSiCislo(dolniMez, horniMez);
    }

    private static void hratHracMysli() {
        System.out.println("");
        System.out.println("to do");
    }
    
    private static void zmenaNastaveni() {
        System.out.println("");
        System.out.println("to do");
    }
}

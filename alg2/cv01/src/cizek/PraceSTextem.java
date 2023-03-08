package cizek;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PraceSTextem {

    private static final Scanner sc = new Scanner(System.in);
    private static final char[] cifry = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            
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
        System.out.println("1. Prevod cisla z 10 do jine soustavy");
        System.out.println("2. Prevod cisa ze soustavy do 10");
        System.out.println("3 - Rozklad textoveho retezce s cestou k souboru na umisteni, nazev a priponu");
        System.out.println("4 - Test textoveho retezce na palindrom");
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
                case 1: prevodZDesitkove(); break;
                case 2: prevodDoDesitkove(); break;
                case 3: umisteniSouboru(); break;
                case 4: testPalindrom(); break;
                default: 
                    System.out.println("Volba neexistuje.");
        }
        return false;
    }

    private static void prevodZDesitkove() {
        System.out.println("");
        System.out.println("Prevod cisla z desitkove soustavy do soustavy o jinem zakladu");
        System.out.println("zadej cislo: ");
        long cislo = sc.nextLong(); sc.nextLine();
        System.out.println("zadej zaklad soustavy");
        int zaklad = sc.nextInt(); sc.nextLine();
        if (cislo<0) {
            System.out.println("Zadej cele nezaporne cislo v desitkove soustave");
            return;
        }
        if (zaklad < 2 || zaklad > cifry.length) {
            System.out.println("Prevod nelze provest, zaklad je mimo rozsah.");
            return;
        }
        int f; String v="";
        do {
            f=(int) (cislo%zaklad);
            v=cifry[f] + v;
            cislo /= zaklad;
        } while(cislo > 0);
        System.out.println("Cislo v jine soustave vypada takto: " + v);
    }

    private static void prevodDoDesitkove() {
        System.out.println("");
        System.out.println("Prevod cisla z jine soustavy do desitkove");
        System.out.println("zadej zaklad soustavy");
        int zaklad = sc.nextInt(); sc.nextLine();
        System.out.println("zadej cislo");
        String cisloZ = sc.next(); sc.nextLine();
        if (zaklad < 2 || zaklad > cifry.length) {
            System.out.println("Prevod nelze provest, zaklad je mimo rozsah");
            return;
        }
        //kontrola platnosti cisla
        boolean valid=true;
        for (int i=0;i<cisloZ.length();i++) {
            for (int j=0;j<zaklad;j++) {
                if (cisloZ.charAt(i) == cifry[j]) {
                    valid=true; break;
                } else valid=false;
            }
            if (!valid) {
                System.out.println("Prevod nejde, cislo neni v zadanem zakladu");
                return;
            }
        }
        //prevod do desitkove soustavy
        long cisloDes=0;
        for (int i=0;i<cisloZ.length();i++) {
            for (int j=0;j<zaklad;j++) {
                if (cisloZ.charAt(i) == cifry[j]) {
                    cisloDes+=Math.pow(zaklad, cisloZ.length()-i-1)*j;
                }
            }
        }
        System.out.println("Cislo v desitkove soustave vypada takto: " + cisloDes);
    }

    private static void umisteniSouboru() {
        System.out.println("");
        System.out.println("Zadej cestu souboru, ukoncis zadanim pratdne radky");
        String cesta =".";
        do {
            cesta=sc.nextLine(); cesta=cesta.replace('\\', '/');
            String[] pripona=cesta.split("\\.");
            String[] adresare=cesta.split("/");
            String soubor=adresare[adresare.length-1];
            //if posledni znak neni /
            System.out.println("Pripona: " + pripona[pripona.length-1]);
            System.out.println("Nazev souboru: " + soubor);
            System.out.println("Adresare: ");
            for (int i=0;i<adresare.length-1;i++) {
                System.out.print(adresare[i] + " ");
            }
        } while (cesta != ""); //.trim
    }

    private static void testPalindrom() {
        System.out.println("");
        System.out.println("Zadej retezce, ukoncis zadanim pratdne radky");
        String retezec =".";
        do {
            retezec=sc.nextLine(); retezec.toLowerCase();
            boolean palindrom = true;
            for (int i=0;i<retezec.length()/2;i++) {
                if (retezec.charAt(i) != retezec.charAt(retezec.length()-i-1)) {
                    palindrom=false; break;
                }
            }
            if (palindrom) System.out.println("je palindrom");
            else System.out.println("neni palindrom");
        } while (retezec != "");
    }
}

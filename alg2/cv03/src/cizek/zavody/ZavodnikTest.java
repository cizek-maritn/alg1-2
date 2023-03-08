package cizek.zavody;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ZavodnikTest {

    private static final Scanner sc = new Scanner(System.in);
    static ArrayList<Zavodnik> seznam = new ArrayList<>(); //myslim, ze nebylo na prednasce. nasel jsem na netu.
    public static void main(String[] args) {
        boolean konecProgramu;
        do {
            vypisMenu();
            int volba = nactiVolbu();
            konecProgramu = obsluzVolbu(volba);
        } while(!konecProgramu);
        System.out.println("koncim");
    }
    
    private static void vypisMenu() {
        System.out.println("Hlavni menu programu");
        System.out.println("1. Registrace zavodnika");
        System.out.println("2. Cas zavodnika");
        System.out.println("3. Vyhodnoceni zavodu");
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
                case 1 -> registrace();
                case 2 -> casZavodnika();
                case 3 -> vyhodnoceni();
                default -> System.out.println("neplatna volba");
        }
        return false;
    }

    private static void registrace() {
        System.out.println("");
        System.out.println("Zadej jmeno: ");
        String jmeno=sc.nextLine();
        System.out.println("Zadej prijmeni: ");
        String prijmeni=sc.nextLine();
        System.out.println("Zadej rok narozeni: ");
        int rok=sc.nextInt();
        Zavodnik zavodnik = new Zavodnik(jmeno, prijmeni, rok);
        seznam.add(zavodnik);
        System.out.println("jmeno:" + jmeno);
        System.out.println("prijmeni: " + prijmeni);
        System.out.println("rok narozeni: " + rok);
        System.out.println("Registracni cislo zavodnika: " + zavodnik.getReg());
        
    }

    private static void casZavodnika() {
        System.out.println("");
        System.out.println("Zadej registracni cislo zavodnika: ");
        int rc=sc.nextInt()-1;
        boolean correct=true;
        try {
            seznam.get(rc);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Spatne cislo");
            correct=false;
        }
        if (correct) {
            Zavodnik zavodnik;
            zavodnik = seznam.get(rc);
            System.out.println("Cas startu (v nejaky vhodny jednotce): ");
            zavodnik.setStart(sc.nextLong());
            System.out.println("Cas konce (opet ve vhodny jednotce): ");
            zavodnik.setEnd(sc.nextLong());
            System.out.println("cas zavodu: " + zavodnik.casZavodu());
        }
    }

    private static void vyhodnoceni() {
        System.out.println("");
        long cas; long min=Long.MAX_VALUE; Zavodnik zavodnik; Zavodnik vitez=seznam.get(0);
        for (int i=0; i<seznam.size(); i++) {
            zavodnik=seznam.get(i);
            cas=zavodnik.casZavodu();
            if (cas<min) {
                min=cas;
                vitez=zavodnik;
            }
        }
        System.out.println("vitez je: " + vitez.getJmeno() + " " + vitez.getPrijmeni());
        System.out.println("s casem: " + vitez.casZavodu());
        System.out.println("");
    }
}

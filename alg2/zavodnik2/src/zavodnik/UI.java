/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zavodnik;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UI {

    private static final Scanner sc = new Scanner(System.in);
    private static ZavodRegistrace zavod;
    
    public static void main(String[] args) throws IOException {
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
        System.out.println("1. vyber souboru");
        System.out.println("2. registrace");
        System.out.println("3. vypis zavodniku");
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
    
    private static boolean obsluzVolbu(int volba) throws IOException {
        switch (volba) {
                case 0: return true;
                case 1: vyberSouboru(); break; //rename those shits
                case 2: registraceZavodnika(); break;
                case 3: vypisZavodniku(); break;
                default: 
                    System.out.println("spatna volba");
        }
        return false;
    }

    private static void vyberSouboru() throws IOException {
        System.out.println("");
        System.out.println("zadani souboru");
        String path = sc.nextLine();
        zavod = ZavodRegistrace.getInstance(path);
    }

    private static void registraceZavodnika() throws IOException {
        System.out.println("");
        System.out.println("zadej jmeno, prijemni a rocnik");
        zavod.pridejZavodnika(sc.next(), sc.next(), sc.nextInt());
    }
    
    private static void vypisZavodniku() throws IOException {
        System.out.println("");
        System.out.println("vypis zavodniku");
        List<String> seznam = zavod.getVypisZavodniku(true);
        for (String str : seznam) {
            System.out.println(str);
        }
    }
}

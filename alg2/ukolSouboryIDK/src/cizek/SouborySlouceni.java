package cizek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SouborySlouceni {

    private static final Scanner sc = new Scanner(System.in);
    private static String soubor;
    
    public static void main(String[] args) throws IOException {
        boolean konecProgramu;
        System.out.println("Zadej soubor: ");
        SouborySlouceni.soubor=sc.nextLine();
        do {
            vypisMenu();
            int volba = nactiVolbu();
            konecProgramu = obsluzVolbu(volba);
        } while(!konecProgramu);
        System.out.println("koncim program");
    }
    
    private static void vypisMenu() {
        System.out.println("Hlavni menu programu");
        System.out.println("1. pridani");
        System.out.println("2. prepsani");
        System.out.println("0 - storno");
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
                case 1: Pridani(soubor); break; 
                case 2: Prepsani(soubor); break;
                default: 
                    System.out.println("spatna volba");
        }
        return false;
    }

    //metoda stejne dela to same, co metoda Prepsani
    private static void Pridani(String s) throws IOException {
        System.out.println("");
        System.out.println("Zadavvej programy, ukoncis prazdnym vstupem");
        String vstup;
        while (!(vstup=sc.nextLine()).equals("")) {
             try (BufferedReader br = Files.newBufferedReader(Path.of(vstup));  
                BufferedWriter bw = Files.newBufferedWriter(Path.of(s))) {
            int c;
            while ((c = br.read()) >=0) {
                bw.append((char) c);
                
            }
        }
        }
    }

    private static void Prepsani(String s) throws IOException {
        System.out.println("");
        System.out.println("Zadavvej programy, ukoncis prazdnym vstupem");
        String vstup;
        while (!(vstup=sc.nextLine()).equals("")) {
             try (BufferedReader br = Files.newBufferedReader(Path.of(vstup));  
                BufferedWriter bw = Files.newBufferedWriter(Path.of(s))) {
            String radek;
            while ((radek = br.readLine()) != null) {
                bw.write(radek);
                bw.newLine();
            }
        }
        }
    }
}

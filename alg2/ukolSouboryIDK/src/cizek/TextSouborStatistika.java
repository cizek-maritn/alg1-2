package cizek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;


public class TextSouborStatistika {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Zadej cestu k souboru: ");
        String soubor = sc.nextLine();
        String stat = soubor.split("\\.")[0] + ".stat";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(soubor)));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(stat)))) {
            int znaky=0; int cisla=0; int ch; int radky=0; int nradky=0;
            while ((ch=br.read()) >=0) {
                //cislice 0 az 9 maji v hodnoty 48 az 57
                //jako znaky bere i mezery, tabulatory a konce radky
                if (ch >=48 && ch <= 57) {
                    cisla++;
                } else {
                    znaky++;
                }
                
            }
            
            try (BufferedReader brr = new BufferedReader(new InputStreamReader(new FileInputStream(soubor)));
                BufferedWriter bww = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(stat)))) {
                 String rdk;
            while ((rdk = brr.readLine()) != null) {
                //radky je celkovy pocet radku, nradky jsou neprazdne radky,
                
                if (!rdk.strip().equals("")) {
                    nradky++;
                }
                radky++;
            }
            }
            
            
            String vystup=  String.format("pocet znaku: %d, pocet cislic: %d, pocet radku: %d, pocet neprazdnych radku: %d",
                    znaky, cisla, radky, nradky);
            bw.write(vystup);
            System.out.println(vystup);
        }
    }
}



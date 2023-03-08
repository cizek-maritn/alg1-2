/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adresare;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class AdrFileInfo {

    public static final Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String vstup; File soubor; Path cesta;
        do {
            vstup=sc.nextLine().trim();
            if (!vstup.equalsIgnoreCase("exit")) {
                if (vstup.equals("")) {
                    vstup=System.getProperty("user.dir");
                } else {
                    soubor = new File(vstup);
                    System.out.println(vstup);
                    System.out.println("jmeno souboru: " + soubor.getName());
                    System.out.println("umisteni: " + soubor.getParent());
                    System.out.println("existuje na disku: " + soubor.exists());
                    System.out.println("je soubor: " + soubor.isFile());
                    System.out.println("je adresar: " + soubor.isDirectory());
                    System.out.println("je absolutni cesta: " + soubor.isAbsolute());
                    System.out.println("absolutni cesta: " + soubor.getAbsolutePath());
                    System.out.println("normalizovany tvar: " + soubor.getCanonicalPath());
                    System.out.println("");
                    cesta=Paths.get(vstup);
                    System.out.println("jmeno souboru: " + cesta.getFileName());
                    System.out.println("umisteni: " + cesta.getParent());
                    System.out.println("existuje na disku: " + Files.exists(cesta));
                    System.out.println("je soubor: " + Files.isRegularFile(cesta));
                    System.out.println("je adresar: " + Files.isDirectory(cesta));
                    System.out.println("je absolutni cesta: " + cesta.isAbsolute());
                    System.out.println("absolutni cesta: " + cesta.toAbsolutePath());
                    //System.out.println("normalizovany tvar: " + Files);
                }
            }
            
        } while(vstup.compareToIgnoreCase("exit") !=0);
    }
    
}

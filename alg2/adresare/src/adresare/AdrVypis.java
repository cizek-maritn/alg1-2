/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adresare;

import static adresare.AdrFileInfo.sc;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class AdrVypis {

    public static final Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        String vstup; File soubor; Path cesta; long velikost=0;
        do {
            vstup=sc.nextLine().trim();
            if (!vstup.equalsIgnoreCase("exit")) {
                if (vstup.equals("")) {
                    vstup=System.getProperty("user.dir");
                } else {
                    soubor = new File(vstup);
                    if (soubor.isDirectory()) {
                        String[] pole=soubor.list();
                        Arrays.sort(pole);
                        for (String s : pole) {
                            System.out.println(s);
                        }
                        System.out.println("");
                        File[] ff = soubor.listFiles();
                        for (File f : ff) {
                            if (f.isDirectory()) System.out.println(f.getName() + " je adresar");
                            else System.out.println(f.getName() + " je soubor");
                        }
                        System.out.println("");
                        ff = soubor.listFiles(new FileFilter() {
                            @Override
                            public boolean accept(File pathname) {
                                return pathname.isFile();
                            }
                        });
                        for (File f : ff) {
                            velikost+=f.length();
                        }
                        System.out.println("celkova velikost: " + velikost + " B");
                    }
                }
            }
            
        } while(vstup.compareToIgnoreCase("exit") !=0);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adresare;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class aaaaa {

    public static final Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String jm1, jm2;
        System.out.println("zadej jmeno souboru");
        while ((jm1=sc.nextLine().trim()).length() > 0) {
            System.out.println("zadej nove jmeno");
            jm2=sc.nextLine();
            File f1=new File(jm1);
            System.out.println(f1);
            if (f1.exists()) {
                f1.renameTo(new File(jm2));
            } else {
                f1.mkdir();
            }
            System.out.println(f1);
            System.out.println("");
            System.out.println("zadej jmeno souboru");
        }
    }
    
}

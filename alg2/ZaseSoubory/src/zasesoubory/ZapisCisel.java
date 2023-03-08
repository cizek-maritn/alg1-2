/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zasesoubory;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class ZapisCisel {

    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws FileNotFoundException {
        int[] a = DataGen.genPoleInt(87, 501);
        String cesta = sc.nextLine();
        
        try (PrintWriter writer = new PrintWriter(cesta)) {
            for (int i=0; i<a.length; i++) {
                writer.format("%0d", a[i]);
            }
        }
    }
    
}

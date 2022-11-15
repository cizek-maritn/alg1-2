/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alg05;

import java.util.Scanner;
/**
 *
 * @author Dell
 */
public class test {
    
    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("zadej pocet");
        int n = sc.nextInt();
        double r = 0;
        System.out.println("zadej cisla");
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            r=r+x;
        }
        double prumer = r/n;
        System.out.println("prumer posloupnosti je " + prumer);
    }
}
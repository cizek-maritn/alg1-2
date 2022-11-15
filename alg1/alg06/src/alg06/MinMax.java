/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alg06;

import java.util.Scanner;
/**
 *
 * @author Dell
 */
public class MinMax {
    
    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("zadej cisla, ukonci 0 nebo zapornym cislem");
        float y;
        float max=0.F;
        float min=Float.POSITIVE_INFINITY;
        while((y=sc.nextFloat())>0) {
            if (y>max) {
                max=y;
            } if (y<min) {
                min=y;
            }
        }
        System.out.println("max je " + max);
        System.out.println("min je " + min);
    }
    
}

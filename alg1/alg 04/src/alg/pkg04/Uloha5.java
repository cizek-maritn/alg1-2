/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alg.pkg04;

import java.util.Scanner;
/**
 *
 * @author Dell
 */
public class Uloha5 {

    private static final Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("reseni kvadraticke rovnice, napis a b c");
        System.out.println(2.5/6*Math.PI);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double d = (b*b)-(4.*a*c);
        boolean kvdr = a == 0;
        boolean lin = b == 0;
        boolean kom = d < 0;
        double x1 = 0;
        double x2 = 0;
        double re = 0;
        double im = 0;
        double x = 0;
        
        if (!kvdr) {
            if (!kom) {
                x1 = (-b-Math.sqrt(d))/(2.*a);
                x2 = (-b+Math.sqrt(d))/(2.*a);
                System.out.println("kvadraticka rovnice");
                System.out.format("x1= %.3f%n", x1);
                System.out.format("x2= %.3f%n", x2);
            } else {
                re = (-b/(2.*a));
                im = Math.abs(Math.sqrt(Math.abs(d)));
                System.out.println("komplexni kvadraticka rovnice");
                System.out.format("x1= %.3f + %.3f%n", re, im);
                System.out.format("x2= %.3f - %.3f%n", re, im);
            }
        } else {
            if (!lin) {
                x = -(c/b);
                System.out.println("linearni rovnice");
                System.out.format("x= %.3f%n", x);
            } else {
                System.out.println("neni rovnice");
        }
        
        
        }
    }
    
}

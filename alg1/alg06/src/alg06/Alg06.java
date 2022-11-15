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
public class Alg06 {
    
    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("zadej cislo operand cislo");
        double a = sc.nextDouble();
        char op = sc.next().charAt(0);      //sc.nextLine sucks
        double b = sc.nextDouble();
        System.out.format("zadano %f %c %f %n", a, op, b);
        
        double v;
        switch (op) {
            case '+' : v=a+b; break;    //bez break se dela vse od case dolu
            case '/' : v=a/b; break;
            case '-' : v=a-b; break;
            case '*' : v=a*b; break;
            default: v= Double.NaN;
        }
        System.out.format("zadano %f %c %f = %f%n", a, op, b, v);
        
        //nebo psat
        //System.out.println("zadej cislo operand cislo");
        //double c = sc.nextDouble(); sc.nextLine();
        //char opr = sc.nextLine().charAt(0);      //sc.nextLine sucks
        //double d = sc.nextDouble(); sc.nextLine();
        
        //primitivni kalkulacka
        System.out.println("zadej vyraz");
        double r = sc.nextDouble();
        char opr = sc.next().charAt(0);
        double c;
        while (opr!='=') {
            switch (opr) {
                case '+' : c = sc.nextDouble(); r=r+c; break;
                case '-' : c = sc.nextDouble(); r=r-c; break;
                case '*' : c = sc.nextDouble(); r=r*c; break;
                case '/' : c = sc.nextDouble(); r=r/c; break;
                default : r=r; 
            }
            opr = sc.next().charAt(0);
        } 
        System.out.println("vysledek je " + r);
    }
    
}

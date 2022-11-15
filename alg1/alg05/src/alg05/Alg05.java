//vypocty mocnin a faktorialu, delitele cisla

package alg05;

import java.util.Scanner;

public class Alg05 {

    private static final Scanner sc = new Scanner(System.in);

    
    public static void main(String[] args) {
        double a = sc.nextDouble();
        int n = sc.nextInt();
        
        long fac = 1;
        int i = 0;
        double moc = 1;
        while (i<n) {
            moc = moc*a;
            i++;
        }
        System.out.println(moc);
        
        i=0;
        while (i<n) {
            fac = fac*(n-i);
            i++;
        }
        System.out.format("%d! = %d %n", n, fac);
        
        //delitele
        i=2;
        int D;
        int pocet = 0;
        while (i<=n/2) {
            if (n%i == 0) {
                D = i;
                System.out.print(D + " ");
                pocet++;
            }
        i++;
        }
        System.out.println("pocet delitelu: " + pocet);
        
        //hvezdicky nebo tak neco
        System.out.println("zadej vysku h: ");
        int h = sc.nextInt();
        
        //radek
        for (int x = 0;x<h;x++) {
            System.out.print("* ");
        }
        
        //ctverec
        System.out.println("");
        System.out.println("");
        for (int x=0;x<h;x++) {
            for (int j=0;j<h;j++) {
                System.out.print("* ");
            } System.out.println("");
        }
        
        //trojuhelnik 1
        System.out.println("");
        System.out.println("");
        for (int x = 1;x<=h;x++) {
            for (int j=1;j<=x;j++) {
                System.out.print("* ");
            } System.out.println("");
        }
        
        //trojuhelnik 2
        System.out.println("");
        System.out.println("");
        for (int x=1;x <=h;x++) {
            for (int j=1;j<=h-x;j++) {
                System.out.print(" ");
            }
            for (int j = 1;j<=x;j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
        }
        }

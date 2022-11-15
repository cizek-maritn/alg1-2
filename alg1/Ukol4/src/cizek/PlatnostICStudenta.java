package cizek;

import java.util.Scanner;

public class PlatnostICStudenta {

    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.print("Zadej IC studenta: ");
        
        // promenne cislic IC
        int IC = sc.nextInt();
        int viii = IC/10000000; //pouzivam rimske cislice, jinak bych se ztratil
        int x = IC%10000000;    //docasna promenna, obchazeni cyklu for
        int vii = x/1000000;
        x = x%100000;
        int vi = x/100000;
        x = x%100000;
        int v = x/10000;
        x = x%10000;
        int iv = x/1000;
        x = x%1000;
        int iii = x/100;
        x = x%100;
        int ii = x/10;
        int i = x%10;
        
        //nasobeni cislic IC, zbytek po deleni 11
        int soucet = 8*viii+7*vii+6*vi+5*v+4*iv+3*iii+2*ii;
        int zbytek = soucet%11;
        
        //rozhodovani o platnosti IC
        if (zbytek==0) {
            if (i==1) {
                System.out.println("Platne IC.");
            } else {
                System.out.println("Neplatne IC");
            }
        } else if (zbytek==1) {
            if (i==0) {
                System.out.println("Platne IC.");
            } else {
                System.out.println("Neplatne IC.");
            }
        } else {
            if (i==zbytek) {
                System.out.println("Platne IC.");
            } else {
                System.out.println("Neplatne IC.");
            }
            }
        }
    }
    


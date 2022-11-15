/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cizek;

import java.util.Scanner;
/**
 *
 * @author Dell
 */
public class Uloha15 {


    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner (System.in);
        System.out.print("Zadej delky stran kvadru: ");
        float a = sc.nextFloat();
        float b = sc.nextFloat();
        float c = sc.nextFloat();
        float VKv = a*b*c;                        //operace kvadru
        float SKv = 2*((a*b)+(b*c)+(a*c));
        System.out.printf("Objem kvadru je: %.2f", VKv);
        System.out.println("");
        System.out.printf("Plocha plaste kvadru je: %.2f", SKv);
        System.out.println("");
        double VaKr = Math.cbrt(VKv);             //operace krychle
        double SaKr = Math.sqrt(SKv/6);
        System.out.printf("Hrana krychle se stejnym objemem je: %.2f", VaKr);
        System.out.println("");
        System.out.printf("Hrana krychle se stejnou plochou plaste je: %.2f", SaKr);
        System.out.println("");
        double pi = Math.PI;
        double VrK = Math.cbrt((3*VKv)/(4*pi));  //operace koule
        double SrK = Math.sqrt(SKv/(4*pi));
        System.out.printf("Polomer koule se stejnym objemem je: %.2f", VrK);
        System.out.println("");
        System.out.printf("Polomer koule se stejnou plochou plaste je: %.2f", SrK);
        System.out.println("");
        double VaCt = Math.cbrt(VKv*(12/(Math.sqrt(2)))); //operace ctyrstenu
        double SaCt = Math.sqrt(SKv/(Math.sqrt(3)));
        System.out.printf("Hrana pravidelneho ctyrstenu se stejnym objemem je: %.2f", VaCt);
        System.out.println("");
        System.out.printf("Hrana pravidelneho ctyrstenu se stejnou plochou plaste je: %.2f", SaCt);
        System.out.println("");
    }
    
}

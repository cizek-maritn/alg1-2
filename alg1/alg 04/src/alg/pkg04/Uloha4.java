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
public class Uloha4 {

    private static final Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Uloha 4: vypis delky tri usecek: ");
        float a = sc.nextFloat();
        float b = sc.nextFloat();
        float c = sc.nextFloat();
        
        boolean jeTrojuhelnik = (a+b>c)&&(Math.abs(a-b)<c);
        
        if (jeTrojuhelnik) {      // !jeTrojuhelnik je if not
            System.out.println("trojuhelnik lze sestrojit");
        } else {
            System.out.println("trojuhlenik nelze sestrojit");
        }
        
        System.out.println( jeTrojuhelnik ? "Je trojuhelnik" : "neni trojuhlenik");
        
        
        } 
    }
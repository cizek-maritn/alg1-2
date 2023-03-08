/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mocniny;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class hanoi {

    private static final Scanner sc = new Scanner(System.in);
    
    public static void hanoi(int n, char od, char kam, char pom) {
        if (n>0) {
            hanoi(n-1,od, pom, kam);
            System.out.println(n + " z " + od + " na " + kam);
            hanoi(n-1, pom, kam, od);
        }
    }
    
    public static void main(String[] args) {
        hanoi(3,'A','B','C');
    }
    
}

package cizek;

import java.util.Scanner;

public class VypisVlajkyCR {
    
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Zadej vysku a sirku: ");
        int n = sc.nextInt();   //vyska
        int m = sc.nextInt();   //sirka
        System.out.println("");
        for (int i = 1;i <= n/2;i++) {
            for (int j = 1;j <= i; j++) {
                System.out.print("* ");
            } for (int l = 1;l <= m-i;l++) {
                System.out.print("- ");
            } System.out.println("");
        } for (int i = n/2;i > 0;i--) {
            for (int j = 1;j <= i;j++) {
                System.out.print("* ");
            } for (int l = 1;l <= m-i;l++) {
                System.out.print("o ");
            } System.out.println("");
        }
    }
    
}

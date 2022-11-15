package cizek;

import java.util.Scanner;

public class TestPrvociselnosti {
    
    private static final Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Zadej cele cislo: ");
        int n = sc.nextInt();
        if (n<1) {
            System.out.println("Cislo " + n + " neni prvocislo.");
        } else {
            int i = 2;
            while (i <= n/2) {
                if (n%i == 0) {
                    System.out.println("Cislo " + n + " neni prvocislo.");
                    i = n;
                } else {
                    i++;
                }
            } if (i < n) {
                System.out.println("Cislo " + n + " je prvocislo.");
            }
        }
    }
}
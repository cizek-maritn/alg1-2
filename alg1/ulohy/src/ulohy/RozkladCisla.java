package ulohy;

import java.util.Scanner;

public class RozkladCisla {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n; int k=3;
        while ((n=sc.nextInt())>0) {
            while (n>1) {
                if (n%2==0) {
                    n=n/2;
                    System.out.print("2 ");   
                } else if (n%k==0) {
                    n=n/k;
                    System.out.print(k + " ");
                } else k++;
            }
            k=3;
            System.out.println("");
        }
    }
    
}

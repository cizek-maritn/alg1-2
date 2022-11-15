package ulohy;

import java.util.Scanner;

public class Cifry {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long n; long sum=0; long souc=1; long k;
        while ((n=sc.nextLong())>0) {
            while (n>0) {
                k=n%10;
                sum = sum+k; souc=souc*k;
                n=n/10;
            }
            System.out.println(sum + " " + souc);
            sum=0; souc=1;
        }
    }
    
}

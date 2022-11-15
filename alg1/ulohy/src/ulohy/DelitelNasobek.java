package ulohy;

import java.util.Scanner;

public class DelitelNasobek {

private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        long x; long y; long n; long d;
        while ((x=sc.nextLong())>0) {
            y=sc.nextLong();
            if (Math.min(x, y)<=100000) d=(Math.max(x, y))/2;
            else d=(long) (Math.sqrt(Math.max(x, y)))/2;
            while (x%d!=0 || y%d!=0) {
                d--;
            }
            n=(x*y)/d;
            System.out.println(d + " " + n);
        }
    }
    
}

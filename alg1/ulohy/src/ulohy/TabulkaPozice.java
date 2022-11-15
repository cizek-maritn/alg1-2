package ulohy;

import java.util.Scanner;

public class TabulkaPozice {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int h=sc.nextInt();
        int d=sc.nextInt();
        int v=sc.nextInt();
        int a; int b;
        if (v%d==0) {
            a=v/d;
        } else {
            a=(v/d)+1;
        }
        if (v%d==0) {
            b=d;
        } else {
            b=v%d;
        }
        System.out.println(a + " " + b);
    }
    
}

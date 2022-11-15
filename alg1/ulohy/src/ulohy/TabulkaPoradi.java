package ulohy;

import java.util.Scanner;

public class TabulkaPoradi {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int h=sc.nextInt();
        int d=sc.nextInt();
        int hv=sc.nextInt();
        int hd=sc.nextInt();
        int a=(d*hv)-(d-hd);
        System.out.println(a);
    }
    
}

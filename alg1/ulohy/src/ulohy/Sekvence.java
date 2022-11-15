package ulohy;

import java.util.Scanner;

public class Sekvence {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int p; int x; int k=1; int n=1; int y=Integer.MAX_VALUE;
        while ((p=sc.nextInt())>0) {
            for (int i=1;i<=p;i++) {
                x=sc.nextInt();
                if (y<=x) k++;
                else if (y>x) k=1;
                if (n<k) n=k;
                y=x;
            }
            System.out.println(n);
            n=1; k=1; y=Integer.MAX_VALUE;
        }
    }
    
}

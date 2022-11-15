package ulohy;

import java.util.Scanner;

public class BarvaPole {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int x; int y;
        while ((x=sc.nextInt())>0) {
            y=sc.nextInt();
            if (x%2==1) {
                System.out.println(((x+y)%2==0) ?
                        "BILA" :
                        "CERNA");
            } else {
                System.out.println(((x+y)%2==0) ?
                        "BILA" :
                        "CERNA");
            }
        }
    }
    
}

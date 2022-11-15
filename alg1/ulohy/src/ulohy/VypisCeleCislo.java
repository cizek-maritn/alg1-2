package ulohy;

import java.util.Scanner;

public class VypisCeleCislo {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n=sc.nextInt();
        if (n>=0) {
            System.out.format("+%03d", n);
        } else {
            System.out.format("%04d", n);
        }
    }
    
}

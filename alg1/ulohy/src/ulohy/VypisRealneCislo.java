package ulohy;

import java.util.Scanner;
import java.util.Locale;

public class VypisRealneCislo {

private static final Scanner sc = new Scanner(System.in);
private static final Locale loc = new Locale ("CS", "cz");

    public static void main(String[] args) {
        sc.useLocale(loc);
        double a = sc.nextDouble();
        System.out.format(loc, "%10.3f", a);
    }
    
}

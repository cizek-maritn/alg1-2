package ulohy;

import java.util.Scanner;
import java.util.Locale;

public class PoctyBodu {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        sc.useLocale(Locale.US);
        int n=sc.nextInt(); float x; float y;
        int a=0; int b=0; int c=0; int d=0;
        for (int i=0;i<n;i++) {
            x=sc.nextFloat(); y=sc.nextFloat();
            if (x>=0 && y>=0) a++;
            else if (x<0 && y>=0) b++;
            else if (x<=0 && y<0) c++;
            else d++;
        }
        System.out.println(a + " " + b + " " + c + " " + d);
    }
    
}

package ulohy;

import java.util.Scanner;
import java.util.Locale;

public class PrumernaDenniTeplota {
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        
        float prumernaTeplota; 
        float rano=sc.nextFloat(); float odpoledne=sc.nextFloat();
        float vecer=2*sc.nextFloat();
        prumernaTeplota=(rano+odpoledne+vecer)/4.F;
        
        System.out.format(Locale.US, "%1.2f", prumernaTeplota);
    }
}

package cv09.cizek;

import java.util.Scanner;

public class VypocetKvadratickéOdchylky {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n; float prum=0; float max=0; float sum=0; float kv; float soucet=0;
        System.out.println("Zadej pocet cisel: ");
        n=sc.nextInt();
        float t[] = new float[n];
        System.out.println("Zadej cisla: ");
        for (int i=0;i<n;i++) {
            t[i] = sc.nextFloat();
        }   //nacteni hodnot do pole
        for (int i=0;i<n;i++) {
            soucet = t[i]+soucet;
            prum = soucet/n;
        }   //aritmeticky prumer
        float h[] = new float[n];
        for (int i=0;i<n;i++) {
            h[i] = t[i]-prum;
        }
        for (int i=0;i<n;i++) {
            if (Math.abs(h[i])>max) {
                max=Math.abs(h[i]);
            }
        }   //max odchylka
        for (int i=0;i<n;i++) {
            sum=sum+(h[i]*h[i]);
        }
        kv=sum/n;
        System.out.println("Pocet mereni: " + n);
        System.out.println("Aritmeticky prumer: " + prum);
        System.out.println("Maximalni odchylka: " + max);
        System.out.println("Kvadraticka odchylka: " + kv);
    }
    
}

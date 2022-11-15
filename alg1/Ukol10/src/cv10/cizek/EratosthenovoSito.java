package cv10.cizek;

import java.util.Arrays;
import java.util.Scanner;

public class EratosthenovoSito {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Zadej cele cislo: ");
        int k=sc.nextInt();
        boolean n[] = new boolean[k+1];
        Arrays.fill(n, true);
        for (int i=2;i<=k+1;i++) {
            for (int j=i+1; j<=k; j++) {
                if (n[i] && j%i==0) {
                    n[j]=false;
                }
            }
        }
        System.out.println(Arrays.toString(n));
    }
    
}

package ulohy;

import java.util.Scanner;

public class Pocet {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int pocet=sc.nextInt(); int N=0; int prvni; int rest; int d=2; int K=0; int v=0;
        for (int i=1;i<=pocet;i++) {
            prvni=sc.nextInt();
            while (d<((prvni/2)+1)) {
                if (prvni%d==0) N++; d++;
            }
            d=2;
            while ((rest=sc.nextInt())>0) {
                while (d<((rest/2)+1)) {
                    if (rest%d==0) K++; d++;
                }
                d=2;
                if (K==N) v++;
                K=0;
            }
            System.out.println(v);
            v=0; N=0;
        }
    }
    
}

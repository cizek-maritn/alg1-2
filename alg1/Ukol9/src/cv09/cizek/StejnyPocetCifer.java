package cv09.cizek;

import java.util.Scanner;

public class StejnyPocetCifer {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean znovu=true; boolean vysledek;
        long x; long y; long a[] = new long[10]; long b[] = new long[10];
        while (znovu) {
            System.out.println("Zadej dvojici celych cisel, pripadne ukonci 0 ci zapornym cislem: ");
            x=sc.nextLong(); 
            if (x<=0) {
                System.out.println("Koncim.");
                znovu=false;
                break;
            }
            y=sc.nextLong();
            if (y<=0) {
                System.out.println("Spatne zadano.");
            } else {
                a=Cifry(x);
                b=Cifry(y);
                vysledek=Porovnani(a, b);
                System.out.println(Porovnani(a, b) ?
                        "Cisla maji stejne cifry" :
                        "Cisla nemaji stejne cifry");
            }
            
        }
        
        
    }
    /**
     * ziska pocet danych cifer pro cislo
     * @param x prvni cislo
     * @return 
     */
    public static long[] Cifry(long x) {
        long a[] = new long[10];
        int var1=0; long tmp1=x;
        while (tmp1>0) {
            var1=(int)tmp1%10;  //bez (int) to hází error lossy conversion long to int
            a[var1]=a[var1]+1;
            tmp1=tmp1/10;
        }
        return a;
    }    
    /**
     * porovna vznikla pole
     * @param a prvni pole
     * @param b druhe pole
     * @return 
     */
    public static boolean Porovnani(long a[], long b[]) {
        int k=0; boolean porov=false;
        for (int i=0;i<10;i++) {
            if (a[i]==b[i]) {
                k++;
            }
        }
        if (k==10) {
            porov=true;
        }
        return porov;
    }
}

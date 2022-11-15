package cv10.cizek;

import java.util.Scanner;
import cv10.cizek.ArrayTools;
import java.util.Arrays;

public class ArrayToolsTest {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean znovu=true; int n; double c;
        double [] a; int k; int menu;
        while (znovu) {
            int i=0;
            System.out.println("==================================");
            System.out.println("1 - soucet");
            System.out.println("2 - soucet casti");
            System.out.println("3 - maximum");
            System.out.println("4 - prvni pozice maxima");
            System.out.println("5 - posledni pozice maxima");
            System.out.println("6 - pocet vyskytu cisla");
            System.out.println("7 - vzestupnost");
            System.out.println("8 - stridavost");
            System.out.println("9 - obraceni pole");
            System.out.println("0 - konec");
            System.out.println("==================================");
            menu=sc.nextInt();
            switch (menu) {
                case 1 :
                    System.out.println("pocet prvku: "); k=sc.nextInt();
                    a= new double[k];
                    System.out.println("zadej prvky: ");
                    while (i<k) {
                        a[i]=sc.nextDouble(); i++;
                    }
                    System.out.println("soucet: " + ArrayTools.soucet(a));
                    break;
                case 2 :
                    System.out.println("pocet prvku: "); k=sc.nextInt();
                    System.out.println("pocet sectenych cisel: "); n=sc.nextInt();
                    a= new double[k];
                    System.out.println("zadej prvky: ");
                    while (i<k) {
                        a[i]=sc.nextDouble(); i++;
                    }
                    System.out.println("soucet: " + ArrayTools.soucet(a, n)); break;
                case 3 :
                    System.out.println("pocet prvku: "); k=sc.nextInt();
                    a= new double[k];
                    System.out.println("zadej prvky: ");
                    while (i<k) {
                        a[i]=sc.nextDouble(); i++;
                    }
                    System.out.println("maximum: " + ArrayTools.maximum(a)); break;
                case 4 :
                    System.out.println("pocet prvku: "); k=sc.nextInt();
                    a= new double[k];
                    System.out.println("zadej prvky: ");
                    while (i<k) {
                        a[i]=sc.nextDouble(); i++;
                    }
                    System.out.println("prvni pozice maxima: " + ArrayTools.prvniPoziceMaxima(a)); break;
                case 5 :
                    System.out.println("pocet prvku: "); k=sc.nextInt();
                    a= new double[k];
                    System.out.println("zadej prvky: ");
                    while (i<k) {
                        a[i]=sc.nextDouble(); i++;
                    }
                    System.out.println("posledni pozice maxima: " + ArrayTools.posledniPoziceMaxima(a)); break;
                case 6 :
                    System.out.println("pocet prvku: "); k=sc.nextInt();
                    System.out.println("pocet prohledanych cisel: "); n=sc.nextInt();
                    System.out.println("hledane cislo: "); c=sc.nextDouble();
                    a= new double[k];
                    System.out.println("zadej prvky: ");
                    while (i<k) {
                        a[i]=sc.nextDouble(); i++;
                    }
                    System.out.println("cislo se vyskytuje: " + ArrayTools.pocetVyskytu(a, n, c)); break;
                case 7 :
                    System.out.println("pocet prvku: "); k=sc.nextInt();
                    System.out.println("pocet zkoumanych cisel: "); n=sc.nextInt();
                    a= new double[k];
                    System.out.println("zadej prvky: ");
                    while (i<k) {
                        a[i]=sc.nextDouble(); i++;
                    }
                    System.out.println((ArrayTools.jeVzestupneUsporadana(a, n)) ?
                            "je vzestupna" :
                            "neni vzestupna"); break;
                case 8 :
                    System.out.println("pocet prvku: "); k=sc.nextInt();
                    a= new double[k];
                    System.out.println("zadej prvky: ");
                    while (i<k) {
                        a[i]=sc.nextDouble(); i++;
                    }
                    System.out.println((ArrayTools.jeStridavaPosloupnost(a)) ?
                            "je stridava" :
                            "neni stridava"); break;
                case 9 :
                    System.out.println("pocet prvku: "); k=sc.nextInt();
                    a= new double[k];
                    System.out.println("zadej prvky: ");
                    while (i<k) {
                        a[i]=sc.nextDouble(); i++;
                    }
                    System.out.println(Arrays.toString(ArrayTools.getReversed(a))); break;
                case 0 :
                    System.out.println("koncim");
                    znovu=false; break;
                default :
                    System.out.println("spatna volba");
            }
        }
    }
    
}

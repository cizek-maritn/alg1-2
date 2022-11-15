package cv11.cizek;

import cv11.cizek.MatrixTools;
import java.util.Scanner;

public class TestPrevodMatice {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Prevod Matice");
        System.out.println("Zadej rozmery: ");
        int pr=sc.nextInt(); int ps=sc.nextInt();
        sc.nextLine();
        double[][] a= new double[pr][ps];
        System.out.println("Zadej prvky: ");
        for (int i = 0; i < pr; i++) {
            for (int j = 0; j < ps; j++) {
                a[i][j] = sc.nextDouble();
            }
        }
        sc.nextLine();
        System.out.println("Normalizovany tvar: ");
        System.out.println("");
        MatrixTools.normalizovanyTvar(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.format("%.3f ", a[i][j]);
            }
            System.out.println();
        }
    }
}

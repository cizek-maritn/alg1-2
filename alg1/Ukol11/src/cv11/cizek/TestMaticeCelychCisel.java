package cv11.cizek;

import cv11.cizek.MatrixTools;
import java.util.Scanner;

public class TestMaticeCelychCisel {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Test symetrie a souctu");
        System.out.println("Zadej rozmery: ");
        int pr=sc.nextInt(); int ps=sc.nextInt();
        sc.nextLine();
        int[][] a= new int[pr][ps];
        System.out.println("Zadej prvky: ");
        for (int i = 0; i < pr; i++) {
            for (int j = 0; j < ps; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.nextLine();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println((MatrixTools.jeSymetricka(a)) ?
                "Je symetricka." :
                "Neni symetricka");
        System.out.println("");
        System.out.println((MatrixTools.stejneSoucty(a)) ?
                "Ma stejne soucty." :
                "Nema stejne soucty.");
    }
}

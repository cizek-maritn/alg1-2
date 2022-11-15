package cizek;

import java.util.Scanner;

public class MaticeTest {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int volba; boolean znovu=true; int[][] a=new int[1][1]; int[][] b=new int[1][1];
        int c = 3; int d = 5;
        System.out.println(c/d);
        while (znovu) {
            menu(); volba = sc.nextInt();
            switch (volba) {
                case 1 :
                    a = novaMatice(); break;
                case 2 :
                    b = novaMatice(); break;
                case 3 :
                    System.out.println((MaticeTools.stejneMatice(a, b))); break;
                case 4 :
                    System.out.println(MaticeTools.stejneMaticeAbs(a, b)); break;
                case 5 :
                    System.out.println(MaticeTools.stejneMin(a, b)); break;
                case 6 :
                    System.out.println(MaticeTools.stejneMax(a, b)); break;
                case 7 :
                    System.out.println(MaticeTools.stejneSoucty(a, b)); break;
                case 8 :
                    System.out.println(MaticeTools.stejnaMnozina(a, b)); break;
                case 9 :
                    System.out.println(MaticeTools.stejnyPocet(a, b)); break;
                case 0 :
                    znovu=false; break;
                default :
                    System.out.println("Takova volba neexistuje.");
            }
        }
    }
    
    private static void menu() {
        System.out.println("---------------------------------------------");
        System.out.println("1 - nacteni prvni matice");
        System.out.println("2 - nacteni druhe matice");
        System.out.println("3 - test stejnych matic");
        System.out.println("4 - test stejnych matic v absolutni hodnote");
        System.out.println("5 - test stejnych minim matic");
        System.out.println("6 - test stejnych maxim matic");
        System.out.println("7 - test stejnych souctu prvku matic");
        System.out.println("8 - test stejnych mnozin prvku matic");
        System.out.println("9 - test stejnych poctu stejnych cisel matic");
        System.out.println("0 - konec programu");
        System.out.println("---------------------------------------------");
    }
    
    private static int[][] novaMatice() {
        System.out.println("Zadej rozmery: ");
        int pr=sc.nextInt(); int ps=sc.nextInt();
        if (pr<1 || ps<1) {
            System.out.println("Zadan zaporny rozmer, matice bude o rozmeru 1x1.");
            pr=1; ps=1;
        }
        int[][] k= new int[pr][ps];
        System.out.println("Zadej prvky: ");
        for (int i=0;i<pr;i++) {
            for (int j=0;j<ps;j++) {
                k[i][j]=sc.nextInt();
            }
        }
        return k;
    }
}

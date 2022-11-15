package cv09.cizek;

import java.util.Scanner;
import cv09.cizek.MathTools;

public class MathToolsTest {

private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean znovu=true;
        int n; double a; double e;
        while (znovu) {
            System.out.println("----------------------------");
            System.out.println("1 - mocnina");
            System.out.println("2 - faktorial");
            System.out.println("3 - sinus s odchylkou");
            System.out.println("4 - prirozeny logaritmus s odchylkou");
            System.out.println("5 - druha odmocnina s odchylkou");
            System.out.println("0 - konec");
            System.out.println("----------------------------");
            int menu=sc.nextInt();
            switch (menu) {
                case 1 :
                    System.out.println("Zadej cislo a exponent: ");
                    a=sc.nextDouble(); n=sc.nextInt();
                    System.out.println(MathTools.aNaN(a, n));
                    break;
                case 2 :
                    System.out.println("Zadej cislo: ");
                    n=sc.nextInt();
                    System.out.println(MathTools.factorial(n));
                    break;
                case 3 :
                    System.out.println("Zadej cislo a odchylku: ");
                    a=sc.nextDouble(); e=sc.nextDouble();
                    System.out.println("MathTools: " + MathTools.sin(a, e));
                    System.out.println("Math: " + Math.sin(a));
                    break;
                case 4 :
                    System.out.println("Zadej cislo a odchylku: ");
                    a=sc.nextDouble(); e=sc.nextDouble();
                    System.out.println("MathTools: " + MathTools.ln(a, e));
                    System.out.println("Math: " + Math.log(a));
                    break;
                case 5 :
                    System.out.println("Zadej cislo vetsi jak 0 a odchylku: ");
                    a=sc.nextDouble(); e=sc.nextDouble();
                    System.out.println("MathTools: " + MathTools.sqrt(a, e));
                    System.out.println("Math: " + Math.sqrt(a));
                    break;
                case 0 :
                    System.out.println("Ukoncuji program.");
                    znovu=false;
                    break;
                default :
                    System.out.println("Spatna volba.");
            }
        }
    }
    
}

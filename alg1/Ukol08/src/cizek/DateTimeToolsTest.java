package cizek;

import java.util.Scanner;
import cizek.DateTimeTools;
import java.util.Arrays;


public class DateTimeToolsTest {

    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean znovu = true;
        int a, b, c;
        String d;
        float r;
        while (znovu) {
            System.out.println("=============================================");
            System.out.println("1 - test prestupneho roku");
            System.out.println("2 - test platnosti data");
            System.out.println("3 - pocet dnu v mesici");
            System.out.println("4 - test platnosti casu");
            System.out.println("5 - vypocet dne v tydnu");
            System.out.println("6 - formatovani data");
            System.out.println("7 - formatovani casu");
            System.out.println("8 - prevod casu na 1 hodnotu");
            System.out.println("9 - prevod sekund na 3 hodnoty");
            System.out.println("0 - konec programu");
            System.out.println("=============================================");
            int menu = sc.nextInt();
            switch (menu) {
                case 1 :
                    System.out.println("zadej rok: ");
                    a = sc.nextInt();
                    System.out.println((DateTimeTools.jePrestupnyRok(a)) ?
                            "Rok " + a + " je presupny" :
                            "Rok " + a + " neni prestupny");
                    break;
                case 2 :
                    System.out.println("zadej datum (DD MM YYYY): ");
                    a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();
                    System.out.println((DateTimeTools.platnostData(a, b, c)) ?
                            "Datum " + DateTimeTools.formatData(a, b, c) + " plati" :
                            "Datum neplati");
                    break;
                case 3 :
                    System.out.println("zadej mesic a rok: ");
                    a = sc.nextInt(); b = sc.nextInt();
                    System.out.println("Pocet dni mesice je " + DateTimeTools.pocetDnu(a, b));
                    System.out.println("-1 znaci spatne zadany mesic.");
                    break;
                case 4 :
                    System.out.println("zadej cas (HH MM SS): ");
                    a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();
                    System.out.println((DateTimeTools.platnostCasu(a, b, c)) ?
                            "Cas " + DateTimeTools.formatCasu(a, b, c) + " plati" :
                            "Cas neplati");
                    break;
                case 5 :
                    System.out.println("Zadej datum (DD MM YYYY): ");
                    a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();
                    System.out.println("Den je " + DateTimeTools.denTydneVMesici(a, b, c));
                    System.out.println("0 znaci sobotu, 1 nedeli, 2 pondeli, atd.");
                    break;
                case 6 :
                    System.out.println("Zadej datum (DD MM YYYY): ");
                    a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();
                    System.out.println(DateTimeTools.formatData(a, b, c));
                    break;
                case 7 :
                    System.out.println("zadej cas (HH MM SS): ");
                    a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();
                    System.out.println(DateTimeTools.formatCasu(a, b, c));
                    break;
                case 8 :
                    System.out.println("zadej volbu (h/m/s) a hodnoty (HH MM SS): ");
                    d = sc.next(); a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();
                    System.out.println("hodnota zadaneho casu je " + DateTimeTools.prevodCasu(d, a, b, c));
                    break;
                case 9 :
                    System.out.println("zadej sekundy: ");
                    r = sc.nextFloat();
                    System.out.println("cas je (HH MM SS): " + Arrays.toString(DateTimeTools.zpetnyPrevodCasu(r)));
                    break;
                case 0 :
                    System.out.println("koncim program");
                    znovu = false;
                    break;
                default :
                    System.out.println("Spatna volba, zkus znovu");
            }
        }
    }
    
}

package cizek;

import java.util.Scanner;

public class HraHadaniCisla {

private static final Scanner sc = new Scanner(System.in);
    private static int max;
    private static int min;
    public static void main(String[] args) {
        boolean dalsi = true;
        int vyber= 0;
        int cpu = 0; int player = 0;
        while (dalsi) {
            menu();
            vyber = sc.nextInt();
            switch(vyber) {
                case 1 :
                    inter();
                    break;
                case 2 :
                    switch (role()) {
                        case 1 :
                            player = player + clovekHada(min, max);
                            break;
                        case 2 :
                            cpu = cpu + pocitacHada(min, max);
                            break;
                    }
                    break;
                case 0 :
                    dalsi = false;
                    vitez(cpu, player);
                    break;
                default :
                    System.out.println("Spatna volba.");
            }
        }
    }
    
    private static void menu() {
        System.out.println("1 - novy interval");
        System.out.println("2 - role");
        System.out.println("0 - konec");
    }
    
    private static void inter() {
        System.out.println("zadej minimum a maximum intervalu: ");
        min = sc.nextInt(); max = sc.nextInt();
    }
    
    private static int role() {
        System.out.println("vyber roli: ");
        System.out.println("1 - clovek hada");
        System.out.println("2 - pocitac hada");
        int hada = sc.nextInt();
        return hada;
    }
    
    private static int clovekHada(int min, int max) {
        int cislo = (int)((Math.random()*(max-min))+min);
        System.out.println("Hadej: ");
        int pokusy = 1; int pokus;
        while ((pokus = sc.nextInt()) != cislo) {
            if (pokus<cislo) {
                System.out.println("cislo je vetsi.");
                pokusy++;
            } else if (pokus>cislo) {
                System.out.println("cislo je mensi.");
                pokusy++;
            }
        } 
        System.out.println("uhodl jsi");
        return pokusy;
    }
    
    private static int pocitacHada(int min, int max) {
        boolean done = false;
        char c; int cislo; int pokusy=1;
        while (!done) {
             cislo = (int)((Math.random()*(max-min))+min);
             System.out.println(cislo + " < (mensi) / > (vetsi) / =");
             switch (c = sc.next().charAt(0)) {
                 case '<' :
                     max = cislo;
                     pokusy++;
                     break;
                 case '>' :
                     min = cislo;
                     pokusy++;
                     break;
                 case '=' :
                     done = true;
                     break;
             }
        }
        return pokusy;
    }
    
    private static void vitez(int cpu, int player) {
        if (cpu>player) {
            System.out.println("vyhravas");
        } else if (cpu<player) {
            System.out.println("vyhrava pocitac");
        } else {
            System.out.println("remiza");
        }
    }
}

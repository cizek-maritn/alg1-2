/*
 * Copyright (C) 2022 Jirina Kralovcova
 * This program is part of Java programing education. 
 * You can use it as you need to learn Java. 
 */

package cizek.apps;

import cizek.apps.drawutils.StdDraw;
import cizek.hry.piskvorky.PiskvorkyException;
import java.util.InputMismatchException;
import java.util.Scanner;
import cizek.hry.piskvorky.PiskvorkyInterface;
import java.awt.Color;
import java.util.Arrays;
/**
 *
 * @author ALG
 */
public class PiskvorkyApp {
    
    private static final Scanner sc = new Scanner(System.in);
    static int pctR=5; static int pctS=5;
    static int barva1=1; static int barva2=2;
    static int symbol1=1; static int symbol2=2;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean konecProgramu;
        do {
            vypisMenu();
            int volba = nactiVolbu();
            konecProgramu = obsluzVolbu(volba);
        } while (!konecProgramu);
        System.out.println("Koncim ...");
    }

    private static void vypisMenu() {
        System.out.println("");
        System.out.println("Hlavni menu programu");
        System.out.println("1. Hrat hru Piskvorky");
        System.out.println("2. Zmena velikosti hraci plochy");
        System.out.println("3. Zmena symbolu pouzitych pro jednotlive hrace");
        System.out.println("4. Zmena barevneho nastaveni");
        System.out.println("0. Konec programu");
    }
    
    //testovaci kod funkcionalit v textove podobe
//    private static void vypisMenuHry() {
//        System.out.println("");
//        System.out.println("1. Polozit symbol");
//        System.out.println("2. zjistit symbol");
//        System.out.println("3. pocet radku");
//        System.out.println("4. pocet sloupcu");
//        System.out.println("5. aktualni hrac");
//        System.out.println("6. vyherce");
//    }

    private static int nactiVolbu() {
        int volba;
        try {
            volba = sc.nextInt();      
        } catch (InputMismatchException ex) {
            volba = -1;
        }
        sc.nextLine();
        return volba;
    }

    private static boolean obsluzVolbu(int volba) {
        switch (volba) {
            case 0: return true;
            case 1: hratHru(); break;
            case 2: zmenaRozmeru(); break;
            case 3: zmenaSymbolu(); break;
            case 4: zmenaBarev(); break;
            default:
                System.out.println("Neznama volba");
        }
        return false;
    }
    

    private static void hratHru() {
        System.out.println("");
        System.out.println("Hra piskvorky");
        System.out.println("Hra je realizovana v samostatnem okne ");
        PiskvorkyInterface psk = PiskvorkyInterface.getInstance(pctR, pctS);
        StdDraw.clear();
        StdDraw.setCanvasSize(psk.getPocetSloupcu() * 50,(psk.getPocetRadku() * 50));
        double intX=1./(psk.getPocetRadku()); double intY=1./(psk.getPocetSloupcu()); int matX, matY;
        for (int i = 1; i < pctR; i++) {
            StdDraw.line(0.0, 1./pctR * i, 1.0, 1./pctR * i);
        }
        for (int i = 1; i < pctS; i++) {
            StdDraw.line(1./pctS * i, 0.0, 1./pctS * i, 1.0);
        }
        
        StdDraw.setPenRadius(0.01);
        boolean konec = false;
        System.out.println("Hraje hrac: " + psk.getHrajeHrac());
        boolean pressed=false;
        while (!konec) {
            while (StdDraw.isMousePressed() && !pressed) {
                pressed=true;
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
                //System.out.println(x); System.out.println(intX);
                matX=(int) Math.floor(x/intX); matY=(int) Math.floor(y/intY);
                //System.out.println(matX + " " + matY);
                try {
                    psk.polozDalsiSymbol(matX, matY);
                    
                    if (psk.getHrajeHrac()==1) {
                        switch (barva2) {
                            case 1: StdDraw.setPenColor(Color.blue); break;
                            case 2: StdDraw.setPenColor(Color.red); break;
                            case 3: StdDraw.setPenColor(Color.black); break;
                            case 4: StdDraw.setPenColor(Color.cyan); break;
                            case 5: StdDraw.setPenColor(Color.magenta); break;
                        }
                        switch (symbol2) {
                            case 1: StdDraw.circle(((matX*intX)+ (intX/2)), ((matY*intY) + (intY/2)), intX/4); break;
                            case 2: {
                                StdDraw.line(((matX*intX)+ (intX/10)), ((matY*intY) + (intY/10)), ((matX*intX)+ 9*(intX/10)), ((matY*intY) + 9*(intY/10)));
                                StdDraw.line(((matX*intX)+ (intX/10)), ((matY*intY) + 9*(intY/10)), ((matX*intX)+ 9*(intX/10)), ((matY*intY) + (intY/10)));
                                break;
                            }
                            case 3: StdDraw.square(((matX*intX)+ (intX/2)), ((matY*intY) + (intY/2)), intX/4); break;
                        }
                        
                    }
                    if (psk.getHrajeHrac()==2) {
                        switch (barva1) {
                            case 1: StdDraw.setPenColor(Color.blue); break;
                            case 2: StdDraw.setPenColor(Color.red); break;
                            case 3: StdDraw.setPenColor(Color.black); break;
                            case 4: StdDraw.setPenColor(Color.cyan); break;
                            case 5: StdDraw.setPenColor(Color.magenta); break;
                        }
                        switch (symbol1) {
                            case 1: StdDraw.circle(((matX*intX)+ (intX/2)), ((matY*intY) + (intY/2)), intX/4); break;
                            case 2: {
                                StdDraw.line(((matX*intX)+ (intX/10)), ((matY*intY) + (intY/10)), ((matX*intX)+ 9*(intX/10)), ((matY*intY) + 9*(intY/10)));
                                StdDraw.line(((matX*intX)+ (intX/10)), ((matY*intY) + 9*(intY/10)), ((matX*intX)+ 9*(intX/10)), ((matY*intY) + (intY/10)));
                                break;
                            }
                            case 3: StdDraw.square(((matX*intX)+ (intX/2)), ((matY*intY) + (intY/2)), intX/4); break;
                        }
                        
                    }
                    if (psk.jeKonecHry()) {
                        System.out.println("Konec hry, vyhral hrac: " + psk.getCisloVyherce());
                        //kosmeticka vec, aby se vykreslil posledni polozeny znak
                        //velmi linej vymyslet neco lepsiho, proste jsem zkopiroval kod,
                        //co je par radku nad
                        if (psk.getHrajeHrac()==1) {
                        switch (barva2) {
                            case 1: StdDraw.setPenColor(Color.blue); break;
                            case 2: StdDraw.setPenColor(Color.red); break;
                            case 3: StdDraw.setPenColor(Color.black); break;
                            case 4: StdDraw.setPenColor(Color.cyan); break;
                            case 5: StdDraw.setPenColor(Color.magenta); break;
                        }
                        switch (symbol2) {
                            case 1: StdDraw.circle(((matX*intX)+ (intX/2)), ((matY*intY) + (intY/2)), intX/4); break;
                            case 2: {
                                StdDraw.line(((matX*intX)+ (intX/10)), ((matY*intY) + (intY/10)), ((matX*intX)+ 9*(intX/10)), ((matY*intY) + 9*(intY/10)));
                                StdDraw.line(((matX*intX)+ (intX/10)), ((matY*intY) + 9*(intY/10)), ((matX*intX)+ 9*(intX/10)), ((matY*intY) + (intY/10)));
                                break;
                            }
                            case 3: StdDraw.square(((matX*intX)+ (intX/2)), ((matY*intY) + (intY/2)), intX/4); break;
                        }
                        
                    }
                    if (psk.getHrajeHrac()==2) {
                        switch (barva1) {
                            case 1: StdDraw.setPenColor(Color.blue); break;
                            case 2: StdDraw.setPenColor(Color.red); break;
                            case 3: StdDraw.setPenColor(Color.black); break;
                            case 4: StdDraw.setPenColor(Color.cyan); break;
                            case 5: StdDraw.setPenColor(Color.magenta); break;
                        }
                        switch (symbol1) {
                            case 1: StdDraw.circle(((matX*intX)+ (intX/2)), ((matY*intY) + (intY/2)), intX/4); break;
                            case 2: {
                                StdDraw.line(((matX*intX)+ (intX/10)), ((matY*intY) + (intY/10)), ((matX*intX)+ 9*(intX/10)), ((matY*intY) + 9*(intY/10)));
                                StdDraw.line(((matX*intX)+ (intX/10)), ((matY*intY) + 9*(intY/10)), ((matX*intX)+ 9*(intX/10)), ((matY*intY) + (intY/10)));
                                break;
                            }
                            case 3: StdDraw.square(((matX*intX)+ (intX/2)), ((matY*intY) + (intY/2)), intX/4); break;
                        }
                        
                    }
                        konec=true;
                    }
                    if (!psk.jeKonecHry()) System.out.println("hraje hrac: " + psk.getHrajeHrac());
                } catch (PiskvorkyException b) {
                    //behem jednoho kliknuti StdDraw posle minimalne 2 signaly => chybove hlaseni + vypnuti programu
                    //takhle jsem to osetril. pravdepodobne asi neni nejlepsi reseni
                }
                
                
            }
            if (!StdDraw.isMousePressed()) {
                pressed=false;
            }
        }
        
    }

    private static void zmenaRozmeru() {
        
        System.out.println("");
        System.out.println("Nastaveni velikosti hraciho pole");
        System.out.println("Aktualni pocet radku: " + pctR + " Aktualni pocet sloupcu: " + pctS);
        System.out.println("Zadej novy pocet radku v rozsahu 5 az 30: ");
        int tempR=sc.nextInt();
        System.out.println("Zadej novy pocet sloupcu v rozsahu 5 az 30: ");
        int tempS=sc.nextInt();
        if (tempR < 5) {
            System.out.println("Pocet radku prilis maly: " + tempR);
        }
        else if (tempR > 30) {
            System.out.println("Pocet radku prilis velky: " + tempR);
        }
        else if (tempS < 5) {
            System.out.println("Pocet sloupcu prilis maly: " + tempS);
        }
        else if (tempS > 30) {
            System.out.println("Pocet sloupcu prilis velky: " + tempS);
        }
        else {
            pctR=tempR; pctS=tempS;
            System.out.println("Rozmer byl aktualizovan: " + pctR + " " + pctS);
        } 
    }
    
    //ja uz z toho StdDraw mam nocni mury
    private static void zmenaSymbolu() {
        System.out.println("");
        System.out.println("Nabidka symbolu: ");
        System.out.println("1 - kruh");
        System.out.println("2 - krizek");
        System.out.println("3 - ctverec");
        System.out.println("Zadej symbol hrace 1: ");
        int temp=sc.nextInt();
        if (temp < 1 || temp > 3) {
            System.out.println("Cislo mimo rozsah, zustava predchozi symbol: " + symbol1);
        } else {
            symbol1=temp;
        }
        System.out.println("Zadej barvu hrace 2: ");
        temp=sc.nextInt();
        if (temp < 1 || temp > 3) {
            System.out.println("Cislo mimo rozsah, zustava predchozi symbol: " + symbol2);
        } else {
            symbol2=temp;
        }
    }

    private static void zmenaBarev() {
        System.out.println("");
        System.out.println("Nabidka barev: ");
        System.out.println("1 - modra");
        System.out.println("2 - cervena");
        System.out.println("3 - cerna");
        System.out.println("4 - tyrkysova");
        System.out.println("5 - fialova");
        System.out.println("Zadej barvu hrace 1: ");
        int temp=sc.nextInt();
        if (temp < 1 || temp > 5) {
            System.out.println("Cislo mimo rozsah, zustava predchozi barva: " + barva1);
        } else {
            barva1=temp;
        }
        System.out.println("Zadej barvu hrace 2: ");
        temp=sc.nextInt();
        if (temp < 1 || temp > 5) {
            System.out.println("Cislo mimo rozsah, zustava predchozi barva: " + barva2);
        } else {
            barva2=temp;
        }
    }

}
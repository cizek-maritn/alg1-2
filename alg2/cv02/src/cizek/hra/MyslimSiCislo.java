package cizek.hra;

import java.util.Random;


public class MyslimSiCislo {
    private static final Random rnd = new Random();
    private final int dolniMez;
    private final int horniMez;
    private int pocetTipu=0;
    private int mysleneCislo;
    public boolean konecHry;

    public MyslimSiCislo(int dolniMez, int horniMez) {
        this.konecHry = false;
        this.dolniMez = dolniMez;
        this.horniMez = horniMez;
        //generovani tipu
        mysleneCislo=rnd.nextInt(horniMez-dolniMez + 1) + dolniMez;
    }

    public MyslimSiCislo(int horniMez) {
        this(1, horniMez);
        this.konecHry = false;
    }
    
    public boolean Hadani(int tip) {
        this.pocetTipu++;
        
        if (tip == mysleneCislo) {
            konecHry= true;
        } else if (tip<mysleneCislo) {
            System.out.println("Myslene cislo je vetsi"); konecHry= false;
        } else {
            System.out.println("Myslene cislo je mensi"); konecHry= false;
        }
        return konecHry;
    }

    public int getPocetTipu() {
        return pocetTipu;
    }
    
    
    
}

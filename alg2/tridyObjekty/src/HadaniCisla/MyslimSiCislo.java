package HadaniCisla;

import java.util.Random;


public class MyslimSiCislo {
    private static final Random rnd = new Random();
    private final int dolniMez;
    private final int horniMez;
    private int pocetTipu;
    private int mysleneCislo;
    private boolean konecHry;

    public MyslimSiCislo(int dolniMez, int horniMez) {
        this.dolniMez = dolniMez;
        this.horniMez = horniMez;
        //generovani tipu
        mysleneCislo=rnd.nextInt(horniMez-dolniMez + 1) + dolniMez;
    }

    public MyslimSiCislo(int horniMez) {
        this(1, horniMez);
    }
    
    
}

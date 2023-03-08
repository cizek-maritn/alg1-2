/*
 * Copyright (C) 2022 Jirina Kralovcova
 * This program is part of Java programing education. 
 * You can use it as you need to learn Java. 
 */

package cizek.hry.piskvorky;

/**
 *
 * @author ALG
 */
class Piskvorky implements PiskvorkyInterface{

    private final int pr;
    private final int ps;
    private int[][] matice;
    private int hrac=1;
    private boolean konec;
    
    Piskvorky(int pr, int ps) {
        this.pr=pr;
        this.ps=ps;
        this.matice=new int[pr][ps];
        this.konec=false;
    }
    

    @Override
    public int polozDalsiSymbol(int r, int s) {
        //102
        if (r < 0 || r > getPocetRadku()) {
            throw new PiskvorkyException("Pozice radku mimo herni pole " + r, 102, "" + r);
        }
        if (s < 0 || s > getPocetSloupcu()) {
            throw new PiskvorkyException("Maly pocet sloupcu", 102, "" + s);
        }
        //103
        if (matice[r][s]!=0) {
            throw new PiskvorkyException("Obsazene pole", 103, "" + r + " " + s);
        }
        //104
        if (jeKonecHry()) {
            throw new PiskvorkyException("Uz je konec hry", 104, "");
        }
        //polozeni
        if (this.hrac%2==1) matice[r][s]=1;
        else matice[r][s]=2;
        int a=Math.max(PiskvorkyTools.pocetStejnychVRadce(matice, r, s),PiskvorkyTools.pocetStejnychVSloupci(matice, r, s));
        int b=Math.max(PiskvorkyTools.pocetStejnychVDiag1(matice, r, s), PiskvorkyTools.pocetStejnychVDiag2(matice, r, s));
        this.hrac++;
        int n = Math.max(a, b);
        if (n>=5) {
            this.konec=true;
        }
        return n;
    }

    @Override
    public int getSymbol(int r, int s) {
        if (r < 0) {
            throw new PiskvorkyException("Maly pocet radku", 102, "" + r);
        }
        if (r > getPocetRadku()) {
            throw new PiskvorkyException("Velky pocet radku", 102, "" + r);
        }
        if (s < 0) {
            throw new PiskvorkyException("Maly pocet sloupcu", 102, "" + s);
        }
        if (s > getPocetSloupcu()) {
            throw new PiskvorkyException("Velky pocet sloupcu", 102, "" + s);
        }
        return matice[r][s];
    }

    @Override
    public int getPocetRadku() {
        return this.pr;
    }

    @Override
    public int getPocetSloupcu() {
        return this.ps;
    }

    @Override
    public boolean jeKonecHry() {
        return this.konec;
    }

    @Override
    public int getHrajeHrac() {
        if (jeKonecHry()) return 0;
        if (this.hrac%2==1) return 1;
        else return 2;
    }

    @Override
    public int getCisloVyherce() {
        if (jeKonecHry()) {
            if (this.hrac%2==0) return 1;
        else return 2;
        }
        return 0;
    }

    //public int[][] getMatice() {
    //    return matice;
    //}
    
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankApp;


/**
 *
 * @author Dell
 */
public class Ucet implements Comparable<Ucet>{
    private String jmeno;
    private String prijmeni;
    private final int rc;
    private double sporeni;
    private double castka;
    private final int CisloUctu;

    public Ucet(int CisloUctu, String jmeno, String prijmeni, int rc, double sporeni, double castka) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.rc = rc;
        this.sporeni = sporeni;
        this.castka = castka;
        this.CisloUctu = CisloUctu;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public int getRc() {
        return rc;
    }

    public double getSporeni() {
        return sporeni;
    }

    public double getCastka() {
        return castka;
    }

    public int getCisloUctu() {
        return CisloUctu;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public void setSporeni(double sporeni) {
        this.sporeni = sporeni;
    }

    public void setCastka(double castka) {
        this.castka = castka;
    }

    @Override
    public String toString() {
        return CisloUctu + ";" + jmeno + ";" + prijmeni + ";" + rc + ";" + sporeni + ";" + castka;
    }
    
    public void zmenaCastky(double zmena) {
        castka=castka+zmena;
    }
    
    public void urok() {
        castka=castka+(castka*sporeni/100);
    }

    @Override
    public int compareTo(Ucet o) {
        if (CisloUctu==o.CisloUctu) return 0;
        else if (CisloUctu>o.CisloUctu) return 1;
        else return -1;
    }
    
    
}

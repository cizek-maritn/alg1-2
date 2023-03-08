/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tridyobjekty;

/**
 *
 * @author Dell
 */
public class Penezenka {
    private long castka;

    public Penezenka() {
        this.castka=0;
    }

    public Penezenka(long castka) {
        this.castka = castka;
    }

    public long getCastka() {
        return castka;
    }
    
    public void vlozit(long vklad) {
        this.castka+=vklad;
    }
    
    public long vybratMaximalne(long vyber) {
        
        if (this.jeMozneVybrat(vyber)) {
            vyber=this.castka;
        }
        this.castka-=vyber;
        return vyber;
        
    }
    
    public long vybratPresne(long vyber) {
        if (this.jeMozneVybrat(vyber)) {
            return 0;
        }
        this.castka -=vyber;
        return vyber;
    }
    
    public boolean jeMozneVybrat(long vyber) {
        return vyber >= this.castka;
    }
    
    public static void main(String[] args) {
        Penezenka test = new Penezenka();
        
        test.vlozit(500);
        System.out.println(test.jeMozneVybrat(1000));
        System.out.println(test.getCastka());
        System.out.println(test.castka);
        
        System.out.println(test.vybratMaximalne(1000));
        System.out.println(test.getCastka());
        
        test.vlozit(750);
        
        System.out.println(test.vybratPresne(1200));
        System.out.println(test.getCastka());
    }
}

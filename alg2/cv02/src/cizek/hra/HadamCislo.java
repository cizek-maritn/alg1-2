//maxHorniMez: int, pocetTipu: int, dolni,horni: int,
//hadamCislo(maxHorniCislo)     getDalsiTip(): int  getPocetTipu():int  zaznamenejOdpoved(): int -1,0,1
package cizek.hra;


public class HadamCislo {
    private int dolniMez;
    private  int horniMez;
    private int pocetTipu=0;
    private int dalsiTip;
    public boolean konecHry=false;
    
    public HadamCislo(int dolniMez, int horniMez) {
        this.dolniMez=dolniMez;
        this.horniMez=horniMez;
        
    }
    
    public HadamCislo(int horniMez) {
        this(1, horniMez);
    }
    
    public int Hadam() {
        this.pocetTipu++;
        this.dalsiTip=(horniMez+dolniMez)/2;
        return this.dalsiTip;
    }
    
    public void Mensi() {
        this.horniMez=dalsiTip;
    }
    
    public void Vetsi() {
        this.dolniMez=dalsiTip;
    }
    
    public void Rovno() {
        this.konecHry=true;
    }
    
    public void Spatne() {
        this.pocetTipu--;
    }


    public int getPocetTipu() {
        return pocetTipu;
    }
    
    
}

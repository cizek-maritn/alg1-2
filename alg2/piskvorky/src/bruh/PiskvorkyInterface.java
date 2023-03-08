/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bruh;

/**
 *
 * @author Dell
 */
public interface PiskvorkyInterface {
    public static final int MIN_ROZMER = 5;
    public static final int MAX_ROZMER = 30;
    
    public static PiskvorkyInterface getInstance(int pr, int ps) {
        if (pr<MIN_ROZMER) {
            
        }
        if (pr>MAX_ROZMER) {
            
        }
        if (ps<MIN_ROZMER) {
            
        }
        if (ps>MAX_ROZMER) {
            
        }
            
        return new Piskvorky(pr,ps);
        
    }
    
    /**
     * Polozi dalsi symbol aktualne hrajiciho hrace na pozici (r, s), v pripade, ze je dana pozice volna
     * @param r index radku
     * @param s index sloupce
     * @return 
     */
    public int polozDalsiSymbol(int r, int s);
    
    /**
     * Poskytuje cislo symbolu polozeneho na pozici (r, s)
     * @param r index radku
     * @param s index sloupce
     * @return symbol 0, 1, 2
     */
    public int getSymbol(int r, int s);
    
    /**
     * vrati pocet radku hraciho pole
     * @return  pocet radku
     */
    public int getPocetRadku();
    
    /**
     * Vrati pocet sloupcu hraciho pole
     * @return pocet sloupcu
     */
    public int getPocetSloupcu();
    
    /**
     * Vraci informaci o ukonceni hry
     * @return true po ukonceni hry, false ostatni
     */
    public boolean jeKonecHry();
    
    /**
     * Pred ukoncenim hry vraci cislo hrace,ktery je na rade (1 nebo 2)
     * Po ukonceni hry vraci 0
     * @return cislo hrace nebo 0
     */
    public int getHrajeHrac();
    
    /**
     * Po ukonceni hry poskytuje cislo hrace, ktery vyhral (1 nebo 2)
     * Pred ukoncenim hry vrati 0
     * @return cislo hrace nebo 0
     */
    public int getCisloVyherce();
}

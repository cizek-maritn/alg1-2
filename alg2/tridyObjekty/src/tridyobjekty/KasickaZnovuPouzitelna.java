/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tridyobjekty;

/**
 *
 * @author Dell
 */
public class KasickaZnovuPouzitelna {
    private long castka;
    
    public KasickaZnovuPouzitelna() {
        this.castka=0;
    }
    
    public KasickaZnovuPouzitelna(long vklad) {
        this.castka = vklad;
    }
    
    public void vlozit(long vklad) {
        this.castka+=vklad;
    }
    
    public long vysypat() {
        long vysypanaCastka=this.castka;
        this.castka=0;
        
        return vysypanaCastka;
    }
}

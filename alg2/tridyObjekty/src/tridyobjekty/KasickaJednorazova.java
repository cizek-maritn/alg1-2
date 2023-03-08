/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tridyobjekty;

/**
 *
 * @author Dell
 */
public class KasickaJednorazova {
    private long castka;
    private boolean jeRozbita;
    
    public KasickaJednorazova() {
        this.castka=0;
    }
    
    public void vlozit(long vklad) {
        if (this.jeRozbita) {
            throw new IllegalStateException("kasicka je rozbita");
        }
        
        this.castka+=vklad;
    }
    
    public void slepit() {
        if (!this.jeRozbita) {
            throw new IllegalStateException("kasicka neni roybita");
        }
        this.jeRozbita=false;
    }
    
    public long rozbitAVybrat() {
        if (this.jeRozbita) {
            throw new IllegalStateException("kasicka je rozbita");
        }
        
        long vysypanaCastka=this.castka;
        this.castka=0;
        this.jeRozbita=true;
        
        return vysypanaCastka;
    }
}

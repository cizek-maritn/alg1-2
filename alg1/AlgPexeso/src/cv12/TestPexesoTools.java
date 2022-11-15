/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cv12;

/**
 *
 * @author Dell
 */
public class TestPexesoTools {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] mp = PexesoTools.getPoleRozlozeni(5, 5, 12);
        vypisMatici(mp);
        
        int pocetChyb=0;
        for (int i=0;i<100;i++) {
            mp=PexesoTools.getPoleRozlozeni(100, 100, 5000);
            if (!PexesoTools.jeMaticeProPexeso(mp, 5000)) {
                pocetChyb++;
            }
        }
        System.out.println("pocet chybnych matic: " + pocetChyb);
    }
    
    public static void vypisMatici(int[][] a) {
        System.out.println("");
        for (int i=0;i<a.length;i++) {
            for (int j=0;j<a[i].length;j++) {
                System.out.format("%4d ", a[i][j]);
            }
            System.out.println("");
        }
    }
}

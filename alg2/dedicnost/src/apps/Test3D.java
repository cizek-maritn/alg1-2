/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package apps;

import Geom3D.Geom3D;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Dell
 */
public class Test3D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Geom3D> geo = new ArrayList<>();
        geo.add(Geom3D.getInstance(3));
        geo.add(Geom3D.getInstance(Geom3D.TypObj.KVADR,1,1,8));
        geo.add(Geom3D.getInstance(9));
        geo.add(Geom3D.getInstance(2,3,4));
        
        for(Geom3D g : geo) {
            System.out.println(g + " " + g.getPlochaObjem());
        }
        System.out.println("");
        
        Collections.sort(geo, Geom3D.COMP_PLOCHA);
        for(Geom3D g : geo) {
            System.out.println(g + " " + g.getPlochaObjem());
        }
        System.out.println("");
        
        Collections.sort(geo);
        for(Geom3D g : geo) {
            System.out.println(g + " " + g.getPlochaObjem());
        }
        
    }
    
}

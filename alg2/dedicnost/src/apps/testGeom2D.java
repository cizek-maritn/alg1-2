/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package apps;

import Geom2D.Ctverec;
import Geom2D.Geom2D;
import static Geom2D.Geom2D.COMP_OBVOD;
import static Geom2D.Geom2D.COMP_PLOCHA;
import Geom2D.Obdelnik;
import Geom2D.Trojuhelnik;
import java.util.Arrays;

/**
 *
 * @author Dell
 */
public class testGeom2D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Trojuhelnik troj = new Trojuhelnik(4,3,5);
        System.out.println(troj.getObvod());
        System.out.println(troj.getPlocha());
        
        Geom2D[] obj= new Geom2D[3];
        obj[0]=troj;
        obj[1]= new Obdelnik(2,3);
        obj[2]= new Ctverec(1);
        
        for (Geom2D geom : obj) {
            System.out.println(geom + " " + geom.getGeomParams());
        }
        
        Arrays.sort(obj, COMP_PLOCHA);
        
        for (Geom2D geom : obj) {
            System.out.println(geom + " " + geom.getGeomParams());
        }
        
        Arrays.sort(obj, COMP_OBVOD);
        
        for (Geom2D geom : obj) {
            System.out.println(geom + " " + geom.getGeomParams());
        }
    }
    
}

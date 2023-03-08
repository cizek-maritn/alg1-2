/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Geom3D;

import java.util.Comparator;

/**
 *
 * @author Dell
 */
public interface Geom3D extends Comparable<Geom3D>{
    
    public static Geom3D getInstance(double... a) {
        if (a==null) return null;
        if (a.length==0) return null;
        if (a.length==1) return Krychle.getInstance(a[0]);
        if(a.length==3) return Kvadr.getInstance(a[0],a[1],a[2]);
        return null;
    }
    
    public static Geom3D getInstance(TypObj typ, double... a) {
        switch(typ) {
            case KRYCHLE : return Krychle.getInstance(a[0]);
            case KVADR : return Kvadr.getInstance(a[0], a[1], a[2]);
        }
        return null;
    }
    
    public static enum TypObj{
        KRYCHLE,KVADR;
    }
    
    public static final Comparator<Geom3D> COMP_PLOCHA=
            new Comparator<>() {
        @Override
        public int compare(Geom3D o1, Geom3D o2) {
            return (int) Math.round(Math.signum(o1.getPlocha() - o2.getPlocha()));
        }
                
            };
    
    public double getPlocha();
    public double getObjem();

    @Override
    public default int compareTo(Geom3D o) {
        return (int) Math.round(Math.signum(this.getObjem() - o.getObjem()));
    }
    
    
    
    public default String getPlochaObjem() {
        String st = " objem: " + getObjem() + " Plocha: " + getPlocha();
        return st;
    }
}

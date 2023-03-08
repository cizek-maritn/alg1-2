package Geom2D;

import java.util.Comparator;

public abstract class Geom2D implements Comparable<Geom2D>{
    public static final Comparator<Geom2D> COMP_OBVOD = 
            new Comparator<> () {
        @Override
        public int compare(Geom2D o1, Geom2D o2) {
            if (o1.getObvod()<o2.getObvod()) return -1;
            if (o1.getObvod()>o2.getObvod()) return 1;
            return 0;
        }
                
            };
    public static final Comparator<Geom2D> COMP_PLOCHA = 
            new Comparator<> () {
        @Override
        public int compare(Geom2D o1, Geom2D o2) {
            if (o1.getPlocha()<o2.getPlocha()) return -1;
            if (o1.getPlocha()>o2.getPlocha()) return 1;
            return 0;
        }
                
            };
    
    public abstract double getPlocha();
    public abstract double getObvod();

    @Override
    public int compareTo(Geom2D o) {
        if (this.getPlocha()<o.getPlocha()) return -1;
        if (this.getPlocha()==o.getPlocha()) return 0;
        return 1;
    }
    
    public String getGeomParams() {
        return String.format("%f %f", getPlocha(), getObvod());
    }
    
}

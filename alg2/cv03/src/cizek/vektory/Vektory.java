package cizek.vektory;

public class Vektory {
    
    private Vektory() {
        
    }
    
    public static Vektor soucet(Vektor a, Vektor b) {
        double x=a.getX()+b.getX();
        double y=a.getY()+b.getY();
        double z=a.getZ()+b.getZ();
        return new Vektor(x,y,z);
    }
    
    public static Vektor rozdil(Vektor a, Vektor b) {
        double x=a.getX()-b.getX();
        double y=a.getY()-b.getY();
        double z=a.getZ()-b.getZ();
        return new Vektor(x,y,z);
    }
    
    public static Vektor skalarSoucin(Vektor a, Vektor b) {
        double x=a.getX()*b.getX();
        double y=a.getY()*b.getY();
        double z=a.getZ()*b.getZ();
        return new Vektor(x,y,z);
    }
    
    public static Vektor vektorSoucin(Vektor a, Vektor b) {
        double x=a.getY()*b.getZ() - a.getZ()*b.getY();
        double y=a.getZ()*b.getX() - a.getX()*b.getZ();
        double z=a.getX()*b.getY() - a.getY()*b.getX();
        return new Vektor(x,y,z);
    }
}

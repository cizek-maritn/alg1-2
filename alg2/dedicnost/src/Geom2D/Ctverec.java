package Geom2D;


public class Ctverec extends Geom2D{
    private final double a;
    private final double plocha;
    private final double obvod;

    public Ctverec(double a) {
        if (a<0) throw new IllegalArgumentException("neplatny rozmer: " + a);
        
        this.a = a;
        this.plocha=4*a;
        this.obvod=a*a;
    }

    public double getA() {
        return a;
    }

    @Override
    public double getPlocha() {
        return this.plocha;
    }

    @Override
    public double getObvod() {
        return this.obvod;
            }

    @Override
    public String toString() {
        return "Ctverec{" + "a=" + a + '}';
    }

        
    
}

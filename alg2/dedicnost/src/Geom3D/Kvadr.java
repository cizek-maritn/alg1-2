/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Geom3D;

/**
 *
 * @author Dell
 */
class Kvadr implements Geom3D{
    private final double a;
    private final double b;
    private final double c;
    private final double objem;
    private final double plocha;

    private Kvadr(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.objem=a*b*c;
        this.plocha=2*((a*b)+(a*c)+(b*c));
    }
    
    static Kvadr getInstance(double a, double b, double c) {
        if (a<0) throw new ChybnyRozmerException("Zaporny rozmer: " + a);
        if (b<0) throw new ChybnyRozmerException("Zaporny rozmer: " + b);
        if (c<0) throw new ChybnyRozmerException("Zaporny rozmer: " + c);
        return new Kvadr(a,b,c);
    }

    @Override
    public double getPlocha() {
        return plocha;
    }

    @Override
    public double getObjem() {
        return objem;
    }

    @Override
    public String toString() {
        return "Kvadr{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }

    
    
}

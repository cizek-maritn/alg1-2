/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Geom3D;

/**
 *
 * @author Dell
 */
class Krychle implements Geom3D{
    private final double a;
    private final double objem;
    private final double plocha;

    private Krychle(double a) {
        this.a = a;
        this.objem=a*a*a;
        this.plocha=6*a*a;
    }
    
    static Krychle getInstance(double a) {
        if (a<0) return null;
        return new Krychle(a);
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
        return "Krychle{" + "a=" + a + '}';
    }
    
    
}

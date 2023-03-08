/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Geom2D;

/**
 *
 * @author Dell
 */
public class Trojuhelnik extends Geom2D{
    private final double a;
    private final double b;
    private final double c;

    public Trojuhelnik(double a, double b, double c) {
        if (a<0) throw new IllegalArgumentException("neplatny rozmer: " + a);
        if (b<0) throw new IllegalArgumentException("neplatny rozmer: " + b);
        if (c<0) throw new IllegalArgumentException("neplatny rozmer: " + c);
        if(a+b<c || Math.abs(a-b)>c) throw new IllegalArgumentException("neplatny rozmery");
        
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public double getPlocha() {
        double s= getObvod()/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    @Override
    public double getObvod() {
        return a+b+c;
    }

    @Override
    public String toString() {
        return "Trojuhelnik{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Geom2D;

/**
 *
 * @author Dell
 */
public class Obdelnik extends Geom2D{
    private final double a;
    private final double b;

    public Obdelnik(double a, double b) {
        if (a<0) throw new IllegalArgumentException("neplatny rozmer: " + a);
        if (b<0) throw new IllegalArgumentException("neplatny rozmer: " + b);
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    public double getPlocha() {
        return a*b;
    }

    @Override
    public double getObvod() {
        return 2*(a+b);
    }

    @Override
    public String toString() {
        return "Obdelnik{" + "a=" + a + ", b=" + b + '}';
    }
    
    
}

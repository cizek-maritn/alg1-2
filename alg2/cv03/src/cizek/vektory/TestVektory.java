package cizek.vektory;

public class TestVektory {


    public static void main(String[] args) {
        Vektor v1= new Vektor(3.5, 2, -1.2);
        Vektor v2= new Vektor(-6.45, 0, 2.1);
        System.out.println("v1: " + v1);
        System.out.println("v2: " + v2);
        System.out.println(Vektory.soucet(v1, v2));
        System.out.println(Vektory.rozdil(v1, v2));
        System.out.println(Vektory.skalarSoucin(v1, v2));
        System.out.println(Vektory.vektorSoucin(v1, v2));
    }
    
}

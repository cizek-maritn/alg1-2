package cizek.polynom;


public class PolynomTest {


    public static void main(String[] args) {
        Polynom p1 = Polynom.getInstance(1, 1, 1);
        Polynom p2 = Polynom.getInstance(1, 1, 1);
        System.out.println(p1.toFmtString());
        System.out.println(p2.toFmtString());
        System.out.println(p1.getDerivovany());
        System.out.println(p2.getHodnota(3));
        System.out.println(Polynomy.soucet(p1, p2));
        System.out.println(Polynomy.soucin(p1, p2));
    }
    
}

package cizek.polynom;

import java.util.Arrays;



public class Polynom {
    
    private double[] koef;
    
    private Polynom(double[] koef) {
        this.koef = koef;
    }
    
    public static Polynom getInstance(double... a) {
        if (a.length<0) return null;
        if (a==null) return null;
        double[] k=Arrays.copyOf(a, a.length);
        int b=a.length;
        for (int i=a.length-1;i>=0;i--) {
            if (a[i]!=0) {
                b=i+1;
                break;
            }
        }
        k=Arrays.copyOf(k, b);
        return new Polynom(k);
    }
    
    public int getStupen() {
        return koef.length-1;
    }
    
    public double getKoef(int index) {
        //index mimo rozsah = 0
        if (index<0 || index >= koef.length) return 0.;
        return koef[index];
    }
    
    public double getHodnota(double x) {
        double h=x*koef[koef.length-1];
        for (int i=koef.length-2;i>0;i--) {
            h=h*x + koef[i];
        }
        h+=koef[0];
        return h;
    }
    
    public Polynom getDerivovany() {
        double[] b = new double[koef.length-1];
        for (int i=1;i<koef.length;i++) {
            b[i-1]=koef[i]*i;
        }
        return new Polynom(b);
    }
    
    
    public String toFmtString() {
        String v="";
        for (int i=0;i<koef.length;i++) {
            if (koef[i]!=0 && i==0) v+=koef[i];
            else if (koef[i]==0 && i==0) v+="0";    //jediny zpusob co me napdal, jak na pripady, kdy polynom nema konstantni clen (psalo by to "+ 3*x + ...)
            else if (koef[i] !=0 && i==1) v+=" + " + koef[i] + "x";
            else if (koef[i]!=0) {
                v+=" + " + koef[i] + "x^" + i;
            }
        }
        return v;
    }

    @Override
    public String toString() {
        return "Polynom{" + "koef=" + Arrays.toString(koef) + '}';
    }
    
    
    
    
    
//    public static void main(String[] args) {
//        Polynom p=Polynom.getInstance(7);
//        System.out.println(p);
//        p=Polynom.getInstance(7, 8, 9, 4.5);
//        System.out.println(p);
//        p=Polynom.getInstance(new double[]{7});
//        System.out.println(p);
//        
//    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Arrays.hashCode(this.koef);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Polynom other = (Polynom) obj;
        return Arrays.equals(this.koef, other.koef);
    }
}
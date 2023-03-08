package cizek.vektory;

public class Vektor {
    private final double x;
    private final double y;
    private final double z;
    
    public Vektor(double x, double y, double z) {
        this.x=x;
        this.y=y;
        this.z=z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
    
    private static double delkaVektoru(double x, double y, double z) {
        double d=Math.sqrt((x*x)+(y*y)+(z*z)); //pohodlnejsi nez trikrat psat Math.pow
        return d;
    }
    
    private Vektor jednotkovyVektor() {
        double d=delkaVektoru(this.x, this.y, this.z);
        double x=this.x/d;
        double y= this.y/d;
        double z=this.z/d;
        return new Vektor(x, y, z);
    }
    
    @Override
    public String toString() {
        return this.x + ", " + this.y + ", " + this.z;
    }
    
    public static Vektor parseVektor(String str) {
        String[] pole = str.split(", ");
        return new Vektor(Double.parseDouble(pole[0]), Double.parseDouble(pole[1]), Double.parseDouble(pole[2]));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
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
        final Vektor other = (Vektor) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return Double.doubleToLongBits(this.z) == Double.doubleToLongBits(other.z);
    }
    
    
}

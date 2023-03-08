package cool;


public class Zlomek {
    private final int citatel;
    private final int jmenovatel;
    
    public Zlomek(int citatel, int jmenovatel) {
        if (jmenovatel ==0) {
            throw new IllegalArgumentException("Nulovy jmenovatel: " + jmenovatel);
        }
        if (jmenovatel <0) {
            citatel = -citatel;
            jmenovatel = Math.abs(jmenovatel);
        }
        int delitel=nejvetsiDelitel(Math.abs(citatel), jmenovatel);
        this.citatel=citatel/delitel;
        this.jmenovatel=jmenovatel/delitel;
    }
    
    private static int nejvetsiDelitel(int a, int b) {
        int c;
        while (b!=0) {
            c=b;
            b=a%b;
            a=c;
        }
        return a;
    }

    public int getCitatel() {
        return citatel;
    }

    public int getJmenovatel() {
        return jmenovatel;
    }
    
    public Zlomek getPrevraceny() {
        return new Zlomek(this.jmenovatel, this.citatel);
    }
    
    public Zlomek getOpacny() {
        return new Zlomek(-this.citatel, this.jmenovatel);
    }
    
    public double toDouble() {
        return ((double) this.citatel)/this.jmenovatel;
    }
    
    @Override
    public String toString() {
        return this.citatel + "/" + this.jmenovatel;
    }
    
    public static Zlomek parseZlomek(String str) {
        String[] pole = str.split("/");
        return new Zlomek(Integer.parseInt(pole[0]), Integer.parseInt(pole[1]));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.citatel;
        hash = 79 * hash + this.jmenovatel;
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
        final Zlomek other = (Zlomek) obj;
        if (this.citatel != other.citatel) {
            return false;
        }
        return this.jmenovatel == other.jmenovatel;
    }
    
    
}

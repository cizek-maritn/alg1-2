package cv09.cizek;


public class MathTools {
    
    /**
     * vypocita mocninu cisla
     * @param a zaklad mocniny
     * @param n exponent
     * @return 
     */
    public static double aNaN(double a, int n) {
        int i=0; double m=1;
        while (i<n) {
            m=m*a;
            i++;
        }
        if (n<0) {
            m=1/m;
        }
        return m;
    }
    
    /**
     * vypocita faktorial cisla
     * @param n zaklad faktorialu
     * @return 
     */
    public static double factorial(int n) {
        int i=0; long f=1;
        while (i<n) {
            f=f*(n-i);
            i++;
        }
        return f;
    }

    /**
     * priblizny sinus cisla s odchylkou
     * @param x cislo
     * @param eps odchylka
     * @return 
     */
    public static double sin(double x, double eps) {
        int k=1; int sl=1; double mv=Double.MAX_VALUE; double v=0;
        while (mv>eps) {
            mv=aNaN(x, k)/factorial(k);
            if (sl%2==1) {
                v=v+mv;
            } else {
                v=v-mv;
            }
            k=k+2; sl++;
        }
        return v;
    }
    
    /**
     * priblizny prirozeny logaritmus cisla
     * @param x cislo
     * @param eps odchylka
     * @return 
     */
    public static double ln(double x, double eps) {
        int k=1; double mv=Double.MAX_VALUE; double v=0; double c=x-1; double j=x+1;
        while (mv>eps) {
            mv=aNaN(c, k)/(k*aNaN(j, k));
            v=v+mv;
            k=k+2;
        }
        v=v*2;
        return v;
    }
    
    /**
     * pribliznadruha odmocnina cisla
     * @param x cislo
     * @param eps odchylka
     * @return 
     */
    public static double sqrt(double x, double eps) {
        double yi=x; double yk=0; double d=0; 
        while (Math.abs(yi-d)>eps) {
            yk=((x/yi)+yi)/2;
            d=yi; yi=yk;
        }
        return yk;
    }
}

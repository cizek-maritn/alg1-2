package cv10.cizek;


public class ArrayTools {
    
    /**
     * secte vsechny prvky pole
     * @param a pole
     * @return 
     */
    public static double soucet(double [] a) {
        double sum=0; int i=0;
        while (i<a.length) {
            sum=sum+a[i];
            i++;
        }
        return sum;
    }
    
    /**
     * secte pocet prvnich prvku pole
     * @param a pole
     * @param n  pocet prvku
     * @return 
     */
    public static double soucet(double [] a, int n) {
        double sum=0; int i=0;
        while (i<n) {
            sum=sum+a[i];
            i++;
        }
        return sum;
    }
    
    /**
     * zjisti maximum pole
     * @param a pole
     * @return 
     */
    public static double maximum(double [] a) {
        double max=Double.NEGATIVE_INFINITY; int i=0;
        while (i<a.length) {
            if (a[i]>max) {
                max=a[i];
            }
            i++;
        }
        return max;
    }
    
    /**
     * najde prvni pozici maxima pole
     * @param a pole
     * @return 
     */
    public static int prvniPoziceMaxima(double [] a) {
        double max=maximum(a); int i=0; boolean znovu=true;
        while (znovu) {
            if (a[i]==max) {
                znovu=false;
            }
            i++;
        }
        return i; //vrati pozici, jako kdyby pole zacinalo a[1] a ne a[0]
    }
    
    /**
     * najde posledni pozici maxima pole
     * @param a pole
     * @return 
     */
    public static int posledniPoziceMaxima(double [] a) {
        double max=maximum(a); int i=a.length - 1; boolean znovu=true;
        while (znovu) {
            if (a[i]==max) {
                znovu=false;
            }
            i--;
        }
        i=i+2;
        return i;
    }
    
    /**
     * zjisti kolikratse urcite cislo vyskytuje v casti pole
     * @param a pole
     * @param n pocet prohledanych prvku
     * @param cislo hledane cislo
     * @return 
     */
    public static int pocetVyskytu(double [] a, int n, double cislo) {
        int k=0; int i=0;
        while (i<n) {
            if (a[i]==cislo) {
                k++;
            }
            i++;
        }
        return k;
    }
    
    /**
     * zjisti, jestli je pole vzestupne usporadane
     * @param a pole
     * @param n pocet prvku
     * @return 
     */
    public static boolean jeVzestupneUsporadana(double [] a, int n) {
        boolean usporadanost=true; int i=0;
        while (i<n-1 && usporadanost) {
            if (a[i]>=a[i+1]) {
                usporadanost=false;
            }
            i++;
        }
        return usporadanost;
    }
    
    /**
     * zjisti jestli je pole stridave
     * @param a pole
     * @return 
     */
    public static boolean jeStridavaPosloupnost(double [] a) {
        boolean stridava=true; int i=1; int poc=1; int j=0; int k;
        if (a[0]<0) {
            poc=-1;
        }
        while (j<a.length) {
            if (a[j]==0) {
                stridava=false;
            }
            j++;
        }
        while (i<a.length) {
            k=(i+1)%2;
            switch (k) {
                case 0 :
                    switch (poc) {
                        case 1 :    //kladny zacatek, 2 4 6
                            if (a[i]>0) {
                                stridava=false;
                            } break;
                        case -1 :   //zaporny zacatek, 2 4 6
                            if (a[i]<0) {
                                stridava=false;
                            }  break;
                    }
                    break;
                case 1 :
                    switch (poc) {
                        case 1 :    //kladny zacatek 1 3 5
                            if (a[i]<0) {
                                stridava=false;
                            } break;
                        case -1 :   //zaporny zacatek 1 3 5
                            if (a[i]>0) {
                                stridava=false;
                            } break;
                    }
                    break;
            }
            i++;
        }           
        return stridava;
    }
    
    /**
     * obrati poradi prvku pole
     * @param a pole
     */
    public static void reverse(double [] a) {
        int i=0; int k=a.length -1; double tmp;
        while (i<=k) {
            tmp=a[i]; a[i]=a[k]; a[k]=tmp;
            i++; k--;
        }
    }
    
    /**
     * vrati obracene pole
     * @param a pole
     * @return 
     */
    public static double[] getReversed(double [] a) {
        double [] b = new double[a.length]; int i=0; int k=a.length -1;
        while (i<a.length) {
            b[i]=a[k];
            i++; k--;
        }
        return b;
    }
}

package cizek;


public class DateTimeTools {
    
    /**
     * test, jestli je rok prestupny
     * @param y rok
     * @return 
     */
    public static boolean jePrestupnyRok(int y) {
        return y%4==0;
    }
    
    /**
     * test, jestli je datum platne
     * @param d den
     * @param m mesic
     * @param y rok
     * @return 
     */
    public static boolean platnostData(int d, int m, int y) {
        return (m<=12 && m>=1 && d>=1 && d<=pocetDnu(m, y));
    }
    
    /**
     * pocet dni v jednotlivych mesicich
     * @param m mesic
     * @param y rok
     * @return 
     */
    public static int pocetDnu(int m, int y) {
        int days=0;
        switch(m) {
            case 1, 3, 5, 7, 8, 10, 12 : {
                days = 31;
                break;
            }
            case 4, 6, 9, 11 : {
                days = 30;
                break;
            }
            case 2 : {
                if (jePrestupnyRok(y)) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            }
            default : days=-1;
        }
        return days;
    }
    
    /**
     * test, jestli je zadany cas platny
     * @param h hodiny
     * @param mm minuty
     * @param s sekundy
     * @return 
     */
    public static boolean platnostCasu(int h, int mm, int s) {
        return (h>=0 && h<24 && mm>=0 && mm<60 && s>=0 && s<60);
    }
    
    /**
     * vypocet dne v mesici daneho roku, 0 = sobota, 1 = nedele, ..., 6 = patek
     * @param d den
     * @param m mesic
     * @param y rok
     * @return 
     */
    public static int denTydneVMesici(int d, int m, int y) {
        int day=9;
        if (platnostData(d, m, y)) {
            if (m<3) {
                y = y-1;
                m = m+12;
            }
            day = (d+((26*(m+1))/10)+y+(y/4)+(6*(y/100))+(y/400))%7;
        }
        return day;
    }
    
    /**
     * naformatuje datum
     * @param d den
     * @param m mesic
     * @param y rok
     * @return 
     */
    public static String formatData(int d, int m, int y) {
        if (!platnostData(d, m, y)) {
            return ("Neplatne datum.");
        } else {
            return (d + "." + m + "." + y);
        }
    }
    
    /**
     * naformatuje cas
     * @param h hodiny
     * @param mm minuty
     * @param s sekundy
     * @return 
     */
    public static String formatCasu(int h, int mm, int s) {
        if (!platnostCasu(h, mm, s)) {
            return ("Neplatny cas");
        } else {
            return (h + ":" + mm + ":" + s);
        }
    }
    
    /**
     * prevod casu na jedinou jednotku
     * @param k vyber jednotky vysledku (h, mm, s)
     * @param h hodiny
     * @param mm minuty
     * @param s sekundy
     * @return 
     */
    public static float prevodCasu(String k, int h, int mm, int s) {
        float r = 0;
        switch (k) {
            case "h" : {
                r = h + (mm/60.F) + (s/3600.F);
                break;
            }
            case "m" : {
                r = (h*60) + mm + (s/60.F);
                break;
            }
            case "s" : {
                r = (h*3600) + (mm*60) + s;
            }
        }
        return r;
    }
    
    /**
     * prevede cas v sekundach na 3 hodnoty
     * @param r hodnota ziskana z prevodCasu
     * @return 
     */
    public static int[] zpetnyPrevodCasu(float r) {
        int t[] = new int[3];
                t[0] = (int)r/3600;
                r = r-(t[0]*3600);
                t[1] = (int)r/60;
                t[2] = (int)r%60;
        
        return t;
    }
}

package cizek.datumcas;

public class Kalendar {
    
    private int den;
    private int mesic;
    private int rok;
    private static final int[] pocetDnu = {31,28,31,30,31,30,31,31,30,31,30,31};
    private static final int[] pocetDnuP = {31,29,31,30,31,30,31,31,30,31,30,31};
    
    public static enum weekday{
        SOBOTA,NEDELE,PONDELI,UTERY,STREDA,CTVRTEK,PATEK;
    }

    private Kalendar(int den, int mesic, int rok) {
        this.den = den;
        this.mesic = mesic;
        this.rok = rok;
    }
    
    private Kalendar(Kalendar kal) {
        this.den=kal.getDen();
        this.mesic=kal.getMesic();
        this.rok=kal.getRok();
    }
    
    public static Kalendar getInstance(int d,int m, int r) {
        if (m<1 || m>12 || d<1) return null;
        if (jePrestupnyRok(r) && d>pocetDnuP[m]) return null;
        if (!jePrestupnyRok(r) && d>pocetDnu[m]) return null;
        return new Kalendar(d,m,r);
    }
    
    public static Kalendar getInstance(Kalendar kal) {
        return new Kalendar(kal);
    }
    
    public static boolean jePrestupnyRok(int y) {
        return y%4==0;
    }

    public int getDen() {
        return den;
    }

    public int getMesic() {
        return mesic;
    }

    public int getRok() {
        return rok;
    }
    
    public static int getDenTydne(int d, int m, int y) {
        if (m < 3) {
                m += 12;
                y -= 1;
            }
        int day= (d + ((26 * (m + 1)) / 10) + y + (y / 4) + (6 * (y / 100) + (y / 400))) % 7;
        
        if (day==0) day=7;
        if (day==1) day=8;
        return day-1;
    }
    
    public String getDatumAsStr() {
        return den + "." + mesic + "." + rok;
    }
    
    public String getMesicniKalendar() {
        StringBuilder str = new StringBuilder();
        int[] dny = new int[37];
        int start = getDenTydne(1, this.mesic, this.rok)-1;
        if (this.rok%4==0) {
            for (int i=0;i<pocetDnuP[getMesic()-1];i++) {
                dny[i+start]=i+1;
            }
        }
        else {
            for (int i=0;i<pocetDnu[getMesic()-1];i++) {
                dny[i+start]=i+1;
            }
        }
        System.out.println(dny[start]);
        String main = "PO UT ST CT PA SO NE " + this.mesic + ". " + this.rok;
        str.append(main);
        String d;
        for (int i=0;i<37;i++) {
            if (i%7==0) str.append("\n");
            if (dny[i]==0) d="   ";
            else if (dny[i]<10) d=" " + dny[i] + " ";
            else d=dny[i] + " ";
            str.append(d);
        }
        return str.toString();
    }
    
    public int dalsiDen() {
        return this.den++;
    }
    
    public int predchoziDen() {
        return this.den--;
    }
    
    public int dalsiMesic() {
        this.den=1;
        return this.mesic++;
    }
    
    public int predchoziMesic() {
        this.den=1;
        return this.mesic--;
    }
    
    public int dalsiRok() {
        this.den=1;
        this.mesic=1;
        return this.rok++;
    }
    
    public int predchoziRok() {
        this.den=1;
        this.mesic=1;
        return this.rok--;
    }
    
    public static void main(String[] args) {
        
    }
}
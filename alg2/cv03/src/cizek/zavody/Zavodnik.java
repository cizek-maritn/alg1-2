package cizek.zavody;


public class Zavodnik {
    //public static final String TIME_PARTS_SEPARATOR = ":";
    //public static Comparator<Zavodnik> COMP_DLE_JMEN =
    //          new Comparator<Zavodnik>();
    //          @Override
    //          public int compare(Zavodnik o1, Zavodnik o2) {
    //              int vysl=o2.prijmeni...
    private final String jmeno;
    private final String prijmeni;
    private final int rocnik;
    private final long reg;
    private static long regC=1;
    private long start=0;
    private long end=0;
    private long cas;

    
    public Zavodnik(String jmeno, String prijmeni, int rocnik) {
        this.jmeno=jmeno;
        this.prijmeni=prijmeni;
        this.rocnik=rocnik;
        this.reg=regC++;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public int getRocnik() {
        return rocnik;
    }

    public long getReg() {
        return reg;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public void setEnd(long end) {
        this.end = end;
    }
    
    public long casZavodu() {
        this.cas=this.end-this.start;
        return cas;
    }
    
}

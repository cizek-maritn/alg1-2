package cool;


public final class Zlomky {
    
    private Zlomky() {
    }
    
    public static Zlomek soucet(Zlomek a, Zlomek b) {
        int ci = a.getCitatel()*b.getJmenovatel() + b.getCitatel()*a.getJmenovatel();
        int jo = a.getJmenovatel()*b.getJmenovatel();
        return new Zlomek (ci, jo);
    }
    
    public static Zlomek soucin(Zlomek a, Zlomek b) {
        int ci= a.getCitatel()*b.getCitatel();
        int jo = a.getJmenovatel()*b.getJmenovatel();
        return new Zlomek (ci, jo);
    }
    
    public static Zlomek rozdil(Zlomek a, Zlomek b) {
        return soucet(a, b.getOpacny());
    }
    
    public static Zlomek podil(Zlomek a, Zlomek b) {
        return soucin(a, b.getPrevraceny());
    }
}

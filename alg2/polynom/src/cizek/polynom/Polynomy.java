package cizek.polynom;


public class Polynomy {
    
    private Polynomy() {
        
    }
    
    public static Polynom soucet(Polynom p, Polynom q) {
        int max=Math.max(p.getStupen(), q.getStupen())+1;
        double[] r=new double[max];
        for (int i=0;i<max;i++) {
            r[i]=p.getKoef(i)+q.getKoef(i);
        }
        return Polynom.getInstance(r);
    }
    
    public static Polynom soucin(Polynom p, Polynom q) {
        double[] r=new double[p.getStupen()+q.getStupen()+1];
        for (int i=0;i<p.getStupen()+1;i++) {
            for (int j=0;j<q.getStupen()+1;j++) {
                r[i+j]+=p.getKoef(i)*q.getKoef(j);
            }
        }
        return Polynom.getInstance(r);
    }
}

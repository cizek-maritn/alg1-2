package cv12;
import java.util.Random;

public class PexesoTools {
    
    private static final Random rnd = new Random();
    
    private PexesoTools() {
    }
    
    //public static void rozlozeniKaret(int[][] a, int n) {
        
    //}
    
    public static int[][] getPoleRozlozeni(int pr, int ps, int n) {
        if (2*n>pr*ps) return null;
        int[][] mat = new int [pr][ps];
        for (int i=1;i<=n;i++) {
            for (int j=0;j<2;j++) {
                int rpos=rnd.nextInt(pr);
                int spos=rnd.nextInt(ps);
                while (mat[rpos][spos]!=0) {
                    spos++;
                    if (spos>=ps) {rpos++; spos=0;}
                    if (rpos>=pr) {rpos=0; spos=0;}
                }
                mat[rpos][spos]=i;
            }
        }
        
        return mat;
    }
    
    public static boolean jeMaticeProPexeso(int[][] a, int n) {
        int[] vyskyty = new int[n+1];
        for (int i=0;i<a.length;i++) {
            for (int j=0;j<a[i].length;j++) {
                if (a[i][j]<0 || a[i][j]>n) return false;
                vyskyty[a[i][j]]++;
            }
        }
        for (int i=1;i<vyskyty.length;i++) {
            if (vyskyty[i] != 2) return false;
        }
        return true;
    }
    
    public static double getPrumernaVzdalenost(int[][] a, int n) {
        
    }
}

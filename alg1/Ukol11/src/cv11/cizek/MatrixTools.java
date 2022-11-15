/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cv11.cizek;

/**
 *
 * @author Dell
 */
public class MatrixTools {
    private MatrixTools() {}
    
    public static double[][] soucetMatic(double[][] a, double[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            return null;
        }
        int pr=a.length;
        int ps=a[0].length;
        double[][] c=new double[pr][ps];
        for (int i=0;i<pr;i++) {
            for (int j=0;i<ps;i++) {
                c[i][j]=a[i][j]+b[i][j];
            }
        }
        return c;
    }
    
    public static double[][] soucinMatic(double[][] a, double[][] b) {
        if (a[0].length != b.length) {
            return null;
        }
        int pr=a.length;
        int ps=b[0].length;
        int dv=b.length;
        double[][] c=new double[pr][ps];
        for (int i=0;i<pr;i++) {
            for (int j=0;i<ps;i++) {
                c[i][j]=0;
                for (int k=0;k<dv;k++) {
                    c[i][j]+= a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
    
    public static double[][] normalizovanyTvar(double[][] a) {
        int pr=a.length; int ps=a[0].length; double max=0;
        for (int i=0;i<pr;i++) {
            for (int j=0;j<ps;j++) {
                if (Math.abs(a[i][j])>max) {
                    max=Math.abs(a[i][j]);
                }
            }
        }
        if (max==0) {
            return null;
        }
        for (int i=0;i<pr;i++) {
            for (int j=0;j<ps;j++) {
                a[i][j] = a[i][j] / max;
            }
        }
        return a;
    }
    
    public static boolean jeSymetricka(int[][] a) {
        int pr=a.length; int ps=a[0].length;
        if (pr != ps) {
            return false;
        }
        for (int i=0;i<pr;i++) {
            for (int j=0;j<ps;j++) {
                if (a[i][j] != a[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean stejneSoucty(int[][] a) {
        int pr=a.length; int ps=a[0].length;
        if (pr != ps) {
            return false;
        }
        //soucty diagonal
        int diag1=0; int diag2=0;
        for (int i=0;i<pr;i++) {
                diag1 += a[i][i];
                diag2 += a[i][pr-1-i];
        }
        if (diag1 != diag2) {
            return false;
        }
        //soucty radku
        int rdk=0; int slp=0;
        for (int i=0;i<pr;i++) {
            for (int j=0;j<ps;j++) {
                rdk += a[i][j];
                slp += a[j][i];
            }
            if (rdk != diag1 || slp != diag1) {
                return false;
            }
            rdk=0; slp=0;
        }
        return true;
    }
}

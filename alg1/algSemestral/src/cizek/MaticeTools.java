package cizek;

public class MaticeTools {
    private MaticeTools() {}
    
    //Testovaci kod jsem nepouzil, vse jsem testoval naraz az v dokoncenem UI.
    
    /**
     * zjisti, jestli jsou dve matice stejne
     * @param a prvni matice
     * @param b druha matice
     * @return hodnota true nebo false
     */
    public static boolean stejneMatice(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            return false;
        }
        int pr=a.length; int ps=a[0].length;
        for (int i=0;i<pr;i++) {
            for (int j=0;j<ps;j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }
    
    /**
     * zjisti, jestli jsou dve matice stejne v absolutni hodnote
     * @param a prvni matice
     * @param b druha matice
     * @return hodnota true nebo false
     */
    public static boolean stejneMaticeAbs(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            return false;
        }
        int pr=a.length; int ps=a[0].length;
        for (int i=0;i<pr;i++) {
            for (int j=0;j<ps;j++) {
                if (Math.abs(a[i][j]) != Math.abs(b[i][j])) return false;
            }
        }
        return true;
    }
    
    /**
     * zjisti, jestli maji dve matice stejne minimum
     * @param a prvni matice
     * @param b druha matice
     * @return hodnota true nebo false
     */
    public static boolean stejneMin(int[][] a, int[][] b) {
        int pra=a.length; int psa=a[0].length; int prb=b.length; int psb=b[0].length;
        int mina=Integer.MAX_VALUE; int minb=Integer.MAX_VALUE;
        for (int i=0;i<pra;i++) {
            for (int j=0;j<psa;j++) {
                if (a[i][j]<mina) mina=a[i][j];
            }
        }
        for (int i=0;i<prb;i++) {
            for (int j=0;j<psb;j++) {
                if (b[i][j]<minb) minb=b[i][j];
            }
        }
        if (mina==minb) return true;
        else return false;
    }
    
    /**
     * zjisti, jestli maji dve matice stejne maximum
     * @param a prvni matice
     * @param b druha matice
     * @return hodnota true nebo false
     */
    public static boolean stejneMax(int[][] a, int[][] b) {
        int pra=a.length; int psa=a[0].length; int prb=b.length; int psb=b[0].length;
        int maxa=Integer.MAX_VALUE; int maxb=Integer.MAX_VALUE;
        for (int i=0;i<pra;i++) {
            for (int j=0;j<psa;j++) {
                if (a[i][j]>maxa) maxa=a[i][j];
            }
        }
        for (int i=0;i<prb;i++) {
            for (int j=0;j<psb;j++) {
                if (b[i][j]>maxb) maxb=b[i][j];
            }
        }
        if (maxa==maxb) return true;
        else return false;
    }
    
    /**
     * zjisti, jestli se soucty prvku dvou matic rovnaji
     * @param a prvni matice
     * @param b druha matice
     * @return hodnota true nebo false
     */
    public static boolean stejneSoucty(int[][] a, int[][] b) {
        int pra=a.length; int psa=a[0].length; int prb=b.length; int psb=b[0].length;
        int suma=0; int sumb=0;
        for (int i=0;i<pra;i++) {
            for (int j=0;j<psa;j++) {
                suma += a[i][j];
            }
        }
        for (int i=0;i<prb;i++) {
            for (int j=0;j<psb;j++) {
                sumb += b[i][j];
            }
        }
        if (suma==sumb) return true;
        else return false;
    }
    
    /**
     * zjisti, jestli prvky dvou matic patri do stejne mnoziny
     * @param a prvni matice
     * @param b druha matice
     * @return hodnota true nebo false
     */
    public static boolean stejnaMnozina(int[][] a, int[][] b) {
        int pra=a.length; int psa=a[0].length; int prb=b.length; int psb=b[0].length;
        boolean found=false;
        for (int i=0;i<pra;i++) {
            for (int j=0;j<psa;j++) {
                for (int k=0;k<prb;k++) {
                    if (found) {
                        found=false; break;
                    }
                    for (int l=0;l<psb;l++) {
                        if (a[i][j]==b[k][l]) {
                            found=true; break;
                        }
                        else if (a[i][j]!=b[k][l] && k==(prb-1) && l==(psb-1))
                            return false;
                    }
                }
            }
        }
        return true;
    }
    
    /**
     * zjisti, jestli dve matice maji stejny pocet stejnych cisel
     * @param a prvni matice
     * @param b druha matice
     * @return hodnota true nebo false
     */
    public static boolean stejnyPocet(int[][] a, int[][] b) {
        if (a.length*a[0].length != b.length*b[0].length || !stejnaMnozina(a, b)) {
            return false;
        }
        int pra=a.length; int psa=a[0].length; int prb=b.length; int psb=b[0].length;
        int[][] c= new int[pra*psa][2]; int[][] d = new int[prb*psb][2];
        
        for (int i=0;i<pra;i++) {
            for (int j=0;j<psa;j++) {
                for (int k=0;k<c.length;k++) {
                    if (c[k][0]==0) {
                        c[k][0]=a[i][j];
                        c[k][1]=1; break;
                    }
                    else if (c[k][0]==a[i][j]) {
                        c[k][1]++; break;
                    }
                }
            }
        }
        for (int i=0;i<prb;i++) {
            for (int j=0;j<psb;j++) {
                for (int k=0;k<d.length;k++) {
                    if (d[k][0]==0) {
                        d[k][0]=b[i][j];
                        d[k][1]=1; break;
                    }
                    else if (d[k][0]==b[i][j]) {
                        d[k][1]++; break;
                    }
                }
            }
        }
        
        for (int i=0;i<c.length;i++) {
            for (int j=0;j<d.length;j++) {
                if (c[i][0]==d[j][0]) {
                    if (c[i][1]==d[j][1]) break;
                    else return false;
                }
                if (c[i][0]!=d[j][0] && j==(d.length-1)) return false;
            }
        }
        return true;
    }
    
}

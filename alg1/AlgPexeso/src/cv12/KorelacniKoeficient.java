package cv12;

import java.util.Scanner;

public class KorelacniKoeficient {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //nacteni dat
        double[][] data;
        System.out.println("pocet dat: ");
        int pocet = sc.nextInt();
        data = new double[2][pocet];
        System.out.println("data: ");
        for (int i=0;i<pocet;i++) {
            data[0][i]=sc.nextDouble();
            data[1][i]=sc.nextDouble();
        }
        
        //prumery
        double sumx=0; double sumy=0;
        for (int i=0;i<pocet;i++) {
            sumx += data[0][i];
            sumy += data[1][i];
        }
        double prx = sumx/pocet;
        double pry = sumy/pocet;
        
        //kor. koef.
        double citatel=0; double sumxi=0; double sumyi=0;
        for (int i=0;i<pocet;i++) {
            citatel=citatel+((data[0][i]-prx)*(data[1][i]-pry));
            sumxi=sumxi+Math.pow((data[0][i]-prx), 2);
            sumyi=sumyi+Math.pow((data[1][i]-pry), 2);
        }
        double r=citatel/Math.sqrt(sumxi*sumyi);
        System.out.println(r);
    }
    
}

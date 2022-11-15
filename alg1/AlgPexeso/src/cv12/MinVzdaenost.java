package cv12;

import java.util.Scanner;

public class MinVzdaenost {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("pocet bodu: ");
        int pocet = sc.nextInt();
        System.out.println("souradnice bodu: ");
        double[][] sour=new double[pocet][2];
        for (int i=0;i<pocet;i++) {
            sour[i][0]=sc.nextDouble();
            sour[i][1]=sc.nextDouble();
        }
        
        //vzdalenosti
        double vzd; double min=Double.MAX_VALUE; int bod1=0; int bod2=0;
        for (int i=0;i<pocet;i++) {
            for (int j=i+1;j<pocet;j++) {
                vzd=Math.hypot(Math.abs(sour[i][0] - sour[j][0]), Math.abs(sour[i][1]-sour[j][1]));
                if (vzd<min) {
                    min=vzd; bod1=i; bod2=j;
                }
            }
        }
        System.out.println("vzdalenost: " + min);
        System.out.println("bod 1: " + (bod1+1) + " se souradnicemi " + sour[bod1][0] + " " + sour[bod1][1]);
        System.out.println("bod 2: " + (bod2+1) + " se souradnicemi " + sour[bod2][0] + " " + sour[bod2][1]);
    }
    
}

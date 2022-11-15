package ulohy;

import java.util.Scanner;

public class Maxima {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int max1=0; int max2=0; int max3=0; int max4=0;
        int k1=0; int k2 =0; int k3=0; int k4=0; int pocet=sc.nextInt(); int next;
        for (int i=1;i<=pocet;i++) {
            while ((next=sc.nextInt())>0) {
                if (next>max1) {max4=max3;k4=k3;max3=max2;k3=k2;max2=max1;k2=k1;max1=next;k1=0;}
                else if (next>max2 && next<max1) {max4=max3;k4=k3;max3=max2;k3=k2;max2=next;k2=0;}
                else if (next>max3 && next<max2 && next<max1) {max4=max3;k4=k3;max3=next;k3=0;}
                else if (next>max4 && next<max3 && next<max2 && next<max1) {max4=next;k4=0;}
                if (next==max1) k1++;
                else if (next==max2) k2++;
                else if (next==max3) k3++;
                else if (next==max4) k4++;
            }
            System.out.println(max1 + " " + k1);
            System.out.println(max2 + " " + k2);
            System.out.println(max3 + " " + k3);
            System.out.println(max4 + " " + k4);
            max1=0; max2=0; max3=0; max4=0;
            k1=0; k2=0; k3=0; k4=0;
        }
    }
    
}

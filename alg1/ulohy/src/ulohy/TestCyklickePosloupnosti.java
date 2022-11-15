package ulohy;

import java.util.Scanner;

public class TestCyklickePosloupnosti {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int posl=sc.nextInt(); int pocet; int prvek; int prvekp=-1; boolean cykl=true; int N=0;
        for (int i=1;i<=posl;i++) {
            pocet=sc.nextInt();
            for (int j=1;j<=pocet;j++) {
                prvek=sc.nextInt();
                if (prvekp<0) {prvekp=prvek;}
                else if (prvekp+1!=prvek && prvek>0) {cykl=false;}
                else if (prvek==0 && prvekp!=(N-1)) {cykl=false;}
                if (N-1<prvek) N=prvek+1;
                prvekp=prvek;
            }
            if (!cykl) N=-1;
            System.out.println(N);
            cykl=true; N=0; prvekp=-1;
        }
    }
    
}

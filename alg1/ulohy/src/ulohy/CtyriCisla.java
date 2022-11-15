package ulohy;

import java.util.Scanner;

public class CtyriCisla {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n=sc.nextInt(); boolean r=true;
        long n1; long n2; long n3; long n4;
        for (int i=0;i<n;i++) {
            n1=sc.nextLong(); n2=sc.nextLong();
            n3=sc.nextLong(); n4=sc.nextLong();
            long a;
            while (r) {
                if (n1>n2) {
                    a=n1; n1=n2; n2=a;
                } if (n2>n3) {
                    a=n2; n2=n3; n3=a;
                } if (n3>n4) {
                    a=n3; n3=n4; n4=a;
                } if (n1<=n2 && n2<=n3 && n3<=n4) r=false;
            }
            System.out.println(n1 + " " + n2 + " " + n3 + " " + n4);
            r=true;
        }
    }
    
}

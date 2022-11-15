package ulohy;

import java.util.Scanner;

public class Vyskyt {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int ulohy=sc.nextInt(); int s1; int s2; int pocet; int prvek; boolean next=false; boolean v=false;
        boolean same=false;
        for (int i=1;i<=ulohy;i++) {
            s1=sc.nextInt(); s2=sc.nextInt(); pocet=sc.nextInt();
            if (s1==s2) same=true;
            for (int j=1;j<=pocet;j++) {
                prvek=sc.nextInt();
                if (same && next && prvek==s1) v=true;
                if (prvek==s1) next=true;
                else if (prvek==s2 && next) v=true;
                else if (prvek!=s2 && next) next=false;
            }
            System.out.println(v);
            v=false; next=false;
        }
    }
    
}

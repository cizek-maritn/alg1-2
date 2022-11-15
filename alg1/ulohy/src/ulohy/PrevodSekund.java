package ulohy;

import java.util.Scanner;

public class PrevodSekund {

private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int sec=sc.nextInt();
        int h=sec/3600;
        sec=sec%3600;
        int m=sec/60;
        int s=sec%60;
        System.out.format("%02d:%02d:%02d%n", h, m, s);
    }
    
}

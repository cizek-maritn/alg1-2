/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mocniny;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Mocniny {

    private static final Scanner sc = new Scanner(System.in);
    
    public static double mocninaRek(double x, int n) {
        if (n==0 || x==1) return 1;
        if (n==1) return x;
        if (n>0) {
            return x*mocninaRek(x, n-1);
        } else {
            return 1/(x/mocninaRek(x, n+1));
        }
        
    }
    public static void vypisHierarchiiAdresaru(File adr) {
        
        if (!adr.isDirectory()) {
            throw new IllegalArgumentException("neexistuje");
        }
        vypisHierarchiiAdresaru(adr,0);
    }
    
    private static void vypisHierarchiiAdresaru(File file, int level) {
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("neni");
        } else {
            File[] vypis = file.listFiles();
            for (File f : vypis) {
                System.out.println(f.toString());
                if (f.isDirectory()) {
                    vypisHierarchiiAdresaru(f);
                }
            }
            
        }
    }
    
    public static long velikostAdresare(File file) {
        long vysl=0;
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("neni");
        } else {
            File[] vypis = file.listFiles();
            
            for (File f : vypis) {
                
                if (f.isFile()) {
                    
                    vysl+=f.length();
                }
                
                else if (f.isDirectory()) {
                    
                    vysl+=velikostAdresare(f);
                }
            }
            
        }
        return vysl;
        
    }
    
    public static void main(String[] args) {
        File adr= new File(".");
        System.out.println(velikostAdresare(adr));
    }
    
}

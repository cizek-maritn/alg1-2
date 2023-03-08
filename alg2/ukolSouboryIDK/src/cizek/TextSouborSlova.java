package cizek;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class TextSouborSlova {

    private static Scanner sc = new Scanner(System.in);
    
    
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Zadej cestu k souboru: ");
        String soubor = sc.nextLine();
        String stat = soubor.split("\\.")[0] + "_slova." + soubor.split("\\.")[1];
        
        try (Scanner in = new Scanner(new File(soubor));
                PrintWriter out = new PrintWriter(stat)) {
            
            String slovo; List<Slovo> list = new ArrayList<Slovo>();
            while (in.hasNext()) {
                slovo = in.next();
                //nevim jak vytvorit instanci tridy pouze pokud neexistuje
                Slovo s = new Slovo(slovo);
                
                if (!list.contains(s)) {
                    list.add(s);
                } else {
                    s.incrPocet();
                }
            
            }
            System.out.println(Arrays.toString(list.toArray()));
            out.println("puvodni soubor: " + soubor);
            for(int i=0;i<list.size();i++){
                out.println(list.get(i).toString());
            } 
        }
    }
    

    private static class Slovo {

        private final String word;
        private int pocet;
        
        public Slovo(String word) {
            this.word=word;
            this.pocet=1;
        }

        public String getWord() {
            return word;
        }

        public int getPocet() {
            return pocet;
        }
        
        public int incrPocet() {
            return this.pocet++;
        }

        @Override
        public String toString() {
            return word + " se vyskytuje " + pocet;
        }
        
        
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import org.xml.sax.SAXException;

/**
 *
 * @author Dell
 */
public class KopieTextSouboruKodovani {

    
    private static final Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("vstupni soubor: ");
        String jmin = sc.nextLine();
        System.out.println("kodovani vstupniho souboru: ");
        String kodin = sc.nextLine();
        System.out.println("vystup do souboru: ");
        String jmout = sc.nextLine();
        System.out.println("kodovani vystupniho souboru: ");
        String kodout = sc.nextLine();
        
        try(Scanner in = new Scanner(new File(jmin), kodin);
                PrintWriter out = new PrintWriter(new File(jmout), kodout)) {
            String radek;
            while (in.hasNextLine()) {
                radek = in.nextLine();
                out.println(radek);
            }
        }
        
        List<String> radky = Files.readAllLines(Path.of(jmin), Charset.forName(kodin));
        Files.write(Path.of(jmout), radky, Charset.forName(kodout));
        
        byte[] bin = Files.readAllBytes(Paths.get(jmin));
        System.out.println(bin.length);
        String text = new String(bin, kodin);
        byte[] bout = text.getBytes(kodout);
        Files.write(Paths.get(jmout), bout, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        
        try (BufferedReader br = Files.newBufferedReader(Path.of(jmin), Charset.forName(kodin));
                BufferedWriter bw = Files.newBufferedWriter(Path.of(jmout), Charset.forName(kodout))) {
            String radek2;
            while ((radek2 = br.readLine()) != null) {
                bw.write(radek2);
                bw.newLine();
            }
        }
        
        System.out.println(System.getProperty("file.encoding"));
        try (BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(jmin),kodin));
                BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(jmout),kodout))) {
            int ch;
            while ((ch = r.read()) >= 0) {
                System.out.println(ch + " " + (char)ch);
                w.write(ch);
            }
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavodnik;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ZavodRegistrace {
    private Path regFile;
    private int posregcislo;
    
    private ZavodRegistrace (Path path, int preg) {
        regFile = path;
        posregcislo = preg;
    }
    
    public static ZavodRegistrace getInstance(String soubor) throws IOException {
        return getInstance(Paths.get(soubor));
    }
    
    public  static ZavodRegistrace getInstance(Path path) throws IOException {
        //overit, zda soubor existuje
        path = path.toAbsolutePath().normalize();
        if (!Files.isRegularFile(path)) {
            Files.createFile(path);
            return new ZavodRegistrace(path, 0);
        }
        
        //popripade nacist data
        int max = 0;
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String radek;
            br.readLine();
            
            int regc;
            while ((radek=br.readLine())!=null) {
                radek = radek.trim();
                if (radek.length()==0) {
                    continue;
                }
                //mozna validace
                String[] data = radek.split(";");
                regc = Integer.parseInt(data[0]);
                if (regc > max) max = regc;
            }
        }
        return new ZavodRegistrace(path, max);
    }
    
    public boolean pridejZavodnika(String jmeno, String prijmeni, String rocnik) throws IOException {
        posregcislo++;
        try (BufferedWriter bw = Files.newBufferedWriter(regFile, StandardOpenOption.APPEND, StandardOpenOption.WRITE)
            
                String zapis = String.format("%d;%s;%s;%d", posregcislo, jmeno, prijmeni, rocnik)) {
                    bw.write(zapis);
                    bw.newLine();
                }
        //pridelit cislo
        //zapsat do souboru
        //
        
    }
    
    public List<String> getVypisZavodniku() {
        return null;
    }
    
//    public String getVypisZavodniku() {
//        
//    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cizek;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Dell
 */
public class Ucet {
    
    private File file;
    
    private Ucet(File file) {
        this.file=file;
    }
    
    public static Ucet getInstance(File adr, int cisloUctu) throws IOException {
        File file = new File(adr, getJmenoUctu(cisloUctu));
        if(!file.exists()) {
            file.createNewFile();
        }
        return new Ucet(adr);
    }
    
    private static String getJmenoUctu(int cislo) {
        return String.format("ucet%010d.dat", cislo);
    }
}

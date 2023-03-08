
package cizek;

import java.io.File;
import java.io.IOException;


public class CommandLine {
    private File adr;
    
    public CommandLine(String adresar) {
        this.adr=new File(adresar);
    }
    
    public void help() {
        String[] help = {"dir <adr> - vypise adresar", "cd <adr> - zmeni aktualni adresar",
        "mkfile <sbr> - vytvori soubor", "mkdir <adr> - vytvori adresar", "mkdirs <pth> - vytvori cestu souboru", 
        "rename <jm1> <jm2> - prejmenuje soubor jm1 na jm2"};
        for (int i=0;i<help.length;i++) {
            System.out.println(help[i]);
        }
    }

    public File getAdr() {
        return adr;
    }
    
    
    
    public void dir() {
        
        File soubor=getAdr();
        File[] ff = soubor.listFiles();
        
                        for (int i=0; i<ff.length; i++) {
                            if (ff[i].isDirectory()) System.out.println("adresar " + ff[i].getName());
                            else System.out.println("soubor " + ff[i].getName());
                        }
                        
    }
    
    public void dir(String str) {
        File soubor=new File(str);
        if (soubor.exists()) {
            File[] ff = soubor.listFiles();
        
                        for (int i=0; i<ff.length; i++) {
                            if (ff[i].isDirectory()) System.out.println("adresar " + ff[i].getName());
                            else System.out.println("soubor " + ff[i].getName());
                        }
                        
        }
        else {
            System.out.println("Zadany soubor/adresar neexistuje");
            
        }
    }
    
    public void cd(String str) throws IOException {
        File soubor=new File(str);
        if (soubor.exists()) this.adr=new File(adr.getAbsolutePath() + "/" + str);
    }
    
    public boolean mkfile(String str) throws IOException {
        File soubor=new File(str);
        try {
        if (soubor.createNewFile()) {
            return soubor.createNewFile();
        }
        } catch (IOException a) {
            System.out.println("Soubor neslo vytvorit.");
        }
        return false;
    }
    
    public boolean mkdir(String str) {
        File adr=new File(str);
        if (!adr.isDirectory()) {
            adr.mkdir(); return true;
        } else return false;
    }
    
    public boolean mkdirs(String str) {
        File adr=new File(str);
        if (!adr.isDirectory()) {
            adr.mkdirs(); return true;
        } else return false;
    }
    
    public boolean rename(String str1, String str2) throws IOException {
        File f1=new File(str1); File f2=new File(str2);
        if (f2.exists()) {System.out.println("soubor jiz existuje."); return false;}
        else f1.renameTo(f2); return f1.renameTo(f2);
    }
}

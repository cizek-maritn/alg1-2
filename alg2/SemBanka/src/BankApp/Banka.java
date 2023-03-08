package BankApp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Banka {
    
    private final File bank;
    private int dalsiCislo=0;
    private List<Ucet> CelyList;
    private List<Ucet> KratkyList;
    
    private Banka(File file, List<Ucet> list, List<Ucet> krList) throws IOException {
        this.bank=file;
        this.CelyList = list;
        this.KratkyList=krList;
        this.dalsiCislo=KratkyList.size();
    }
    
    /**
     * Vytvori instanci tridy Banka. Pokud zadany soubor neexistuje, vytvori ho. Pokud soubor existuje, vytvori listy pro tridu Banka.
     * @param path cesta k souboru Banky
     * @return
     * @throws IOException 
     */
    public static Banka getInstance(String path) throws IOException {        
        //instance Banky
        File soubor = new File(path);
        if (!soubor.exists()) {
            soubor.createNewFile();
            try (PrintWriter pw = new PrintWriter(soubor)) {
                pw.print("číslo účtu;jméno;příjmení;rodné číslo;spoření;částka");
            }
            List<Ucet> list = new ArrayList();
            return new Banka(soubor, list, list);
        }
        else {
            List<String> ucty = Files.readAllLines(soubor.toPath());
            List<Ucet> list = new ArrayList();
            for (String s : ucty) {
                String[] str = s.split(";");
                if (!str[0].equals("číslo účtu")) {
                    list.add(new Ucet(Integer.parseInt(str[0]), str[1], str[2], Integer.parseInt(str[3]), Double.parseDouble(str[4]), Double.parseDouble(str[5])));
                }
            }
            List<Ucet> kratkyList = new ArrayList();
            if (!list.isEmpty()) {
                kratkyList.add(list.get(list.size()-1));
            }
            boolean add;
            for (int i=list.size()-2; i>=0;i--) {
                add=true;
                String[] abc = list.get(i).toString().split(";");
                    for (int j=0; j<kratkyList.size();j++) {
                        String[] def = kratkyList.get(j).toString().split(";");
                        if (abc[0].equals(def[0])) {
                            add=false;
                        }
                    }
                    if (add) {
                        kratkyList.add(list.get(i));
                    }
                }
            //sort
            Collections.sort(kratkyList);
            return new Banka(soubor, list, kratkyList);
        }  
    }

    /**
     * Vytvori novy Ucet a zapise jej do souboru Banky.
     * @param jmeno krestni jmeno pro novy Ucet
     * @param prijmeni prijmeni pro novy Ucet
     * @param rc rodne cislo pro novy Ucet
     * @param sporeni mira sporeni pro novy Ucet
     * @param castka pocatecni castka pro novy Ucet
     * @throws IOException 
     */
    public void novyUcet(String jmeno, String prijmeni, int rc, double sporeni, double castka) throws IOException {
        int cislo = updateDalsiCislo();
        
        try (BufferedWriter bw = Files.newBufferedWriter(this.bank.toPath(), StandardOpenOption.APPEND, StandardOpenOption.WRITE)) {
            String novyUcet = cislo + ";" + jmeno + ";" + prijmeni + ";" + rc + ";" + sporeni + ";" + castka;
            bw.newLine();
            bw.write(novyUcet);
            //update listu
            CelyList.add(new Ucet(cislo, jmeno, prijmeni, rc, sporeni, castka));
            KratkyList.add(new Ucet(cislo, jmeno, prijmeni, rc, sporeni, castka));
        }
    }
    
    /**
     * Vytvori Ucet s jiz pouzitym cislem uctu a udela novy zapis do souboru
     * @param ucet cislo Uctu
     * @param jmeno jmeno Uctu
     * @param prijmeni prijmeni Uctu
     * @param rc rodne cislo Uctu
     * @param sporeni sporeni Uctu
     * @param castka castka Uctu
     * @throws IOException 
     */
    public void novyZapis(int ucet, String jmeno, String prijmeni, int rc, double sporeni, double castka) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(this.bank.toPath(), StandardOpenOption.APPEND, StandardOpenOption.WRITE)) {
            String novyUcet = ucet + ";" + jmeno + ";" + prijmeni + ";" + rc + ";" + sporeni + ";" + castka;
            bw.newLine();
            bw.write(novyUcet);
            //update listu
            Ucet e = new Ucet(ucet, jmeno, prijmeni, rc, sporeni, castka);
            CelyList.add(e);
            KratkyList.remove(ucet-1);
            KratkyList.add(e);
            Collections.sort(KratkyList);
        }
    }
    
    /**
     * Navysi dalsiCislo pred jeho pouzitim
     * @return dalsiCislo + 1
     * @throws IOException 
     */
    private int updateDalsiCislo() throws IOException {
        dalsiCislo++;
        return dalsiCislo;
        }
    
    /**
     * Zmeni penezni stav konta
     * @param ucet cislo Uctu
     * @param zmena cislo, o ktere se ma zmeni castka
     * @throws IOException 
     */
    public void zmenaStavuKonta(int ucet, double zmena) throws IOException {
        Ucet menenyUcet = KratkyList.get(ucet-1);
        menenyUcet.zmenaCastky(zmena);
        novyZapis(menenyUcet.getCisloUctu(), menenyUcet.getJmeno(), menenyUcet.getPrijmeni(), menenyUcet.getRc(), menenyUcet.getSporeni(), menenyUcet.getCastka());
    }
    
    /**
     * Zmeni penezni stav konta dle miry uroku Uctu
     * @param ucet cislo uctu
     * @throws IOException 
     */
    public void zuroceni(int ucet) throws IOException {        
            Ucet menenyUcet = KratkyList.get(ucet-1);
            menenyUcet.urok();
            novyZapis(menenyUcet.getCisloUctu(), menenyUcet.getJmeno(), menenyUcet.getPrijmeni(), menenyUcet.getRc(), menenyUcet.getSporeni(), menenyUcet.getCastka());
             
    }
    
    /**
     * Zmeni udaje Uctu.
     * @param ucet cislo Uctu
     * @param jmeno nove jmeno Uctu
     * @param prijmeni nove prijmeni Uctu
     * @param sporeni nova mira sporeni Uctu
     * @throws IOException 
     */
    public void zmenaUdaju(int ucet, String jmeno, String prijmeni, double sporeni) throws IOException {
            Ucet menenyUcet = KratkyList.get(ucet-1);
            menenyUcet.setJmeno(jmeno);
            menenyUcet.setPrijmeni(prijmeni);
            menenyUcet.setSporeni(sporeni);
            novyZapis(menenyUcet.getCisloUctu(), menenyUcet.getJmeno(), menenyUcet.getPrijmeni(), menenyUcet.getRc(), menenyUcet.getSporeni(), menenyUcet.getCastka());
    }

    public int getDalsiCislo() {
        return dalsiCislo;
    }

    public List<Ucet> getCelyList() {
        return CelyList;
    }

    public List<Ucet> getKratkyList() {
        return KratkyList;
    }
    
    
}    



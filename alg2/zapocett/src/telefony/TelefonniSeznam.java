package telefony;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Martin Cizek
 */
public class TelefonniSeznam {

    private List<Pracoviste> pracoviste;
    private List<Zamestnanec> zamestnanci;

    private TelefonniSeznam(List<Pracoviste> pracoviste, List<Zamestnanec> zamestnanci) {
        this.pracoviste = pracoviste;
        this.zamestnanci = zamestnanci;
    }

    public static TelefonniSeznam getInstance(String jmSoubPrac, String jmSoubZam) throws IOException {
        File sbrPrac = new File(jmSoubPrac);
        File sbrZam = new File(jmSoubZam);
//        if (!sbrPrac.exists()) {
//            sbrPrac.createNewFile();
//            try (PrintWriter pw = new PrintWriter(sbrPrac)) {
//                pw.write("id;zkratka;nazev");
//            }
//        }
//        if (!sbrZam.exists()) {
//            sbrZam.createNewFile();
//            try (PrintWriter pw = new PrintWriter(sbrZam)) {
//                pw.write("os_cislo;jmeno;prijmeni;cislo_prac;tel_cislo");
//            }
//        }
        List<String> prac = Files.readAllLines(sbrPrac.toPath());
        List<String> zam = Files.readAllLines(sbrZam.toPath());
        List<Pracoviste> pracList = new ArrayList<>();
        List<Zamestnanec> zamList = new ArrayList<>();
        for (int i=1;i<prac.size(); i++) {
            String s = prac.get(i);
            String[] str = s.split(";");
            pracList.add(new Pracoviste(Integer.parseInt(str[0]), str[1], str[2]));
        }
        for (int i=1;i<zam.size(); i++) {
            String s = zam.get(i);
            String[] str = s.split(";");
            zamList.add(new Zamestnanec(Integer.parseInt(str[0]), str[1], str[2], Integer.parseInt(str[3]), Long.parseLong(str[4])));
        }
        return new TelefonniSeznam(pracList, zamList);
    }
    
    public List<String> formatPracovist() {
        if (pracoviste.size()==1) {
            return null;
        }
        List<String> prac1 = new ArrayList<>();
        for (int i=0; i<pracoviste.size(); i++) {
            
            prac1.add(i, pracoviste.get(i).toString());
           
        }
        for (int i=0; i<pracoviste.size();i++) {
        String[] abc = pracoviste.get(i).toString().split(";");
            for (int j=i+1; j<prac1.size();j++) {
                String[] def = prac1.get(j).split(";");
                if (abc[0].equals(def[0])) {
                    prac1.remove(i);
                }
            }
        }
        
        return prac1;
    }

    
    public List<String> formatZamestnancu() {
        if (zamestnanci.size()==1) {
            return null;
        }
        List<String> zam = new ArrayList<>();
        for (int i=0; i<zamestnanci.size(); i++) {
            
            zam.add(i, zamestnanci.get(i).toString());
           
        }
        for (int i=0; i<zamestnanci.size();i++) {
        String[] abc = zamestnanci.get(i).toString().split(";");
            
            for (int j=i+1; j<zam.size();j++) {
                String[] def = zam.get(j).split(";");
                if (abc[0].equals(def[0])) {
                    zam.remove(zamestnanci.get(i).toString());
                    
                }
            }
        }
        return zam;
    }
    
//    public List<String> zamestnanciVyhledavani(String criteria) {
//        List<String> list = formatZamestnancu();
//        List<String> abc = new ArrayList<>();
//        for (int i=0;i>list.size();i++) {
//            String s = list.get(i);
//            if (s.toLowerCase().contains(criteria.toLowerCase())) {
//                abc.add(s);
//            }
//        }
//        return abc;
//    }
}    
    
    

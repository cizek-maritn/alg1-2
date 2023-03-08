/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavodnik;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Dell
 */
public class ZavodVysledky {
    //neco jinyho nez Object
    private Object zavodnici;

    public ZavodVysledky(Object zavodnici) {
        this.zavodnici = zavodnici;
    }
    
    public ZavodVysledky getInstance(String regsoubor) throws FileNotFoundException, IOException {
        Path p = Path.of(regsoubor);
        p = p.toAbsolutePath().normalize();
        if (!Files.isRegularFile(p)) {
            throw new FileNotFoundException("soubor neexistuje" + p.toString());
        }
        Map<Integer, Zavodnik> zav = new TreeMap<>();
        List<String> lin = Files.readAllLines(p);
        Iterator<String> it = lin.iterator();
        it.next();
        while (it.hasNext()) {
            String str = it.next().trim();
            if (str.length()==0) continue;
            String[] dataStr = it.next().split(";");
            Zavodnik z = new Zavodnik(dataStr[1], dataStr[2], Integer.parseInt(dataStr[0]), Integer.parseInt(dataStr[4]));
            zav.put(z.getRegCislo(), z);
        }
        return new ZavodVysledky(zav);
    }
    
    public void zaznamenejDataStartu(String soubStart) throws IOException {
        Path p = Path.of(soubStart);
        p = p.toAbsolutePath().normalize();
        List<String> lin = Files.readAllLines(p);
        Iterator<String> it = lin.iterator();
        it.next();
        while (it.hasNext()) {
            String str = it.next().trim();
            if (str.length()==0) continue;
            String[] dataStr = it.next().split(";");
            Integer regCislo = Integer.valueOf(dataStr[0]);
            Zavodnik zav = zavodnici.get(regCislo);
            zav.zaznamenejCasStartu(dataStr[1]);
        }
    }
    
    public void zaznamenejDataCile(String soubStart) {
        
    }
    
    public String vysledkovaListina() {
        Collection<Zavodnik> dataZav = zavodnici.values();
        Collections.sort(dataZav, Zavodnik.COMP_DOBA_ZAVODU);
        StringBuilder sb = new StringBuilder();
        for (Zavodnik z : dataZav) {
            sb.append(z.toStringSVysledky());
            sb.append("\n");
        }
        return sb.toString();
    }
}

package apps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import telefony.TelefonniSeznam;

/**
 *
 * @Martin Cizek
 */
public class TelefonniSeznamApp {
    // testovaci soubory
    // "data/tel/prac.csv"
    // "data/tel/zam.csv"

    private static final Scanner sc = new Scanner(System.in);
    private static TelefonniSeznam telSez = null;
    private static boolean konecProgramu = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Vita vas TELEFONNI SEZNAM");
        try {
            vytvorTelefonniSeznam();
            konecProgramu = telSez == null;
        } catch (FileNotFoundException e) {
            System.out.println("Nektery ze vstupnich souboru neexistuje");
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Chyba pri nacitani vstupnich souboru");
            System.out.println("Nelze spustit aplikaci telefonnho seznamu");
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(-2);
        }
        // podarilo se nacist soubory, vytvorit telefonni seznam
        // hlavni ridici smycka programu
        while (!konecProgramu) {
            vypisHlavniMenuProgramu();
            int volba = nactiVolbu();
            obsluhaVolby(volba);
        } 
        System.out.println("Konec programu ...");
    }

    private static void obsluhaVolby(int volbaUzivatele) {
        switch (volbaUzivatele) {
            case 0:
                konecProgramu = true;
                break;
            case 1:
                vyhledavani();
                break;
            case 2:
                vsechnaPracoviste();
                break;
            case 3:
                vsichniZamestnanci();
                break;
            default:
                System.out.println("Zadana neplatna volba");
        }

    }

    private static void vypisHlavniMenuProgramu() {
        System.out.println("");
        System.out.println("Hlavni menu programu");
        System.out.println("1. Vyhledat zamestnace");
        System.out.println("2. Kontrolni vypis vsech zamestnancu");
        System.out.println("3. kontrolni vypis vsech pracovist");
        System.out.println("0. Konec programu");
    }

    private static int nactiVolbu() {
        int volba = -1;
        System.out.print("Zadej zvolenou polozku menu: ");
        try {
            // zkusim nacist cislo
            volba = sc.nextInt();
        } catch (InputMismatchException e) {
            // textovy retezec se nepodarilo prevest na cele cislo
            // cokoli jiného než číslo je neplatna volba
            volba = -1;
        } finally {
            // v kazdem pripade vyprazdnime vstup - respektive 
            // aktualni radek vstupu vcetne sekvence znak; konce radku
            sc.nextLine();
        }
        // je vracena platna celocislena hodnota
        return volba;
    }

    private static void vytvorTelefonniSeznam() throws IOException {
        System.out.println("Zadej název/cestu souboru se seznamem pracovišť ");
        String jmSoubPrac;
        jmSoubPrac = sc.nextLine().trim();
        System.out.println("Zadej název/cestu souboru se seznamem zaměstnanců ");
        String jmSoubZam;
        jmSoubZam = sc.nextLine().trim();
        telSez = TelefonniSeznam.getInstance(jmSoubPrac, jmSoubZam);
    }

    private static void vsechnaPracoviste() {
        System.out.println("");
        System.out.println("VYPIS PRACOVIST");
        System.out.println("Zkratka     Jmeno Pracoviste");
        List<String> prac = telSez.formatPracovist();
        for (String s : prac) {
            String[] str = s.split(";");
            System.out.println(str[1] + "       " + str[2]);
        }
    }

    private static void vsichniZamestnanci() {
        System.out.println("");
        System.out.println("VYPIS PRACOVNIKU");
        System.out.println("Jmeno     Prijmeni          telefonni cislo");
        List<String> zam = telSez.formatZamestnancu();
        for (String s : zam) {
            String[] str = s.split(";");
            System.out.println(str[1] + "       " + str[2] + "          " + str[4]);
        }
    }

    private static void vyhledavani() {
        System.out.println("");
        System.out.println("Zadej kriterium vyhledavani: ");
        String crit= sc.nextLine();
        System.out.println("VYPIS PRACOVNIKU PODLE KRITERIA: " + crit.toUpperCase());
        System.out.println("Jmeno     Prijmeni          telefonni cislo");
        List<String> list = telSez.formatZamestnancu();
        for (String s : list) {
            if (s.toLowerCase().contains(crit.toLowerCase())) {
            String[] str = s.split(";");
            
            System.out.println(str[1] + "       " + str[2] + "          " + str[4]);
            }
        }
    }

}

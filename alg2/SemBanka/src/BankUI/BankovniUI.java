package BankUI;

import BankApp.Banka;
import BankApp.Ucet;
import java.io.IOException;
import java.text.Collator;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class BankovniUI {

    private static final Scanner sc = new Scanner(System.in);
    private static Banka banka = null;
    private static boolean konec=false;
    private static final ResourceBundle CZ=ResourceBundle.getBundle("properties/text", new Locale("cs", "CZ"));
    private static final ResourceBundle EN=ResourceBundle.getBundle("properties/text", Locale.UK);
    private static ResourceBundle Akt=CZ;
    
    public static void main(String[] args) throws IOException {        
        ///bankovni soubory musi byt ve tvaru <jmeno><dolni podtrzitko>bank.dat
        boolean PathCheck=false;
        while (!PathCheck) {
            System.out.println("Zadej bankovní soubor/Enter bank file");
            String path = sc.nextLine();
            String[] check = path.split("_");
            int cLength=check.length-1;
            if (!check[cLength].equals("bank.dat")) {
                System.out.println("Špatný soubor/Incorrect file");
            } else {
                banka = Banka.getInstance(path);
                PathCheck=true;
            }
        }
        
        //menu
        do {
            vypisMenu();
            int volba = nactiVolbu();
            konec = obsluzVolbu(volba);
        } while(!konec);
        System.out.println(Akt.getString("konec"));
    }
    
    private static void vypisMenu() {
        System.out.println(Akt.getString("menu"));
        System.out.println(Akt.getString("1"));
        System.out.println(Akt.getString("2"));
        System.out.println(Akt.getString("3"));
        System.out.println(Akt.getString("4"));
        System.out.println(Akt.getString("5"));
        System.out.println(Akt.getString("6"));
        System.out.println(Akt.getString("7"));
        System.out.println(Akt.getString("0"));
    }
    
    private static int nactiVolbu() {
        int volba;
        try {
            volba = sc.nextInt(); 
        } catch (InputMismatchException ex) {
            volba = -1;
        }
        sc.nextLine();
        return volba;
    }
    
    private static boolean obsluzVolbu(int volba) throws IOException {
        switch (volba) {
                case 0: return true;
                case 1: novyUcet(); break;
                case 2: zmenaStavuKonta(); break;
                case 3: urok(); break;
                case 4: zmenaUdaju(); break;
                case 5: vypisKont(); break;
                case 6: vypisHistorie(); break;
                case 7: zmenaJazyka(); break;
                default: 
                    System.out.println(Akt.getString("incorrect"));
        }
        return false;
    }

    private static void novyUcet() throws IOException {
        System.out.println("");
        System.out.println(Akt.getString("newAcc"));
        String jmeno = sc.nextLine();
        String prijmeni = sc.nextLine();
        int rc=sc.nextInt();
        double sporeni=sc.nextDouble();
        double castka=sc.nextDouble();
        banka.novyUcet(jmeno, prijmeni, rc, sporeni, castka);
        System.out.println(Akt.getString("success"));
    }

    private static void zmenaStavuKonta() throws IOException {
        System.out.println("");
        System.out.println(Akt.getString("cislo"));
        boolean correct=false; int ucet=-1;
        while (!correct) {
            ucet = sc.nextInt();
            if (ucet>banka.getDalsiCislo() || ucet<= 0) {
                System.out.println(Akt.getString("neex"));
            } else {
                correct=true;
            }
        }
        System.out.println(Akt.getString("change"));
        double zmena=sc.nextDouble();
        banka.zmenaStavuKonta(ucet, zmena);
        System.out.println(Akt.getString("success"));
    }
    
    private static void urok() throws IOException {
        System.out.println("");
        System.out.println(Akt.getString("cislo"));
        boolean correct=false; int ucet=-1;
        while (!correct) {
            ucet = sc.nextInt();
            if (ucet>banka.getDalsiCislo() || ucet<= 0) {
                System.out.println(Akt.getString("neex"));
            } else {
                correct=true;
            }
        }
        banka.zuroceni(ucet);
        System.out.println(Akt.getString("success"));
    }
    
    private static void zmenaUdaju() throws IOException {
        System.out.println("");
        System.out.println(Akt.getString("cislo"));
        boolean correct=false; int ucet=-1;
        while (!correct) {
            ucet = sc.nextInt();
            if (ucet>banka.getDalsiCislo() || ucet<= 0) {
                System.out.println(Akt.getString("neex"));
            } else {
                correct=true;
            }
            
        }
        System.out.println(Akt.getString("details"));
        sc.nextLine();
        String jmeno = sc.nextLine();
        
        String prijmeni = sc.nextLine();
        
        double sporeni = sc.nextDouble();
        banka.zmenaUdaju(ucet, jmeno, prijmeni, sporeni);
        System.out.println(Akt.getString("success"));
    }
    
    private static void vypisKont() {
        System.out.println("");
        System.out.println(Akt.getString("sort"));
        boolean accept=false; int choice=-1;
        while (!accept) {
            choice = sc.nextInt();
            if (choice==0 || choice==1) {
                accept=true;
            } else {
                System.out.println(Akt.getString("neex"));
            }
        }
        System.out.println(Akt.getString("konta"));
        System.out.println(Akt.getString("head"));
        List<Ucet> list = banka.getKratkyList();
        if (choice==1) {
            list.sort(new UcetComparator());
        }
        for (Ucet u : list) {
            String s = u.toString();
            String[] str = s.split(";");
            System.out.println(str[0] + "       " + str[1] + "      " + str[2] + "      " + str[3] + "      " + str[4] + "      " + str[5]);
        }
        System.out.println("");
        System.out.println(Akt.getString("success"));
    }
    
    private static void vypisHistorie() {
        System.out.println("");
        System.out.println(Akt.getString("cislo"));
        boolean correct=false; int ucet=-1;
        while (!correct) {
            ucet = sc.nextInt();
            if (ucet>banka.getDalsiCislo() || ucet<= 0) {
                System.out.println(Akt.getString("neex"));
            } else {
                correct=true;
            }
        }
        System.out.println(Akt.getString("hist"));
        System.out.println(Akt.getString("head"));
        List<Ucet> list = banka.getCelyList();
        for (Ucet u : list) {
            String s = u.toString();
            String[] str = s.split(";");
            if (Integer.parseInt(str[0])==ucet) {
                System.out.println(str[0] + "       " + str[1] + "      " + str[2] + "      " + str[3] + "      " + str[4] + "      " + str[5]);
            }
        }
        System.out.println("");
        System.out.println(Akt.getString("success"));

    }

    private static void zmenaJazyka() {
        System.out.println("");
        if (Akt==CZ) Akt=EN;
        else Akt=CZ;
        System.out.println(Akt.getString("success"));
    }
    
    private static class UcetComparator implements Comparator<Ucet> {
        Collator coll = Collator.getInstance(Akt.getLocale());
        
        @Override
        public int compare(Ucet o1, Ucet o2) {
            return coll.compare(o1.getPrijmeni(), o2.getPrijmeni());
        }
        
    }
}

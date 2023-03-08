package cizek;

import cizek.CommandLine;
import java.io.IOException;
import java.util.Scanner;

public class CmdApp {

    private static final Scanner sc = new Scanner(System.in);
    private static CommandLine adr = new CommandLine(System.getProperty("user.dir"));
    
    public static void main(String[] args) throws IOException {
        boolean konecProgramu;
        do {
            CmdHead();
            String[] volba = nactiVolbu();
            konecProgramu = obsluzVolbu(volba);
        } while(!konecProgramu);
        System.out.println("Koncim.");
    }
    
    private static void CmdHead() throws IOException {
        System.out.println(adr.getAdr().getCanonicalFile() + " :");
    }
    
    private static String[] nactiVolbu() {
        String command=sc.nextLine() + " ";
        
        String[] volba=command.split("\\s+");
        return volba;  
    }
    
    private static boolean obsluzVolbu(String[] volba) throws IOException {
        switch (volba[0]) {
                case "exit": return true;
                case "help": adr.help(); break;
                case "dir": if (volba.length==1) {
                    adr.dir();
                } else adr.dir(volba[1]);
                break;
                case "cd": if (volba.length>1) {
                    adr.cd(volba[1]);
                } else chybneZadani();
                break;
                case "mkfile": if (volba.length>1) {
                    adr.mkfile(volba[1]);
                } else chybneZadani();
                break;
                case "mkdir": if (volba.length>1) {
                    adr.mkdir(volba[1]);
                } else chybneZadani();
                break;
                case "mkdirs": if (volba.length>1) {
                    adr.mkdirs(volba[1]);
                } else chybneZadani();
                break;
                case "rename": if (volba.length>2) {
                    adr.rename(volba[1], volba[2]);
                } else chybneZadani();
                break;
                
                default: 
                    System.out.println("Unknown command.");
                    System.out.println("");
        }
        return false;
    }

    private static void chybneZadani() {
        System.out.println("");
        System.out.println("Doslo k chybnemu zadani prikazu");
        System.out.println("");
    }

    
}

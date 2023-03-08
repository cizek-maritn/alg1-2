package apps;

import dedicnost.Osoba;
import dedicnost.Student;

public class testOsoby {

    public static void main(String[] args) {
        Osoba os = new Osoba("a", "b", 1234567890);
        System.out.println(os.toString());
        Student st = new Student(os, "N21341234");
        System.out.println(st);
        System.out.println(st.getJmeno());
        System.out.println(st.getPrijmeni());
        System.out.println(st.getRc());
        System.out.println(st.getStCislo());
    }
    
}

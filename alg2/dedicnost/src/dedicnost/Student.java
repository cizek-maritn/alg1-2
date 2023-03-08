/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dedicnost;

/**
 *
 * @author Dell
 */
public class Student extends Osoba{
    private final String stCislo;

    public Student(String stCislo, String jmeno, String prijmeni, int rc) {
        super(jmeno, prijmeni, rc);
        this.stCislo = stCislo;
    }
    
    public Student(Osoba os, String stCislo) {
        super(os.getJmeno(), os.getPrijmeni(), os.getRc());
        this.stCislo=stCislo;
    }

    public String getStCislo() {
        return stCislo;
    }

    @Override
    public String toString() {
        return "Student{" + "stCislo=" + stCislo + ", " + super.toString()+'}';
    }
    
    
}

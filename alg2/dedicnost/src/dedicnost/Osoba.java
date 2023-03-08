package dedicnost;

import java.util.Objects;


public class Osoba {
    private final String jmeno;
    private String prijmeni;
    private final int rc;

    public Osoba(String jmeno, String prijmeni, int rc) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.rc = rc;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public int getRc() {
        return rc;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    @Override
    public String toString() {
        return "Osoba{" + "jmeno=" + jmeno + ", prijmeni=" + prijmeni + ", rc=" + rc + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.jmeno);
        hash = 43 * hash + Objects.hashCode(this.prijmeni);
        hash = 43 * hash + this.rc;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Osoba other = (Osoba) obj;
        if (this.rc != other.rc) {
            return false;
        }
        if (!Objects.equals(this.jmeno, other.jmeno)) {
            return false;
        }
        return Objects.equals(this.prijmeni, other.prijmeni);
    }
    
    
}

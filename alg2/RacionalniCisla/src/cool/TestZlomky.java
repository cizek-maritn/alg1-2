package cool;


public class TestZlomky {

    public static void main(String[] args) {
        Zlomek z1=new Zlomek(1, -4);
        Zlomek z2= new Zlomek(3, -15);
        System.out.println("z1: " + z1);
        System.out.println("z2: " + z2);
        System.out.println(Zlomky.soucet(z1, z2));
        System.out.println(Zlomky.soucin(z1, z2));
        System.out.println(Zlomky.rozdil(z1, z2));
        System.out.println(Zlomky.podil(z1, z2));
    }
    
}

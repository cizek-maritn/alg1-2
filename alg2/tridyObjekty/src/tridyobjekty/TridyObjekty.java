package tridyobjekty;


public class TridyObjekty {


    public static void main(String[] args) {
        KasickaZnovuPouzitelna kasicka = new KasickaZnovuPouzitelna();
        
        kasicka.vlozit(100);
        long castka = kasicka.vysypat();
        System.out.println(castka);
    }
    
}

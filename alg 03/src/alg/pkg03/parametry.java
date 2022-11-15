package alg.pkg03;

/**
 *
 * @author Dell
 */
public class parametry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("pouze vypisu parametry/argumentyvse kterymi neco neco");
        for (int i = 0; i < args.length-1; i++) 
            System.out.println(args[i]);
        
        System.out.println("ppodruhe");
        for (String s : args)
            System.out.println(s);
        // neco s vypisem slov skrz command line, argumenty musej bejt zadany
        // pri startu so thats cool i guess                
    }
    
}

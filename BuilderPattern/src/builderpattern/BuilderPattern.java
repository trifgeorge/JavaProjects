/*
Moving the constructor logic out of the object class to a separate class referred  to as a builder class
 */
package builderpattern;

/**
 *
 * @author G
 */
public class BuilderPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pizza p=new Pizza.PizzaBuilder().branza(true).ciuperci(2).salam(true).sos(2).build();
        
        System.out.println(p);
    }
    
}

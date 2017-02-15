/*
 Decorator-attach additional responsibilities to an object dynamically(without having to change the original class source)
-doesn't affect other objcets
-disadv-uses similar kind of objects

 */
package decoratopattern;

/**
 *
 * @author G
 */
public class DecoratoPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Icecream ice=new HoneyDecorator(new NuttyDecorator(new SimpleIcecream()));
        System.out.println(ice.makeIcecream());
    }
    
}

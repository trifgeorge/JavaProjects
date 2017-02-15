/*
super class with multiple sub-classes and basesd on input 
 provides approach to code for interface rather than implementation
provides abstraction between implementation and client class through inheritance
 */
package factorypattern;

/**
 *
 * @author G
 */
public class FactoryPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MobileFactory mf=new MobileFactory();
        
        Lenovo len=(Lenovo)mf.createMobile("len");
        len.batteryPower();
        
        Samsung sam=(Samsung)mf.createMobile("sam");
        sam.pictureCpacity();
    }
    
}

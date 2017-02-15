/*
 When you have multiple objects(interfaces) connected and you want to easy the client job to use them
 */
package facade;

/**
 *
 * @author G
 */
public class FacadePattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Facade facade=new Facade();
        
        int x=3;
                
        System.out.println(facade.cubeX(x));
        System.out.println(facade.cubeXTimes2(x));
        System.out.println(facade.multipleBoth(x));
    }
    
}

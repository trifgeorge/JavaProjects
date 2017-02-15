/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorypattern;

/**
 *
 * @author G
 */
public class MobileFactory {
    
    public IMobile createMobile(String type){
        IMobile mob=null;
        if("len".equalsIgnoreCase(type)){
            mob=new Lenovo();
            System.out.println("Lenovo");
        }else if ("sam".equalsIgnoreCase(type)){
            mob=new Samsung();
            System.out.println("Samsung");
        }
        
        return mob;
    }
    
}

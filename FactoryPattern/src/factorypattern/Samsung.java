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
public class Samsung implements IMobile{

    @Override
    public void cost() {
        System.out.println("Samsung cost 100");
    }

    @Override
    public void pictureCpacity() {
        System.out.println("Samsung capacity 100");
    }

    @Override
    public void batteryPower() {
        System.out.println("Samsung power 100");
    }
    
}

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
public class Lenovo implements IMobile {

    @Override
    public void cost() {
        System.out.println("Lenovo cost 50");
    }

    @Override
    public void pictureCpacity() {
        System.out.println("Lenovo cp 50");
    }

    @Override
    public void batteryPower() {

        System.out.println("Lenovo power 50");
    }

}

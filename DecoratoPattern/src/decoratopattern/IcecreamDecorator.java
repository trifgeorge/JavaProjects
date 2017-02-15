/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoratopattern;

/**
 *
 * @author G
 */
public class IcecreamDecorator implements Icecream{

    protected Icecream specialIcecream;
    
    
    public IcecreamDecorator(Icecream specialIcecream){
        this.specialIcecream=specialIcecream;
    }
    @Override
    public String makeIcecream() {
        return specialIcecream.makeIcecream();
        
    }
    
}

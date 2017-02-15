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
public class NuttyDecorator extends IcecreamDecorator{

    public NuttyDecorator(Icecream specialIcecream) {
        super(specialIcecream);
    }
    @Override
    public String makeIcecream(){
        return specialIcecream.makeIcecream()+this.addNutty();
    }
    public String addNutty(){
        return "Nutty";
    }
    
    
    
}

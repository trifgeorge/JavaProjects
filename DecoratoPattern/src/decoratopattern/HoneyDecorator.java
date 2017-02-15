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
public class HoneyDecorator extends IcecreamDecorator{

    public HoneyDecorator(Icecream specialIcecream) {
        super(specialIcecream);
    }
    
    @Override
    public String makeIcecream(){
        return specialIcecream.makeIcecream()+addHoney();
    }

    private String addHoney() {
        return "Honey";
    }
    
    
}

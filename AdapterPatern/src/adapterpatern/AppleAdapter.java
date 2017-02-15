/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapterpatern;

/**
 *
 * @author G
 */
public class AppleAdapter extends Apple{
    private Orange orange;
    
    public AppleAdapter(Orange orange){
        this.orange=orange;
    }
//    public void getColor(String color){
//        orange.getOrangeColor(color);
//    }
//    
}

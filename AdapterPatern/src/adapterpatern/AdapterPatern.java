/*
 When you have 2 (different)interfaces and you need them to comunicate with eachother
ex:charges 
 */
package adapterpatern;

/**
 *
 * @author G
 */
public class AdapterPatern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Apple apple1=new Apple();
        apple1.getAppleColor("red");
        
        Orange orange=new Orange();
        AppleAdapter adapter=new AppleAdapter(orange);
        adapter.getAppleColor("green");
    }
    
}

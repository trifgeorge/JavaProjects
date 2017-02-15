/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

/**
 *
 * @author G
 */
public class Facade {
    
    public int cubeX(int x){
        Class1 class1=new Class1();
        return class1.doSomething(x);
    }
    
    public int cubeXTimes2(int x){
        Class1 class1=new Class1();
        Class2 class2=new Class2();
        
        return class2.doSomethingElse(class1, x);
    }
    
    public int multipleBoth(int x){
        Class1 class1=new Class1();
        Class2 class2=new Class2();
        Class3 class3=new Class3();
        
        return class3.doSomethingMore(class1, class2, x);
    }
    
}

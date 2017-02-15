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
public class Class3 {

    public int doSomethingMore(Class1 class1,Class2 class2,int x){
        return class1.doSomething(x)+class2.doSomethingElse(class1, x);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author G
 */
public class Java8Sort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        List<String> names1=new ArrayList();
        names1.add("Mehesh ");
        names1.add("Sureh ");
        names1.add("Ramesh ");
        names1.add("Naresh ");
        names1.add("Kalpesh ");
        
        List<String> names2=new ArrayList();
        names2.add("Mehesh ");
        names2.add("Sureh ");
        names2.add("Ramesh ");
        names2.add("Naresh ");
        names2.add("Kalpesh ");
        
        Java8Sort tester=new Java8Sort();
        System.out.println("Sort using java 7 syntax");
        tester.sortJava7(names1);
        System.out.println(names1);
        
        System.out.println("Sort using java 8 syntax");
        tester.sortJava8(names1);
        System.out.println(names1);
        
        
    }

    private void sortJava7(List<String> names1) {
        
        Collections.sort(names1, new Comparator<String>()
        {
            @Override
            public int compare(String s1,String s2){
                return s1.compareTo(s2);
            }
        });
    }

    private void sortJava8(List<String> names1) {
        Collections.sort(names1,(s1, s2) -> s1.compareTo(s2));
    }
    
}

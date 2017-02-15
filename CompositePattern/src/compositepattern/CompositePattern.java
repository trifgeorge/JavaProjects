/*
individaul and composote objetcs are trrated uniformaly
Base Component-interface or abstract class used to work with the objects in the comporistion(contains method common to all objects)
Leaf- defines the behavior for the elemnts in the compositon
Composite-it consists of leaf elements and implements the operations in base component 
 */
package compositepattern;

/**
 *
 * @author G
 */
public class CompositePattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Employee emp1=new Developer("John",1000);
        Employee emp2=new Developer("David",1500);
        Employee manager1=new Manager("Daniel",2500);
        manager1.add(emp1);
        manager1.add(emp2);
        Employee emp3=new Developer("Michel",200000);
        Manager generalManager=new Manager("Mark",50000);
        generalManager.add(emp3);
        generalManager.add(manager1);
        generalManager.print();
        
    }
    
}

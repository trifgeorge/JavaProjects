/*
 Composite class
 All common method delegates its operations to child objects
 it has mehtods to access and modify its children
 */
package compositepattern;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author G
 */
public class Manager implements Employee {

    private String name;
    private double salary;

    public Manager(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    ArrayList<Employee> employees = new ArrayList<>();

    @Override
    public void add(Employee emp) {
        employees.add(emp);
    }

    @Override
    public void remove(Employee emp) {
        employees.remove(emp);
    }

    @Override
    public Employee getChild(int i) {
        return employees.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void print() {
        System.out.println("-------");
        System.out.println("Name ="+getName());
        System.out.println("Salary=" +getSalary());
        System.out.println("--------");
        
        Iterator<Employee> empIterator=employees.iterator();
        while(empIterator.hasNext()){
            Employee emp=empIterator.next();
            emp.print();
        }
    }
}

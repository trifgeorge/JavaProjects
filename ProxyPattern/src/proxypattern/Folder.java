/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxypattern;

/**
 *
 * @author G
 */
public class Folder implements IFolder{

    @Override
    public void performOperations() {
        System.out.println("Performing operations on folder");    
    }
    
}

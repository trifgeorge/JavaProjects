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
public class ProxyTest {
    
    public static void main(String[] args){
        User u1=new User("dev","dev");
        FolderProxy folderProxy1=new FolderProxy(u1);
        folderProxy1.performOperations();
        
        User u2=new User("ad","sdad");
        FolderProxy folderProxy2=new FolderProxy(u2);
        folderProxy2.performOperations();
    }
}

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
public class FolderProxy implements IFolder{
    Folder folder;
    User user;

    public FolderProxy(User user){
        this.user=user;
    }
    @Override
    public void performOperations() {
        if(user.userName.equalsIgnoreCase("dev") && user.password.equalsIgnoreCase("dev")){
            this.folder=new Folder();
            folder.performOperations();
        }else{
            System.out.println("You don't have permition to access this folder");
        }
        
    }
}

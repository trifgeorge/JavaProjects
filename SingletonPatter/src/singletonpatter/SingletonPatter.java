/*
 * 
There should be only one instance allowed for this class
We should allow global point access to that single instance
Lazy initialization-no instance until we call getInstance()
Eager initialization-at the time of class loading
 */
package singletonpatter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author G
 */
public class SingletonPatter implements Cloneable,Serializable{
 
    
    private static SingletonPatter instance=new SingletonPatter();

    private static void print(String name, SingletonPatter obj) {
        
        System.out.println(String.format("Object:%s, Hashcode:%d",name,obj.hashCode()));
    }
    
    private SingletonPatter(){
        System.out.println("Creating...");
        if(instance!=null){
            //force to use getInstance()
            throw new RuntimeException("Can't create instance.Please use getInstance()");
        }
    }
    
    public static SingletonPatter getInstance(){
        return instance;
    }
    //Anti-serialization
    private Object readResolve(){
        System.out.println("applying  read resolve...");
        return instance;
    }
    @Override
    protected Object clone()throws CloneNotSupportedException{
        if(instance!=null){
            throw new CloneNotSupportedException("no clone please");
        }
        return super.clone();
    }
    
    
    public static void main(String[] args) throws ClassNotFoundException {
      
        
        try{
            // TODO code application logic here
            SingletonPatter s1=SingletonPatter.getInstance();
            SingletonPatter s2=SingletonPatter.getInstance();
            print("s1",s1);
            print("s2",s2);
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("tmp/s2.ser"));
            oos.writeObject(s2);
            
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream("tmp/s2.ser"));
            SingletonPatter s4=(SingletonPatter)ois.readObject();
            print("s4",s4);
            /*cloning
            try{
                SingletonPatter s3=(SingletonPatter)s2.clone();
                print("s3",s3);
            }catch (CloneNotSupportedException e){
                e.printStackTrace();
                
                
            }
                    */
            //SingletonPatter s3=new SingletonPatter();
            //System.out.println(s3.hashCode());
        }catch (IOException ex){
            Logger.getLogger(SingletonPatter.class.getName()).log(Level.SEVERE, null, ex);
        
        
    }
        //SingletonPatter s3=new SingletonPatter();
        //System.out.println(s3.hashCode());
        
    }
}
    
   


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ravindu Weerasinghe
 */
public class SynchronizeExample {
    public static void main(String[] args) {
        C a = new C();
        Thread t1 = new Thread(a,"Task A");
        Thread t2 = new Thread(a,"Task B");
        Thread t3 = new Thread(a,"Task C");
        t1.start();
        t2.start();
        t3.start();
        
    }
}

class C implements Runnable{
    
    public synchronized void run(){
        for(int i=0;i<3;i++){
            System.out.println("Current Thread: "+Thread.currentThread());
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(C.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

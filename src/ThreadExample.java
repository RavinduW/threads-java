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
public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
     A a = new A();
     B b = new B();
     a.start();
     a.join();
     a.sleep(2000);
     b.start();
     
    }
}

class A extends Thread{
    public void run(){
        System.out.println("Task A");
    }
}

class B extends Thread{
    public void run(){
        System.out.println("Task B");  
    }
}

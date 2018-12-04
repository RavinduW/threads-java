
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ravindu Weerasinghe
 */
public class Producer_Consumer {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Producer p = new Producer(list);
        Consumer c = new Consumer(list);
        
        p.start();
        c.start();
        
    }
}

//Thread for the producer
class Producer extends Thread{
    List<Integer> list = new ArrayList<Integer>();
    
    public Producer(List<Integer> list){ //constructor
        this.list = list;
    }
    
    public void run(){
        for(int i=0;i<=10;i++){
            try {
                produce(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void produce(int i) throws InterruptedException {
        synchronized(list){
        if(list.size()==1){
            System.out.println("Resource is full...");
            list.wait(); //since the resource is empty,list should wait
        }
        }
        
        synchronized(list){
            System.out.println("Produced->"+i);
            list.add(i);
            Thread.sleep(1000);
            list.notify(); //wakes up the monitor
        }
}
}//producer

//Thread for the consumer
class Consumer extends Thread{
    List<Integer> list = new ArrayList<Integer>();
    
    public Consumer(List<Integer> list){ //constructor
        this.list = list;
    }
    
    public void run(){
        for(int i=0;i<=10;i++){
            try {
                consume();
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized(list){
        if(list.size()==0){
            System.out.println("Resource is empty...");
            list.wait();
        }
        }
        
        synchronized(list){
            int x = list.remove(0);
            System.out.println("Consumed->"+x);
            Thread.sleep(1000);
            list.notify(); //wakes up the monitor
        }
}
}//producer
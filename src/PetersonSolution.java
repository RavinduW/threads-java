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
public class PetersonSolution {
    public static void main(String[] args)throws InterruptedException {
        Thread1 x = new Thread1();
        Thread2 y = new Thread2();
        
        x.start();
        y.start();
    }
}
class PetersonSol{
        static boolean interested[]=new boolean[2];
        int turn;
        
        public void enter_region(int processID) throws InterruptedException{
            int otherID;
            otherID = 1-processID;
            interested[processID]=true;
            turn = processID;
            
            while(turn==processID && interested[otherID]==true){
                
                System.out.println(processID+" waiting");
                Thread.sleep(2000);
            }
        }
        
        public void leave_region(int processID){
            interested[processID]=false;
            //System.out.println(interested[0]);
        }
    }
  
class Thread1 extends Thread{
    public void run(){
        PetersonSol p1 = new PetersonSol();
        
        try {
            p1.enter_region(0);
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Process one");
        p1.leave_region(0);
    }
}

class Thread2 extends Thread{
     public void run(){
        PetersonSol p1 = new PetersonSol();
        
        try {
            p1.enter_region(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Process two");
        p1.leave_region(1);
    }
}

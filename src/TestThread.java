
import java.util.logging.Level;
import java.util.logging.Logger;


public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<5;i++){
        System.out.println("B");
        }
        exThread.thread = Thread.currentThread();
        exThread e = new exThread("A");
        exThread e2 = new exThread("C");
        e.start();
        e.join();
        e2.start();
        
        
    } 
    
   static class exThread extends Thread{
       static Thread thread;
       String s;
       exThread(String s){
           this.s = s;
       }
       
        public void run(){
          /* try {
               thread.join();
           } catch (InterruptedException ex) {
               Logger.getLogger(TestThread.class.getName()).log(Level.SEVERE, null, ex);
           } */
            for(int i=0;i<5;i++){
                try {
                    System.out.println(s);
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TestThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }
}

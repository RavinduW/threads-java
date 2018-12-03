
public class MultiThread1 {
    public static void main(String[] args) throws InterruptedException {
        int [] x= {1,2,3,4,5,6,7,8,9,10};
        
        ethread e = new ethread(0,5,x);
        ethread f = new ethread(5,10,x);
        e.start();
        e.join();
        
        f.start();
        f.join();
        
        System.out.println(ethread.sum);
    }
    
    
    static class ethread extends Thread{
        static int sum=0;
        int y;
        int z;
        int u[];
      
        ethread(int y,int z,int u[]){
        this.y = y; 
        this.z = z;
        this.u = u;
        }
        public void run(){
          
            int total=0;
           
        
            for(int i=y;i<z;i++){
                
                total=total+u[i];
                //sum = sum+u[i];
        }
            
            //System.out.println(total);
            //System.out.println(sum);
            synchronized(ethread.class){
                sum = sum+total;
            }}
    
    
}
}

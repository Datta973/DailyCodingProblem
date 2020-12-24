/*

Problem statement :

Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.

*/

public class Day_10_JobScheduler{
    
    public static void main(String[] args){
        JobScheduler js1 = new JobScheduler(()->{
                                System.out.println("Job 1");
                           }, 3000); 
        JobScheduler js2 = new JobScheduler(()->{
                                System.out.println("Job 2");
                           }, 5000);
                           
        js1.start(); // prints Job 1 at 3 seconds
        js2.start(); // prints Job 2 at 5 seconds
    }
    
    static interface Callable{
        public void call();
    }
    
    // Asynchronous Job scheduler
    static class JobScheduler{
        private Thread thread;
        
        public JobScheduler(Callable function, int n){
            thread = new Thread(()->{
                try{
                    Thread.sleep(n);
                    function.call();   
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            });
        }
        
        public void start(){
            thread.start();
        }
    }
}
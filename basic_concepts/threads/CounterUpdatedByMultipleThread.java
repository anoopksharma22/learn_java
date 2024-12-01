class Counter{
    int counter;

    public synchronized void increment(){
        this.counter++;
    }
    
    public int get_counter(){
        return this.counter;
    }
}

public class CounterUpdatedByMultipleThread {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Runnable r = new Runnable() {
            public void run(){
                for( int i=0; i<100000; i++)
                c.increment();
            }
        };   

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        
        System.out.println(c.get_counter());
    }
}

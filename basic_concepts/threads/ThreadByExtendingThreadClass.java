class Thread1 extends Thread{
    public synchronized void run(){
        for(int i=0; i<10; i++){
            System.out.println("hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread2 extends Thread{
    public synchronized void run(){
        for(int i=0; i<10; i++){
            System.out.println("hi");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
}


public class ThreadByExtendingThreadClass{
    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        System.out.println("Priority od thread1 : " + t1.getPriority() );
        System.out.println("Priority od thread2 : " + t2.getPriority() );

        t1.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Priority of thread1 after setting to max: " + t1.getPriority() );

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
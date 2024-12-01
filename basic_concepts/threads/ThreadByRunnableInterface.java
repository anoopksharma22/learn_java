class Function1 implements Runnable{
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println("Hello");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Function2 implements Runnable{
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println("Hi");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadByRunnableInterface {
    public static void main(String[] args) throws InterruptedException {
        Function1 f1 = new Function1();
        Function2 f2 = new Function2();
        
        Thread t1 = new Thread(f1);
        Thread t2 = new Thread(f2);

        t1.start();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

        t1.join();
        t2.join();

    }
}

public class NotifyExample {
    public static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThread();
        thread.start();

        Thread.sleep(5_000);

        unLock();


    }

    public static void print() throws InterruptedException {
        synchronized (lock){
            lock.wait();
            System.out.println(Thread.currentThread().getName() + " has been unblocked");
        }
    }

    public static void unLock(){
            lock.notify();

    }

    public static class MyThread extends Thread{

        @Override
        public void run(){
            try {
                print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

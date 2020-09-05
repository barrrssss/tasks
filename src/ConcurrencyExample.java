public class ConcurrencyExample {
    public static void main(String[] args) throws InterruptedException {
        MyObject myObject = new MyObject();

        MyThread myThread1 = new MyThread(myObject);
        MyThread myThread2 = new MyThread(myObject);

        myThread1.start();
        myThread2.start();

        myThread1.join();
        myThread2.join();
    }

    public static class MyThread extends Thread {
        private MyObject myObject;

        public MyThread(MyObject myObject) {
            this.myObject = myObject;
        }

        @Override
        public void run() {
            myObject.doSmth();
        }
    }

    public static class MyObject {

        private int a;

        public void doSmth() {

            for (int i = 0; i < 10_000; i++) {
                incrementA();
            }

            System.out.println(a);
        }

        private synchronized void incrementA(){
            a++;
        }
    }
}

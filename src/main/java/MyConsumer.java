public class MyConsumer implements Runnable {
    MyBlockingArrayQueue myQueue;
    public MyConsumer(MyBlockingArrayQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        String myName = Thread.currentThread().getName();
        String data;

        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                data = myQueue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("данные забрал консьюмер " + myName + " " + data);
        }
    }
}

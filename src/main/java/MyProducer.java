import java.util.Date;

public class MyProducer implements Runnable {
    MyBlockingArrayQueue myQueue;
    public MyProducer(MyBlockingArrayQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        String myName = Thread.currentThread().getName();
        while (true) {
            try {
                Thread.sleep(5500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Date currentDate = new Date();
            try {
                myQueue.put("This setting by " + myName + " " + currentDate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Данные положил продюссер " + myName);
        }
    }
}

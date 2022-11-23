import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws InterruptedException {

        MyBlockingArrayQueue myQueue = new MyBlockingArrayQueue();

        Thread firstProd = new Thread(new MyProducer(myQueue));
        Thread secondProd = new Thread(new MyProducer(myQueue));
        Thread consumer = new Thread(new MyConsumer(myQueue));

        List<Thread> threadList = new ArrayList<>();
        threadList.add(firstProd);
        threadList.add(secondProd);
        threadList.add(consumer);

        Thread checker = new Thread(new Checker(threadList));
        checker.setDaemon(true);
        checker.start();
        Thread.sleep(1000);

        firstProd.start();
        Thread.sleep(2000);

        secondProd.start();
        Thread.sleep(2500);

        consumer.start();


    }
}

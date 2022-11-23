import java.util.ArrayList;
import java.util.List;

public class MyBlockingArrayQueue {
    List<String> list;
    public MyBlockingArrayQueue() {
        this.list = new ArrayList<>(1);
    }

    public synchronized void put(String string) throws InterruptedException {
        if (list.size() != 0) {
            System.out.println("Продюссер " + Thread.currentThread().getName() + " пытался положить данные (put), но ячейка занята. Запустил wait");
            wait();
        }
        if (list.size() == 0) {
            System.out.println("Продюссер " + Thread.currentThread().getName() + " успешно положил данные (put). Запустил notifyAll");
            notifyAll();
        }
        list.add(0, string);
    }

    public synchronized String take() throws InterruptedException {
        if (list.size() == 0) {
            System.out.println("Консьюмер " + Thread.currentThread().getName() + " пытался взять данные (take), но в листе пусто. Запустил wait");
            wait();
        }
        if (list.size() != 0) {
            System.out.println("Консьюмер " + Thread.currentThread().getName() + " успешно взял данные (take). Запустил notifyAll");
            notifyAll();
        }
        return list.remove(0);
    }


}

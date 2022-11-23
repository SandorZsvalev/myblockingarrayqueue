import java.util.*;

public class Checker implements Runnable {
    List<Thread> threadList;
    public Checker(List<Thread> threadList) {
        this.threadList = threadList;
    }

    @Override
    public void run() {
        Map<String, String> threadStatesOld = new HashMap<>();
        while (true) {
            Map<String, String> threadStatesNew = new HashMap<>();
            threadList.stream().forEach(
                    Thread -> threadStatesNew.put(Thread.getName(), Thread.getState().toString())
            );
            if (!threadStatesOld.isEmpty()) {
                for (Map.Entry<String, String> pair : threadStatesOld.entrySet()) {
                    String nameThread = pair.getKey();
                    String stateThread = pair.getValue();
                    if (!stateThread.equals(threadStatesNew.get(nameThread))) {
                        System.out.println("состояние " + nameThread + " изменилось: " + threadStatesNew.get(nameThread));
                    }
                }
            }
            threadStatesOld = threadStatesNew;
        }
    }
}

import java.util.Date;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        final PriorityQueue<Integer> storage = new PriorityQueue<>();
        ScheduledExecutorService extractScheduler = Executors.newSingleThreadScheduledExecutor();
        ExecutorService addExecutor = Executors.newSingleThreadExecutor();
        Runnable taskExtract = () -> {
            synchronized (storage) {
                if (storage.isEmpty()) {
                    Date date = new Date();
                    System.out.println(date.toString()  + "Set is empty");
                } else {
                    int num = storage.poll();
                    Date date = new Date();

                    System.out.println(date.toString() + num);
                }
            }
        };
        Runnable taskAdd = () -> {
            while(true) {
                Scanner in = new Scanner(System.in);
                System.out.print("Input a number: ");
                int num = in.nextInt();
                synchronized (storage) {
                    storage.add(num);
                }
            }
        };
        addExecutor.submit(taskAdd);
        extractScheduler.scheduleAtFixedRate(taskExtract, 0, 5, TimeUnit.SECONDS);
    }
}

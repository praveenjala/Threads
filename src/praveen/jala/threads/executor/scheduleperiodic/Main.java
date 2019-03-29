package praveen.jala.threads.executor.scheduleperiodic;

import org.omg.CORBA.TIMEOUT;

import java.sql.Time;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Main: Starting at :%s\n", new Date());
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);

        Task task = new Task("Task");
        ScheduledFuture<?> future = scheduledThreadPoolExecutor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);

        for(int i=0; i<10; i++){
            System.out.printf("Main: Delay: %d\n", future.getDelay(TimeUnit.MILLISECONDS));
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduledThreadPoolExecutor.shutdown();
        System.out.printf("Main: Finished at: %s\n", new Date());
    }
}
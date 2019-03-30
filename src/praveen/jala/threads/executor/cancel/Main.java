package praveen.jala.threads.executor.cancel;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *  -- If the task has finished or has been canceled earlier or it can't be canceled for other
 *     reasons, the method will return the false value and the task won't be canceled.
 *
 *  -- If the task is waiting in the executor to get a Thread object that will execute it,
 *     the task is canceled and never begins its execution. If the task is already running,
 *     it depends on the parameter of the method. The cancel() method receives a
 *     Boolean value as a parameter. If the value of that parameter is true and the task
 *     is running, it will be canceled. If the value of the parameter is false and the task is
 *     running, it won't be canceled.
 *
 *  -- If you use the get() method of a Future object that controls a task that has been canceled,
 *     the get() method will throw a CancellationException exception.
 */

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Task task = new Task();
        System.out.printf("Main: Executing the task\n");
        Future<String> result = executor.submit(task);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: Cancelling the task\n");
        result.cancel(false);
        System.out.printf("Main: Cancelled: %s\n", result.isCancelled());
        System.out.printf("Main: Done: %s\n", result.isDone());
        executor.shutdown();
        System.out.printf("Main: The executor has finished");

    }
}

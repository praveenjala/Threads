package praveen.jala.threads.executor.invokeall;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        List<Task> taskList = new ArrayList<>();
        for(int i=0; i<3; i++){
            taskList.add(new Task("Task "+i));
        }
        List<Future<Result>> resultList = null;

        try {
            resultList = executor.invokeAll(taskList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.printf("Main: Printing the results\n");
        for(int i=0; i<resultList.size(); i++){
            Future<Result> resultFuture = resultList.get(i);
            try {
                Result result = resultFuture.get();
                System.out.println(result.getName() +": " + result.getValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }


        }
    }
}

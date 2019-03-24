package praveen.jala.threads.executor.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();
        Random random = new Random();
        for(int i=0; i<10; i++){
            Integer integer = random.nextInt(10);
            Future<Integer> future = executor.submit(new FactorialCalculator(integer));
            resultList.add(future);
        }
        do{
            System.out.printf("Main: Number of completed task: %d\n", executor.getCompletedTaskCount());
            for(int i=0; i < 10; i++){
                Future<Integer> result = resultList.get(i);
                System.out.printf("Main: Task %d: %s\n", i, result.isDone());
            }
            try{
                TimeUnit.MILLISECONDS.sleep(20);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }while(executor.getCompletedTaskCount() < resultList.size());
        System.out.printf("Main: Results\n");
        for(int i=0; i<10; i++){
            Future<Integer> result = resultList.get(i);
            try {
                Integer resultVal = result.get();
                System.out.printf("Main: Task %d: %d\n", i, resultVal);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}

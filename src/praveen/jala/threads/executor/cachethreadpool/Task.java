package praveen.jala.threads.executor.cachethreadpool;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable{

    private String name;
    private Date initDate;

    public Task(String name){
        this.name = name;
        initDate = new Date();
    }

    @Override
    public void run(){
        System.out.printf("%s: Task %s: Created on: %s\n", Thread.currentThread().getName(), name, initDate);
        System.out.printf("%s: Task %s: Started on: %s\n", Thread.currentThread().getName(), name, new Date());
        long duration = (long) Math.random()*10;
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: Task %s: Finished at: %s\n", Thread.currentThread().getName(), name, new Date());
    }
}

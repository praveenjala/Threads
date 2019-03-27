package praveen.jala.threads.executor.schedulethreadpool;

import java.sql.Time;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<String> {
    private String name;

    public Task(String name){
        this.name = name;
    }
    @Override
    public String call() throws Exception {
        System.out.printf("%s: Task started at: %s\n", this.name, new Date());
        long duration = (long) (Math.random()*10);
        TimeUnit.SECONDS.sleep(duration);
        System.out.printf("%s: Task duration: %d, ended at: %s\n", this.name, duration, new Date());
        return "Hello World";
    }
}

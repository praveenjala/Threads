package praveen.jala.threads.executor.scheduleperiodic;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Runnable {
    private String name;
    public Task(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s: started at %s\n", this.name, new Date());
    }
}

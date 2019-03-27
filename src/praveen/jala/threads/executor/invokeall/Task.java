package praveen.jala.threads.executor.invokeall;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<Result> {
    private String name;

    public Task(String name){
        this.name = name;
    }

    @Override
    public Result call() throws Exception {
        System.out.printf("%s: Starting\n", this.name);
        long duration = (long) Math.random()*10;
        TimeUnit.SECONDS.sleep(duration);
        int value =0;
        for(int i=0; i<5; i++){
            value += (int)Math.random()*100;
        }
        Result result = new Result();
        result.setName(this.name);
        result.setValue(value);
        return result;
    }
}

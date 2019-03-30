package praveen.jala.threads.executor.cancel;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {

    @Override
    public String call() throws Exception {
        while(true){
            System.out.printf("Task: test\n");
            Thread.sleep(100);
        }
    }
}

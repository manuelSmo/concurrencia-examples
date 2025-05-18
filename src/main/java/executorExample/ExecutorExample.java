package executorExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(() -> doLongWork("hi 1 "));
        service.execute(() -> doLongWork("hi 2 "));
        service.execute(() -> doLongWork("hi 3 "));
        service.execute(() -> doLongWork("hi 4 "));
        service.execute(() -> doLongWork("hi 5 "));

        service.shutdown();
    }

    private static void doLongWork(String hola){
        System.out.println("Running " + hola + Thread.currentThread().getName());
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

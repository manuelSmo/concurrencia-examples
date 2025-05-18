package executorExample;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(10);
        Future<String> future = service.submit(() -> doLongWork("hi 1 "));
        System.out.println(future.get());

        Future<String> future2 = service.submit(() -> doLongWork("hi 2 "));
        System.out.println(future2.get());

        Future<String> future3 = service.submit(() -> doLongWork("hi 3 "));
        System.out.println(future3.get());

        service.shutdown();
    }

    private static String doLongWork(String hola){
        System.out.println("Running " + hola + Thread.currentThread().getName());
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "done " + hola;
    }
}

package executorExample;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<String> future = service.submit( () -> {
            Thread.sleep(2000);
            return "Resultado final";
        });

        System.out.println("Esperando .......");
        var result = future.get();
        System.out.println(result);
    }
}

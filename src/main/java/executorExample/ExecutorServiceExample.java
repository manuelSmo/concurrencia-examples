package executorExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);

        Runnable task1 = () -> System.out.println("Tarea 1 ejecutada por: " + Thread.currentThread().getName());
        Runnable task2 = () -> System.out.println("Tarea 2 ejecutada por: " + Thread.currentThread().getName());

        service.submit(task1);
        service.submit(task2);

        service.shutdown();
    }
}

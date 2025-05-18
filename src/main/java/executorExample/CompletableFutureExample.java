package executorExample;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hola desde Completable Future";
        });

        future.thenAccept(resultado -> System.out.println("Resultado: " + resultado));
        System.out.println("Esto se imprime sin bloquear");
    }
}

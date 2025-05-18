package executorExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class PrincipalExecutor {

    public static void main(String[] args) {
        var flujo = Stream.of("tarea1", "tarea2", "tarea3");

        ExecutorService service = Executors.newCachedThreadPool();

        flujo.map(Tarea::new).forEach(service::execute);
    }
}
